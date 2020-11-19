package com.ssafy.happyhouse.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.Member;
import com.ssafy.happyhouse.service.MemberService;

@RestController
@CrossOrigin("*")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	// 1. member list	
	@GetMapping("/members")
	public List<Member> list() {
		List<Member> list = memberService.list();
		return list;
	}
	
	// 2. member selectOne
	@GetMapping("/members/{id}")
	public Member selectOne(@PathVariable("id") int id) {
		return memberService.selectOne(id);
	}

	// 3. member create
	@PostMapping("/members")
	public ResponseEntity<?> create(@RequestBody Member resource) throws URISyntaxException {
		Member member = new Member(0, 
				resource.getEmail(), 
				resource.getPassword(), 
				resource.getName(), 
				resource.getPhone(), 
				resource.getAddress(), 
				1, null);
		
		memberService.register(resource);
		
		String url = "members/" + member.getId();
		return ResponseEntity.created(new URI(url)).body("member create successfully");
	}
	
	// 4. member update
	@PutMapping("/members/{id}")
	public String update(@PathVariable("id") int id, @RequestBody Member resource) {
		
		Member member = new Member(id, 
				resource.getEmail(), 
				resource.getPassword(), 
				resource.getName(), 
				resource.getPhone(), 
				resource.getAddress(), 
				1, null);
		
		memberService.modifyMember(member);
		return "member info updated";
	}

	// 5. member delete --> auth변경
	@DeleteMapping("/members/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		int result = memberService.inactiveMember(id);
		
		if(result == 0) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
}