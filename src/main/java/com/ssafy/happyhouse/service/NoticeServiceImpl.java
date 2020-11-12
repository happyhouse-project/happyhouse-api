package com.ssafy.happyhouse.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dao.NoticeDao;
import com.ssafy.happyhouse.model.Notice;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	NoticeDao noticeDao;

	@Override
	public void insert(Notice notice) {
		noticeDao.insert(notice);
	}

	@Override
	public ArrayList<Notice> selectByLimit7() {
		return noticeDao.selectByLimit7();
	}

	@Override
	public ArrayList<Notice> selectAll() {
		return noticeDao.selectAll();
	}

	@Override
	public Notice selectOne(int id) {
		return noticeDao.selectOne(id);
	}

	@Override
	public int delete(int id) {
		return noticeDao.delete(id);
	}
}
