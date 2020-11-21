package com.ssafy.happyhouse.service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dao.MemberDao;
import com.ssafy.happyhouse.model.Member;
import com.ssafy.happyhouse.utils.MailUtil;
import com.ssafy.happyhouse.utils.TempKeyUtil;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	MemberDao memberDao;
	
	@Autowired
	private JavaMailSender mailSender;

	PasswordEncoder passwordEncoder;
	
	Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);
	
	public MemberServiceImpl(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder; 
	}
	
	@Override
	public void register(Member member) throws MessagingException, UnsupportedEncodingException {
		
		// 패스워드 해싱(암호화)
		String encodedPassword = passwordEncoder.encode(member.getPassword());
		
		member.setPassword(encodedPassword);
		
		// autoKey생성
        String authKey = new TempKeyUtil().getKey(50, false);        
        member.setAuthKey(authKey);
		
		// mail 작성 관련
        MailUtil sendMail = new MailUtil(mailSender);

        sendMail.setSubject("[happyhouse] 회원가입 이메일 인증");
        sendMail.setText(new StringBuilder().append("<h1>[이메일 인증]</h1>")
                .append("<p>아래 링크를 클릭하시면 이메일 인증이 완료됩니다.</p>")
                .append("<a href='http://localhost:8080/registerConfirm?email=")
                .append(member.getEmail())
                .append("&authKey=")
                .append(authKey)
                .append("' target='_blank'>이메일 인증 확인</a>")
                .toString());
        sendMail.setFrom("doingnow94@gmail.com ", "happyhouse");
        sendMail.setTo(member.getEmail());
        sendMail.send();
        
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

	@Override
	public void updateAuth(String email, String key) {
		memberDao.updateAuth(email, key);
	}
}
