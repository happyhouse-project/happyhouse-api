package com.ssafy.happyhouse.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Review {
	
	/**
	 * 리뷰 아이디
	 * */
	private int id;
	
	/**
	 * 리뷰 작성자 아이디
	 * */
	private int writerId;
	
	/**
	 * 리뷰 작성자 이름
	 * */
	private String writer;
	
	/**
	 * 리뷰 아파트 번호
	 * */
	private int houseNo;
	
	/**
	 * 리뷰 내용
	 * */
	private String content;
	
	/**
	 * 리뷰 평정
	 * */
	private double rating;
	
	/**
	 * 리뷰 작성일
	 * */
	private String writeDate;
}
