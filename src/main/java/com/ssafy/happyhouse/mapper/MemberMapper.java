package com.ssafy.happyhouse.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ssafy.happyhouse.model.Member;

@Mapper
@Repository
public interface MemberMapper {
	
	void register(Member member); // 회원 생성

	ArrayList<Member> list(); // 회원 리스트

	void modifyMember(Member member); // 회원 수정

	int inactiveMember(int id); // 회원 비활성화

	Member doLogin(@Param("email")String email, @Param("password")String password); // 로그인 시도

	Member selectOne(int id); // 회원 상세검색

}
