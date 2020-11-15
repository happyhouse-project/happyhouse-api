package com.ssafy.happyhouse.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dao.MemberDao;
import com.ssafy.happyhouse.model.Member;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	MemberDao memberDao;

	@Override
	public void register(Member member) {
		memberDao.register(member);
	}

	@Override
	public ArrayList<Member> list() {
		return memberDao.list();
	}

	@Override
	public void modifyMember(Member member) {
		memberDao.modifyMember(member);
	}

	@Override
	public int inactiveMember(int id) {
		return memberDao.inactiveMember(id);
	}

	@Override
	public Member doLogin(String email, String password) {
		return memberDao.doLogin(email, password);
	}

	@Override
	public Member selectOne(int id) {
		return memberDao.selectOne(id);
	}
}
