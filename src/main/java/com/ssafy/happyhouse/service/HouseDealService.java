package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.model.HouseDeal;

public interface HouseDealService {

	List<HouseDeal> searchByDongAndAptName(String aptName, String dong); // 아파트 이름과 동 정보를 이용해서 거래정보 가져옴

	int searchDealAmountByDongAndAptName(String aptName, String dong); // 아파트 이름과 동 정보를 이용해서 거래가격 가져옴
}
