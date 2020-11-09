package com.ssafy.happyhouse.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssafy.happyhouse.model.HouseDeal;
import com.ssafy.happyhouse.model.HouseInfo;
import com.ssafy.happyhouse.service.HouseDealService;
import com.ssafy.happyhouse.service.HouseMapService;

@Controller
@RequestMapping("/map")
public class HouseMapController {
	
	private final static String PATH = "house/";
	
	@Autowired
	HouseMapService houseMapService;
	
	@Autowired
	HouseDealService houseDealService;
	
	@GetMapping("/apt")
	public String register() {
		return PATH+"apt";
	}
	
	// 드래그시 범위내에 존재하는 아파트정보 가져오기
	@PostMapping("/aptDragSearch")
	@ResponseBody
	public String aptDragSearch(@RequestBody Map<String, String> loc) {
		
		String from = loc.get("from");
		String to = loc.get("to");
		
		List<HouseInfo> list = new ArrayList<>();
		JSONArray arr = new JSONArray();
		try {
			list = houseMapService.searchByLocation(from, to);
			for(HouseInfo house : list) {
				JSONObject obj = new JSONObject();
				JSONArray deals = new JSONArray();
				
				List<HouseDeal> dealList = new ArrayList<HouseDeal>();
				dealList = houseDealService.searchByDongAndAptName(house.getAptName(), house.getDong());
				
				JSONObject obj2 = new JSONObject();
				for(HouseDeal houseDeal : dealList) {
					obj2.put("no", houseDeal.getNo());
					obj2.put("dealAmount", houseDeal.getDealAmount());
					obj2.put("dealYear", houseDeal.getDealYear());
					obj2.put("dealMonth", houseDeal.getDealMonth());
					obj2.put("dealDay", houseDeal.getDealDay());
					obj2.put("area", houseDeal.getArea());
					obj2.put("floor", houseDeal.getFloor());
					deals.add(obj2);
				}
				
				obj.put("no", house.getNo());
				obj.put("dong", house.getDong());
				obj.put("aptName", house.getAptName());
				obj.put("lat", house.getLat());
				obj.put("lng", house.getLng());
				obj.put("deals", deals);
				if(dealList.size() > 0) {
					obj.put("deal", dealList.get(0).getDealAmount());
				}
				arr.add(obj);
			}
		} catch (Exception e) {
			arr = new JSONArray();
			JSONObject obj = new JSONObject();
			obj.put("message_code", "-1");
			arr.add(obj);
			e.printStackTrace();
		} finally {
			return arr.toJSONString();
		}
	}
}
