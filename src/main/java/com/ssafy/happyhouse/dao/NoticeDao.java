package com.ssafy.happyhouse.dao;

import java.util.ArrayList;

import com.ssafy.happyhouse.model.Notice;

public interface NoticeDao {

	void insert(Notice notice); // 공지사항 생성

	ArrayList<Notice> selectByLimit7(); // 공지사항 타이틀 리스트 가져오기

	ArrayList<Notice> selectAll(); // 공지사항 리스트 가져오기

	Notice selectOne(int id); // 공지사항 세부정보 가져오기

	int delete(int id); // 공지사항 삭제
}
