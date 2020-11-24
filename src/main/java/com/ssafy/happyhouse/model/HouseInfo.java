package com.ssafy.happyhouse.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HouseInfo {
	
	/**
	 * 아파트 및 주택 번호
	 * */
	private String no;
	
	/**
	 * 아파트 및 주택 법정동
	 * */
	private String dong;
	
	/**
	 * 아파트 및 주택명
	 * */
	private String aptName;
	
	/**
	 * 아파트 및 주택 시 코드
	 * */
	private String code;
	
	/**
	 * 아파트 및 주택 건축연도
	 * */
	private String buildYear;
	
	/**
	 * 아파트 및 주택 지번
	 * */
	private String jibun;
	
	/**
	 * 아파트 및 주택 위도
	 * */
	private String lat;
	
	/**
	 * 아파트 및 주택 경도
	 * */
	private String lng;
	
	/**
	 * 아파트 및 주택 이미지
	 * */
	private String img;
	
	/**
	 * 아파트 및 주택 실거래 가격정보 리스트
	 * */
	private List<HouseDeal> deals;
	
	/**
	 * 아파트 가격 대푯값
	 * */
	private int deal;
	
	/**
	 * 아파트 조회수
	 * */
	private int hit;
}
