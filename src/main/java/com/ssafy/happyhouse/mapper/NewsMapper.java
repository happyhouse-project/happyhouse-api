package com.ssafy.happyhouse.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ssafy.happyhouse.model.News;

@Mapper
@Repository
public interface NewsMapper {
	void register(ArrayList<News> newsList); // 뉴스 등록
	ArrayList<News> selectByLimit7(); // 뉴스 타이틀 리스트 가져오기
	ArrayList<News> selectAll(); // 뉴스 리스트 가져오기
	void delete(int id); // 뉴스 삭제
	ArrayList<News> selectByPage(int from); // 크롤링된 뉴스 페이지 별로 20개씩 가져오기
}
