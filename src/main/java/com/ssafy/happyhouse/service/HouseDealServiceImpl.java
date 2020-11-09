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
	public List<HouseDeal> searchByDongAndAptName(String aptName, String dong) {
		 
		List<HouseDeal> houseDeals = houseDealDao.searchByDongAndAptName(aptName, dong);
		
		// dealAmount -> trim처리
		for(int i=0; i<houseDeals.size(); i++) {
			String dealAmount = houseDeals.get(i).getDealAmount().trim();
			houseDeals.get(i).setDealAmount(dealAmount);
		}
		
		// 정렬 처리
		Collections.sort(houseDeals, Collections.reverseOrder());
		
		return houseDeals;
	}

}
