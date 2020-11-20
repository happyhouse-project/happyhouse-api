package com.ssafy.happyhouse.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dao.MemberDao;
import com.ssafy.happyhouse.model.Member;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	MemberDao memberDao;

	PasswordEncoder passwordEncoder;
	
	public MemberServiceImpl(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder; 
	}
	
	@Override
	public void register(Member member) {
		
		// 패스워드 해싱(암호화)
		String encodedPassword = passwordEncoder.encode(member.getPassword());
		
		member.setPassword(encodedPassword);
		
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
		Member member = memberDao.selectOneByEmail(email);
		
		if(member == null) { // 해당 이메일이 존재하지 않는 경우
			return null;
		}
		
		if(!passwordEncoder.matches(password, member.getPassword())) { // 패스워드가 일치하지 않은 경우
			return null;
		}
		
		return member;
	}

	@Override
	public Member selectOne(int id) {
		return memberDao.selectOne(id);
	}

	@Override
	public Member selectOneByEmail(String email) {
		return memberDao.selectOneByEmail(email);
	}
}
