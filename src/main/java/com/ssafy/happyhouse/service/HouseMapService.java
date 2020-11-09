package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.model.HouseInfo;

public interface HouseMapService {

	List<HouseInfo> searchByLocation(String from, String to); // from ~ to 범위내에 존재하는 아파트 정보 가져오기

}
