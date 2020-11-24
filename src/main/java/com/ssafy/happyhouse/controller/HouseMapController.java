package com.ssafy.happyhouse.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.HouseDeal;
import com.ssafy.happyhouse.model.HouseInfo;
import com.ssafy.happyhouse.service.HouseDealService;
import com.ssafy.happyhouse.service.HouseMapService;

// house
@RestController
@CrossOrigin
public class HouseMapController {

	@Autowired
	HouseMapService houseMapService;

	@Autowired
	HouseDealService houseDealService;

	// 드래그시 범위내에 존재하는 아파트정보 가져오기
	@PostMapping("/house/aptDragSearch")
	public List<HouseInfo> aptDragSearch(@RequestBody Map<String, String> loc) {

		String from = loc.get("from");
		String to = loc.get("to");

		List<HouseInfo> list = new ArrayList<>();

		list = houseMapService.searchByLocation(from, to);
		for (HouseInfo house : list) {

			// List<HouseDeal> dealList = new ArrayList<HouseDeal>();
			// dealList = houseDealService.searchByDongAndAptName(house.getAptName(), house.getDong());
			int deal = houseDealService.searchDealAmountByDongAndAptName(house.getAptName(), house.getDong());
			house.setDeal(deal);
		}
		
		return list;
	}
	
	// 아파트 세부정보 검색
	@GetMapping("/house/{no}")
	public HouseInfo selectOne(@PathVariable("no") int no) {
		HouseInfo houseInfo = houseMapService.searchByNo(no);
		
		List<HouseDeal> dealList = new ArrayList<HouseDeal>();
		dealList = houseDealService.searchByDongAndAptName(houseInfo.getAptName(), houseInfo.getDong());
		
		houseInfo.setDeals(dealList);
		
		// 아파트 조회 수 증가
		houseMapService.countUpHit(no);
		
		return houseInfo;
	}
	
	// 키워드를 통한 아파트 검색기능 개발
	@GetMapping("/house/search/apt/{keyword}")
	public List<HouseInfo> selectOne(@PathVariable("keyword") String keyword) {
		List<HouseInfo> houseInfoList = houseMapService.searchByAptKeyword(keyword);
		
		return houseInfoList;
	}
}
