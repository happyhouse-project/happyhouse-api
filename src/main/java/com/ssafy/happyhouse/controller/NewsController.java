package com.ssafy.happyhouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.News;
import com.ssafy.happyhouse.service.NewsService;

@RestController
@CrossOrigin("http://localhost:8080")
public class NewsController {

	@Autowired
	private NewsService newsService;
	
	// 전체 목록을 가져오는 처리
	@GetMapping("/news")
	public List<News> list() {
		return newsService.selectAll();
	}
	
	// 크롤링된 전체 목록을 가져오는 처리
	@GetMapping("/news/crawling/{no}")
	public List<News> crawlingList(@PathVariable("no") int no) {
		return newsService.selectByPage(no);
	}
	
	// 메인 페이지에서 띄울 title 가져오기
	@GetMapping("/news/main")
	public List<News> mainList() {
		return newsService.selectByLimit7();
	}

	// 선택한 뉴스 등록처리
	/**
	 * [
     *  "부산 아파트 매매·전세 가격 동반 상승세 지속###https://www.yna.co.kr/view/AKR20201015121200051?section=news###apt",
     *  "안양 아파트 매매·전세 가격 동반 상승세 지속###https://www.yna.co.kr/view/AKR20201015121200051?section=news###apt"
     * ]
     * client에서 위와 같은 format으로 요청
	 * */
	@PostMapping("/news")
	public ResponseEntity<?> create(@RequestBody String[] newsInfo) {
		
		// TODO: "admin"부분은 추후 jwt token사용해서 사용자 확인
		newsService.register(newsInfo, "admin");
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@DeleteMapping("/news/{id}")
	public ResponseEntity<?> read(@PathVariable("id") int id) {
		int result = newsService.delete(id);
		if(result == 0) { // 삭제가 되지 않은 경우
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	
}
