package com.ssafy.happyhouse.service;

import java.util.List;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dao.HouseMapDao;
import com.ssafy.happyhouse.model.HouseInfo;

@Service
public class HouseMapServiceImpl implements HouseMapService{
	
	@Autowired
	HouseMapDao houseMapDao;

	@Override
	public List<HouseInfo> searchByLocation(String from, String to) {
		
		StringTokenizer st = new StringTokenizer(from, "(), ");
		double fromLat = Double.parseDouble(st.nextToken()); // 남서쪽의 위도
		double fromLng = Double.parseDouble(st.nextToken()); // 남서쪽의 경도
		
		st = new StringTokenizer(to, "(), ");
		double toLat = Double.parseDouble(st.nextToken()); // 북동쪽의 위도
		double toLng = Double.parseDouble(st.nextToken()); // 북동쪽의 경도
		
		return houseMapDao.searchByLocation(fromLat, fromLng, toLat, toLng);
	}

	@Override
	public HouseInfo searchByNo(int no) {
		return houseMapDao.searchByNo(no);
	}

	@Override
	public List<HouseInfo> searchByAptKeyword(String keyword) {
		return houseMapDao.searchByAptKeyword(keyword);
	}

	@Override
	public void countUpHit(int no) {
		houseMapDao.countUpHit(no);
	}

	@Override
	public List<HouseInfo> chart() {
		return houseMapDao.chart();
	}
}
