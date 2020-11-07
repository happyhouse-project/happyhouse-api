package com.ssafy.happyhouse.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Notice {
	
	/**
	 * 공지 아이디
	 * */
	private int id;
	
	/**
	 * 공지 제목
	 * */
	private String title;
	
	/**
	 * 공지 내용
	 * */
	private String content;
	
	/**
	 * 공지 작성자
	 * */
	private String writer;
	
	/**
	 * 공지 작성일
	 * */
	private String writeDate;
	
	
	
}
