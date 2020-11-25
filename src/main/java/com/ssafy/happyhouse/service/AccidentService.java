package com.ssafy.happyhouse.service;

import com.ssafy.happyhouse.model.Accident;

public interface AccidentService {

	Accident searchByGuCode(String gucode); // 구 코드를 이용한 검색

}
