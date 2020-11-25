package com.ssafy.happyhouse.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Accident {
	
	/**
	 * 범죄 번호
	 * */
	private int id;
	
	/**
	 * 범죄 건수
	 * */
	private int crimeCases;
	
	/**
	 * 화재 건수
	 * */
	private int fireCases;
	
	/**
	 * 교통사고 건수
	 * */
	private int trafficCases;
	
	/**
	 * 안전 지수
	 * */
	private double safety;
}