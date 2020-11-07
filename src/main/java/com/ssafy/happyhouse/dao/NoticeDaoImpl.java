package com.ssafy.happyhouse.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.happyhouse.mapper.NoticeMapper;
import com.ssafy.happyhouse.model.Notice;

@Repository
public class NoticeDaoImpl implements NoticeDao {

	@Autowired
	NoticeMapper noticeMapper;

	@Override
	public void insert(Notice notice) {
		noticeMapper.insert(notice);
	}

	@Override
	public ArrayList<Notice> selectByLimit7() {
		return noticeMapper.selectByLimit7();
	}

	@Override
	public ArrayList<Notice> selectAll() {
		return noticeMapper.selectAll();
	}

	@Override
	public Notice selectOne(int id) {
		return noticeMapper.selectOne(id);
	}

	@Override
	public void delete(int id) {
		noticeMapper.delete(id);
	}
}
