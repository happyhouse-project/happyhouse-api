package com.ssafy.happyhouse.dao;

import java.util.List;

import com.ssafy.happyhouse.model.HouseInfo;

public interface HouseMapDao {

	List<HouseInfo> searchByLocation(double fromLat, double fromLng,
			double toLat, double toLng); // from ~ to 범위내에 존재하는 아파트 정보 가져오기

	HouseInfo searchByNo(int no); // 아파트 번호로 세부정보 가져오기
}
