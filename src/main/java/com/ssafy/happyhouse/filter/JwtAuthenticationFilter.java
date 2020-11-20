package com.ssafy.happyhouse.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.ssafy.happyhouse.utils.JWTUtil;

import io.jsonwebtoken.Claims;

public class JwtAuthenticationFilter extends BasicAuthenticationFilter{
	
	private JWTUtil jwtUtil;

	public JwtAuthenticationFilter(AuthenticationManager authenticationManager, JWTUtil jwtUtil) {
		super(authenticationManager);
		this.jwtUtil = jwtUtil;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		Authentication authentication = getAuthentication(request); // 요청정보에서 인증정보 얻기
		 
		if(authentication != null) { // 인증정보가 있다면 context에 인증정보 추가
			SecurityContext context = SecurityContextHolder.getContext();
			context.setAuthentication(authentication);
		}
		chain.doFilter(request, response);
	}

	private Authentication getAuthentication(HttpServletRequest request) {
		String token = request.getHeader("Authorization"); // header에서 "Authorization"를 키값으로 가지고 있는 token얻기
		if(token == null) { return null; }
		
		Claims claims = jwtUtil.getClaims(token.substring("Bearer ".length())); // Bearer의 길이만큼 token 
		
		return new UsernamePasswordAuthenticationToken(claims, null);
	}

	
}
