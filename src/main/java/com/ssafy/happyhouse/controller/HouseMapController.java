package com.ssafy.happyhouse.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.HouseDeal;
import com.ssafy.happyhouse.model.HouseInfo;
import com.ssafy.happyhouse.service.HouseDealService;
import com.ssafy.happyhouse.service.HouseMapService;

// house
@RestController
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

			List<HouseDeal> dealList = new ArrayList<HouseDeal>();
			dealList = houseDealService.searchByDongAndAptName(house.getAptName(), house.getDong());
			
			house.setDeals(dealList);
		}

		return list;
	}
}
