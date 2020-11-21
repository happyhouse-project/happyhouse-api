package com.ssafy.happyhouse.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssafy.happyhouse.model.HouseDeal;

@Repository
public interface HouseDealDao {

	List<HouseDeal> searchByDongAndAptName(String aptName, String dong); // 아파트 이름과 동 정보를 이용해서 거래정보 가져옴

	String searchDealAmountByDongAndAptName(String aptName, String dong);
}
