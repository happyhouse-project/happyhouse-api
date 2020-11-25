package com.ssafy.happyhouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.Accident;
import com.ssafy.happyhouse.service.AccidentService;

@RestController
@CrossOrigin
public class AccidentController {
	
	@Autowired
	AccidentService crimeService;
	
	@GetMapping("/crimes/{gucode}")
	public Accident selectOne(@PathVariable("gucode") String gucode) {
		return crimeService.searchByGuCode(gucode);
	}
}
