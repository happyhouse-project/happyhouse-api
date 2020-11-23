package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.model.HouseInfo;

public interface HouseMapService {

	List<HouseInfo> searchByLocation(String from, String to); // from ~ to 범위내에 존재하는 아파트 정보 가져오기

	HouseInfo searchByNo(int no); // 아파트 번호로 세부정보 가져오기

	List<HouseInfo> searchByAptKeyword(String keyword); // 아파트 키워드를 통한 아파트 검색기능 개발

}
