package com.ssafy.happyhouse.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssafy.happyhouse.model.Member;
import com.ssafy.happyhouse.model.News;
import com.ssafy.happyhouse.model.Notice;
import com.ssafy.happyhouse.service.NewsService;
import com.ssafy.happyhouse.service.NoticeService;

@Controller
@RequestMapping("/news")
public class NewsController {

	@Autowired
	private NewsService newsService;
	
	private final static String PATH = "news/";
	
	// 전체 목록을 가져오는 처리
	@GetMapping("/list")
	public String list(Model model) {
		List<News> list = newsService.selectAll();
		model.addAttribute("list", list);
		return PATH+"newsList";
	}
	
	// 메인 페이지에서 띄울 title 가져오기
	@GetMapping("/mainNewsList")
	@ResponseBody
	public String mainList(Model model) {
		ArrayList<News> list = new ArrayList<>();
		JSONArray arr = new JSONArray();
		try {
			list = newsService.selectByLimit7();
			for(News news : list) {
				JSONObject obj = new JSONObject();
				obj.put("title", news.getTitle());
				obj.put("link", news.getLink());
				arr.add(obj);
			}
		} catch (Exception e) {
			arr = new JSONArray();
			JSONObject obj = new JSONObject();
			obj.put("message_code", "-1");
			arr.add(obj);
			e.printStackTrace();
		} finally {
			return arr.toJSONString();
		}
	}
	
	// 뉴스 정보 및 등록페이지 이동
	@GetMapping("/newsInfo")
	public String register(Model model, HttpServletRequest req) {
		int page = Integer.parseInt(req.getParameter("page"));
		ArrayList<News> list = new ArrayList<News>();
		list = newsService.selectByPage(page);
		model.addAttribute("list", list);
		return PATH+"newsInfo";
	}

	// 선택한 뉴스 등록처리
	@PostMapping("registerProcess")
	public String registerProcess(HttpServletRequest req) {
		String[] newsInfo = req.getParameterValues("newsInfo");
		
		for(String news : newsInfo) {
			System.out.println(news);
		}

		HttpSession httpSession = req.getSession();
		Member member = (Member) httpSession.getAttribute("member");

		newsService.register(newsInfo, member);
		
		return "redirect:/"+PATH+"list";
	}
	
	@PostMapping(value = "/delete")
	public String read(HttpServletRequest req) {
		int deleteId = Integer.parseInt(req.getParameter("id"));
		newsService.delete(deleteId);
		
		return "redirect:/"+PATH+"list";
	}
	
	
	
}
