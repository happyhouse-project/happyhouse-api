package com.ssafy.happyhouse.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssafy.happyhouse.model.HouseInfo;
import com.ssafy.happyhouse.service.HouseMapService;

@Controller
@RequestMapping("/map")
public class HouseMapController {
	
	private final static String PATH = "house/";
	
	@Autowired
	HouseMapService houseMapService;
	
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
		
		System.out.println(from);
		System.out.println(to);
		
		List<HouseInfo> list = new ArrayList<>();
		JSONArray arr = new JSONArray();
		try {
			list = houseMapService.searchByLocation(from, to);
			for(HouseInfo house : list) {
				JSONObject obj = new JSONObject();
				obj.put("no", house.getNo());
				obj.put("dong", house.getDong());
				obj.put("aptName", house.getAptName());
				obj.put("lat", house.getLat());
				obj.put("lng", house.getLng());
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
