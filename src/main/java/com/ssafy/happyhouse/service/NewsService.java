package com.ssafy.happyhouse.service;

import java.util.ArrayList;

import com.ssafy.happyhouse.model.Member;
import com.ssafy.happyhouse.model.News;

public interface NewsService {

	void register(String[] newsInfo, Member member); // 뉴스 등록

	ArrayList<News> selectByLimit7(); // 뉴스 타이틀 리스트 가져오기

	ArrayList<News> selectAll(); // 뉴스 리스트 가져오기

	void delete(int id); // 뉴스 삭제

	ArrayList<News> selectByPage(int page); // 크롤링된 뉴스 페이지 별로 20개씩 가져오기

}
