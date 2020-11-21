package com.ssafy.happyhouse.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ssafy.happyhouse.model.HouseDeal;

@Mapper
@Repository
public interface HouseDealMapper {

	List<HouseDeal> searchByDongAndAptName(@Param("aptName") String aptName, @Param("dong") String dong); // 아파트 이름과 동 정보를 이용해서 거래정보 가져옴

	String searchDealAmountByDongAndAptName(@Param("aptName") String aptName, @Param("dong") String dong);
}
