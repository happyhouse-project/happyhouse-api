package com.ssafy.happyhouse.dao;

import com.ssafy.happyhouse.model.Accident;

public interface AccidentDao {
	Accident searchByGuCode(String gucode); // 구 코드를 이용한 검색
}
