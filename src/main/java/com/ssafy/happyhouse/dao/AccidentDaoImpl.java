package com.ssafy.happyhouse.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.happyhouse.mapper.AccidentMapper;
import com.ssafy.happyhouse.model.Accident;

@Repository
public class AccidentDaoImpl implements AccidentDao{

	@Autowired
	AccidentMapper crimeMapper;
	
	@Override
	public Accident searchByGuCode(String gucode) {
		return crimeMapper.searchByGuCode(gucode);
	}

}
