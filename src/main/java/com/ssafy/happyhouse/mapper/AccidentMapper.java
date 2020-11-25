package com.ssafy.happyhouse.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ssafy.happyhouse.model.Accident;

@Repository
@Mapper
public interface AccidentMapper {
	
	Accident searchByGuCode(String gucode); // 구 코드를 이용한 검색
}
