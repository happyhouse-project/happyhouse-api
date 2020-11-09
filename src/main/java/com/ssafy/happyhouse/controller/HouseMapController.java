package com.ssafy.happyhouse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/map")
public class HouseMapController {
	
	private final static String PATH = "house/";
	
	@GetMapping("/apt")
	public String register() {
		return PATH+"apt";
	}
}
