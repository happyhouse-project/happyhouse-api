package com.ssafy.happyhouse.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.happyhouse.mapper.HouseMapMapper;
import com.ssafy.happyhouse.model.HouseInfo;

@Repository
public class HouseMapDaoImpl implements HouseMapDao{

	@Autowired
	HouseMapMapper houseMapMapper;
	
	@Override
	public List<HouseInfo> searchByLocation(double fromLat, double fromLng, double toLat, double toLng) {
		return houseMapMapper.searchByLocation(fromLat, fromLng, toLat, toLng);
	}

	@Override
	public HouseInfo searchByNo(int no) {
		return houseMapMapper.searchByNo(no);
	}
}
