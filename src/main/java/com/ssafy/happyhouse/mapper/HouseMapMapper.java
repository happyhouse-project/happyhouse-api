package com.ssafy.happyhouse.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ssafy.happyhouse.model.HouseInfo;

@Mapper
@Repository
public interface HouseMapMapper {

	List<HouseInfo> searchByLocation(@Param("fromLat")double fromLat, @Param("fromLng")double fromLng,
			@Param("toLat")double toLat, @Param("toLng")double toLng); // from ~ to 범위내에 존재하는 아파트 정보 가져오기

	HouseInfo searchByNo(int no); // 아파트 번호로 세부정보 가져오기

	List<HouseInfo> searchByAptKeyword(String keyword); // 아파트 키워드를 통한 아파트 검색기능
}
