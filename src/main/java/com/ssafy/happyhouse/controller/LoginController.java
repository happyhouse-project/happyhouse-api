package com.ssafy.happyhouse.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.LoginRequest;
import com.ssafy.happyhouse.model.LoginResponse;
import com.ssafy.happyhouse.model.Member;
import com.ssafy.happyhouse.service.MemberService;
import com.ssafy.happyhouse.utils.JWTUtil;

import io.jsonwebtoken.Claims;

@RestController
@CrossOrigin("*")
public class LoginController {

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private JWTUtil jwtUtil;
	
	Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	// 1. login처리
	@PostMapping("/login")
	public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest resource) throws URISyntaxException {
		
		String email = resource.getEmail();
		String password = resource.getPassword();
		
		Member member = memberService.doLogin(email, password);
		
		if(member == null) { // member정보가 없는 경우 --> 응답코드 404
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
		}
		
		if(member.getAuth() == 0) { // 인증되지 않은 계정인 경우 --> 응답코드 401
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		
		// 해당 유저정보를 가지고 token생성
		String accessToken = jwtUtil.createToken(member.getId(), member.getName());
		
		logger.info(accessToken);
		
		LoginResponse loginResponse = LoginResponse.builder().accessToken(accessToken).build();
		
		String url = "/login";
		return ResponseEntity.created(new URI(url)).body(loginResponse);
	}
	
	// 2. login되어있는 유저정보 
	@PostMapping("/loginUser")
	public Member loginUser(Authentication authentication) {
		Claims claims = (Claims) authentication.getPrincipal(); // claim정보 리턴
		
		int mid = claims.get("mid", Integer.class); // claim에서 mid라는 키값으로 member id값 얻어옴
		
		Member loginMember = memberService.selectOne(mid);
		
		return loginMember;
		
	}
}