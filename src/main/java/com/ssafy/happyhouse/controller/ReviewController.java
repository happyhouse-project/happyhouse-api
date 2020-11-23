package com.ssafy.happyhouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.Review;
import com.ssafy.happyhouse.service.ReviewService;

@RestController
@CrossOrigin("*")
public class ReviewController {

	@Autowired
	private ReviewService reviewService;
	
	// house no를 가지고 리뷰리스트 얻기
	@GetMapping("/reviews/{houseNo}")
	public List<Review> list(@PathVariable("houseNo") int houseNo) {
		return reviewService.selectAllByHouseNo(houseNo);
	}
}
