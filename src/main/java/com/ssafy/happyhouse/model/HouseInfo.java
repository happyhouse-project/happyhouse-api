package com.ssafy.happyhouse.model;

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
	 * 아파트 및 주택 번호
	 * */
	private String dong;
	private String aptName;
	private String code;
	private String buildYear;
	private String jibun;
	private String lat;
	private String lng;
	private String img;
	private String deal;
}
