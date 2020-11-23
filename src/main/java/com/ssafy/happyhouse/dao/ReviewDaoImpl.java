package com.ssafy.happyhouse.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.happyhouse.mapper.ReviewMapper;
import com.ssafy.happyhouse.model.Review;

@Repository
public class ReviewDaoImpl implements ReviewDao{

	@Autowired
	ReviewMapper reviewMapper;
	
	@Override
	public List<Review> selectAllByHouseNo(int houseNo) {
		return reviewMapper.selectAllByHouseNo(houseNo);
	}

	@Override
	public void insert(Review review) {
		reviewMapper.insert(review);
	}

}
