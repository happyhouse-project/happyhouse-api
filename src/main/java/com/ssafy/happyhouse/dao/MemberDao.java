package com.ssafy.happyhouse.dao;

import java.util.ArrayList;

import com.ssafy.happyhouse.model.Member;

public interface MemberDao {

	void register(Member member); // 회원 생성

	ArrayList<Member> list(); // 회원 리스트

	void modifyMember(Member member); // 회원 수정

	int inactiveMember(int id); // 회원 비활성화

	Member doLogin(String email, String password); // 로그인 시도

	Member selectOne(int id); // 회원 상세검색

	Member selectOneByEmail(String email); // 회원 이메일을 이용한 상세검색

	void updateAuth(String email, String key);
}
