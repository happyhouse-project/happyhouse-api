package com.ssafy.happyhouse.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.happyhouse.mapper.MemberMapper;
import com.ssafy.happyhouse.model.Member;

@Repository
public class MemberDaoImpl implements MemberDao {

	@Autowired
	MemberMapper memberMapper;
	
	@Override
	public void register(Member member) {
		memberMapper.register(member);
	}

	@Override
	public ArrayList<Member> list() {
		return memberMapper.list();
	}

	@Override
	public void modifyMember(Member member) {
		memberMapper.modifyMember(member);
	}

	@Override
	public void inactiveMember(int id) {
		memberMapper.inactiveMember(id);
	}

	@Override
	public Member doLogin(String email, String password) {
		return memberMapper.doLogin(email, password);
	}
}
