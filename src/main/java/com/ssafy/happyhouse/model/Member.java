package com.ssafy.happyhouse.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Member {
	
	/**
	 * 회원 아이디
	 * */
	private int id;
	
	/**
	 * 회원 이메일
	 * */
	private String email;
	
	/**
	 * 회원 비밀번호
	 * */
	private String password;
	
	/**
	 * 회원 이름
	 * */
	private String name;
	
	/**
	 * 회원 연락처
	 * */
	private String phone;
	
	/**
	 * 회원 주소
	 * */
	private String address;
	
	/**
	 * 회원 권한
	 * */
	private int auth;
	
	/**
	 * 회원 생성일
	 * */
	private String createDate;	
	
	/**
	 * 회원 인증 키
	 * */
	private String authKey;
	
}
