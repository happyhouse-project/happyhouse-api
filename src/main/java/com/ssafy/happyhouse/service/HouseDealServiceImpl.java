package com.ssafy.happyhouse.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dao.HouseDealDao;
import com.ssafy.happyhouse.model.HouseDeal;

@Service
public class HouseDealServiceImpl implements HouseDealService{

	@Autowired
	HouseDealDao houseDealDao;
	
	@Override
	public List<HouseDeal> searchByDongAndAptName(String aptName, String dong) { // 동과 아파트 이름정보를 가지고 실거래내역 검색
		 
		List<HouseDeal> houseDeals = houseDealDao.searchByDongAndAptName(aptName, dong);
		
		// dealAmount -> trim처리
		for(int i=0; i<houseDeals.size(); i++) {
			String deal = houseDeals.get(i).getDealAmount().trim().replace(",", "");
			houseDeals.get(i).setDeal(Integer.parseInt(deal));
		}
		
		// 정렬 처리
		Collections.sort(houseDeals, Collections.reverseOrder());
		
		return houseDeals;
	}

	@Override
	public int searchDealAmountByDongAndAptName(String aptName, String dong) {
		int deal = Integer.parseInt(
				houseDealDao
				.searchDealAmountByDongAndAptName(aptName, dong)
				.trim().replace(",", ""));
		return deal;
	}
}
