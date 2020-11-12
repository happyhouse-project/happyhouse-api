package com.ssafy.happyhouse.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ssafy.happyhouse.model.Notice;

@Mapper
@Repository
public interface NoticeMapper {
	void insert(Notice notice); // 공지사항 생성
	ArrayList<Notice> selectByLimit7(); // 공지사항 타이틀 리스트 가져오기
	ArrayList<Notice> selectAll(); // 공지사항 리스트 가져오기
	Notice selectOne(int id); // 공지사항 세부정보 가져오기
	int delete(int id); // 공지사항 삭제
}
