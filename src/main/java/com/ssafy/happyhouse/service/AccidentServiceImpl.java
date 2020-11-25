package com.ssafy.happyhouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dao.AccidentDao;
import com.ssafy.happyhouse.model.Accident;

@Service
public class AccidentServiceImpl implements AccidentService{

	@Autowired
	AccidentDao crimeDao;

	private static int CRIME_ALL_CASES = 103668; // 범죄발생 총 건수
	private static int FIRE_ALL_CASES = 5881; // 화재발생 총 건수
	private static int TRAFFIC_ALL_CASES = 39258; // 교통사고발생 총 건수
	
	@Override
	public Accident searchByGuCode(String gucode) {
		Accident accident = crimeDao.searchByGuCode(gucode);
		int crimeCases = accident.getCrimeCases();
		int fireCases = accident.getFireCases();
		int trafficCases = accident.getTrafficCases();
		
		// 안전지수 계산
		double crime = (double)crimeCases/CRIME_ALL_CASES*100.0;
		double fire = (double)fireCases/FIRE_ALL_CASES*100.0;
		double traffic = (double)trafficCases/TRAFFIC_ALL_CASES*100.0;
		
		double accidentPoint = crime+fire+traffic;
		
		accident.setSafety(Math.round((100.0-accidentPoint)*10)/10.0);
		return accident;
	}

}