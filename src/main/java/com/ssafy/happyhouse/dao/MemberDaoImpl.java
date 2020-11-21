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
	public int inactiveMember(int id) {
		return memberMapper.inactiveMember(id);
	}

	@Override
	public Member doLogin(String email, String password) {
		return memberMapper.doLogin(email, password);
	}

	@Override
	public Member selectOne(int id) {
		return memberMapper.selectOne(id);
	}

	@Override
	public Member selectOneByEmail(String email) {
		return memberMapper.selectOneByEmail(email);
	}

	@Override
	public void updateAuth(String email, String key) {
		memberMapper.updateAuth(email, key);
	}
}
