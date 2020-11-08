package com.ssafy.happyhouse.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.happyhouse.model.Member;
import com.ssafy.happyhouse.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	private final static String MEMBER_PATH = "member/";
	private final static String LOGIN_PATH = "login/";
	
	@GetMapping("/list")
	public String list(Model model) {
		List<Member> list = memberService.list();
		model.addAttribute("list", list);
		return MEMBER_PATH+"memberList";
	}
	
	@GetMapping("/register")
	public String register() {
		return LOGIN_PATH+"register";
	}
	
	@PostMapping("/registerProcess")
	public String registerProcess(@ModelAttribute Member member) {
		member.setAuth(1);
		memberService.register(member);
		return LOGIN_PATH+"registerSuccess";
	}
	
	@GetMapping("/login")
	public String loginProcess() {
		return LOGIN_PATH+"login";
	}
	
	@PostMapping("/loginProcess")
	public String loginProcess(HttpSession session, HttpServletRequest req) {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		Member member = memberService.doLogin(email, password);
		
		session.setAttribute("member", member);
		return LOGIN_PATH+"loginSuccess";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.setAttribute("member", null);
		return LOGIN_PATH+"logout";
	}
	
	@GetMapping("/modify")
	public String modify() {
		return LOGIN_PATH+"register";
	}

	@GetMapping("/forgotPassword")
	public String forgotPassword() {
		return MEMBER_PATH+"forgotPassword";
	}
	
	
	
}
