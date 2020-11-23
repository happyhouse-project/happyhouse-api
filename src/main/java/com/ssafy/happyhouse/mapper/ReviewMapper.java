package com.ssafy.happyhouse.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ssafy.happyhouse.model.Review;

@Mapper
@Repository
public interface ReviewMapper {
	List<Review> selectAllByHouseNo(int houseNo); // house no를 가지고 리뷰리스트 얻기

	void insert(Review review); // 리뷰 작성
}
