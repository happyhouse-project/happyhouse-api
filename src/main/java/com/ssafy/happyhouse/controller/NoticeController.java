package com.ssafy.happyhouse.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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

import com.ssafy.happyhouse.model.Notice;
import com.ssafy.happyhouse.service.NoticeService;

@Controller
@RequestMapping("/notice")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	private final static String PATH = "notice/";
	
	@GetMapping("/list")
	public String list(Model model) {
		List<Notice> list = noticeService.selectAll();
		model.addAttribute("list", list);
		return PATH+"noticeList";
	}
	
	@GetMapping("/mainNoticeList")
	@ResponseBody
	public String mainList(Model model) {
		ArrayList<Notice> list = new ArrayList<>();
		JSONArray arr = new JSONArray();
		try {
			list = noticeService.selectByLimit7();
			for(Notice notice : list) {
				JSONObject obj = new JSONObject();
				obj.put("id", notice.getId());
				obj.put("title", notice.getTitle());
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
	
	@GetMapping("/register")
	public String register(Model model) {
		return PATH+"noticeRegister";
	}

	@PostMapping("registerProcess")
	public String registerProcess(@ModelAttribute Notice notice) {
		noticeService.insert(notice);
		return "redirect:/"+PATH+"list";
	}
	
	@GetMapping(value = "/detail")
	public String read(Model model, HttpServletRequest req) {
		int searchId = Integer.parseInt(req.getParameter("id"));
		Notice notice = noticeService.selectOne(searchId);
		
		model.addAttribute("notice", notice);
		return PATH+"noticeDetail";
	}
	
	@GetMapping(value = "/delete")
	public String delete(HttpServletRequest req) {
		int deleteId = Integer.parseInt(req.getParameter("id"));
		noticeService.delete(deleteId);
		
		return "redirect:/"+PATH+"list";
	}
	
}
