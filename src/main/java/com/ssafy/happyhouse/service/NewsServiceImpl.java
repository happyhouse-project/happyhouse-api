package com.ssafy.happyhouse.service;

import java.util.ArrayList;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dao.NewsDao;
import com.ssafy.happyhouse.model.News;

@Service
public class NewsServiceImpl implements NewsService {

	@Autowired
	NewsDao newsDao;

	@Override
	public void register(String[] newsInfo, int registerId) {
		// TODO: newsInfo => 문자열 파싱 후 뉴스 객체리스트 생성 후 파라미터로 전달
		ArrayList<News> newsList = new ArrayList<>();
		for (String news : newsInfo) {
			StringTokenizer st = new StringTokenizer(news, "###");
			String title = st.nextToken();
			String link = st.nextToken();
			String category = st.nextToken();
			String register = st.nextToken();
			
			newsList.add(new News(0, title, link, register, registerId, null, category));
		}
		
		newsDao.register(newsList);
	}

	@Override
	public ArrayList<News> selectByLimit7() {
		return newsDao.selectByLimit7();
	}

	@Override
	public ArrayList<News> selectAll() {
		return newsDao.selectAll();
	}

	@Override
	public void delete(int id) {
		newsDao.delete(id);
	}

	@Override
	public ArrayList<News> selectByPage(int page) {
		return newsDao.selectByPage(page);
	}

}
