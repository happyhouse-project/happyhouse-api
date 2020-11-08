package com.ssafy.happyhouse.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.happyhouse.mapper.NewsMapper;
import com.ssafy.happyhouse.model.News;

@Repository
public class NewsDaoImpl implements NewsDao{

	@Autowired
	NewsMapper newsMapper;
	
	@Override
	public void register(ArrayList<News> newsList) {
		newsMapper.register(newsList);
	}

	@Override
	public ArrayList<News> selectByLimit7() {
		return newsMapper.selectByLimit7();
	}

	@Override
	public ArrayList<News> selectAll() {
		return newsMapper.selectAll();
	}

	@Override
	public void delete(int id) {
		newsMapper.delete(id);
	}

	@Override
	public ArrayList<News> selectByPage(int from) {
		return newsMapper.selectByPage(from);
	}
}
