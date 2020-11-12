package com.ssafy.happyhouse.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.Notice;
import com.ssafy.happyhouse.service.NoticeService;

@RestController
public class NoticeController {

	@Autowired
	private NoticeService noticeService;

	@GetMapping("/notices")
	public List<Notice> list() {
		return noticeService.selectAll();
	}

	@GetMapping("/notices/main")
	public List<Notice> mainList(Model model) {
		return noticeService.selectByLimit7();
	}

	@PostMapping("/notices")
	public ResponseEntity<?> create(@RequestBody Notice notice) throws URISyntaxException {
		noticeService.insert(notice);
		
		URI location = new URI("/notices/" + notice.getId());
		return ResponseEntity.created(location).body(notice.getId());
	}

	@GetMapping("/notices/{id}")
	public Notice detail(@PathVariable("id") int id) {
		return noticeService.selectOne(id);
	}

	@DeleteMapping("/notices/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		int result = noticeService.delete(id);
		
		if(result == 0) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
