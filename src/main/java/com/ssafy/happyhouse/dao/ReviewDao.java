package com.ssafy.happyhouse.dao;

import java.util.List;

import com.ssafy.happyhouse.model.Review;

public interface ReviewDao {
	
	List<Review> selectAllByHouseNo(int houseNo); // house no를 가지고 리뷰리스트 얻기

	void insert(Review review); // 리뷰 작성
}
