package com.ssafy.happyhouse.service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.mail.MessagingException;

import com.ssafy.happyhouse.model.Member;

public interface MemberService {

	void register(Member member) throws MessagingException, UnsupportedEncodingException; // 회원 생성
 
	ArrayList<Member> list(); // 회원 리스트

	void modifyMember(Member member); // 회원 수정

	int inactiveMember(int id); // 회원 비활성화

	Member doLogin(String email, String password); // 로그인 시도

	Member selectOne(int id); // 한명의 회원 검색

	Member selectOneByEmail(String email); // 회원 이메일을 이용한 상세검색

	void updateAuth(String email, String key); // 회원 인증 후 처리
}
