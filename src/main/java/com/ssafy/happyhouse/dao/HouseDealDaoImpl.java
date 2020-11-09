package com.ssafy.happyhouse.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.happyhouse.mapper.HouseDealMapper;
import com.ssafy.happyhouse.model.HouseDeal;

@Repository
public class HouseDealDaoImpl implements HouseDealDao{
	
	@Autowired
	HouseDealMapper houseDealMapper;

	@Override
	public List<HouseDeal> searchByDongAndAptName(String aptName, String dong) {
		return houseDealMapper.searchByDongAndAptName(aptName, dong);
	}

}	
