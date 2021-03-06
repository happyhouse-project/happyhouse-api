package com.ssafy.happyhouse.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HouseDeal implements Comparable<HouseDeal>{

	/**
	 * 아파트 및 주택 번호
	 * */
	private String no;
	
	/**
	 * 거래가격
	 * */
	private String dealAmount;
	
	/**
	 * 거래가격(int)
	 * */
	private int deal;
	
	/**
	 * 거래연도
	 * */
	private String dealYear;
	
	/**
	 * 거래 월
	 * */
	private String dealMonth;
	
	/**
	 * 거래 일
	 * */
	private String dealDay;
	
	/**
	 * 거래 면적
	 * */
	private String area;
	
	/**
	 * 층
	 * */
	private String floor;

	@Override
	public int compareTo(HouseDeal o) {
		return Integer.compare(o.deal, this.deal); // 가격별 내림차순 정렬
	}
	
}
