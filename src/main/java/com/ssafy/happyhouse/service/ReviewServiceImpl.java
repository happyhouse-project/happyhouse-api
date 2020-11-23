package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dao.ReviewDao;
import com.ssafy.happyhouse.model.Review;

@Service
public class ReviewServiceImpl implements ReviewService{

	@Autowired
	ReviewDao reviewDao;
	
	@Override
	public List<Review> selectAllByHouseNo(int houseNo) {
		return reviewDao.selectAllByHouseNo(houseNo);
	}

}
