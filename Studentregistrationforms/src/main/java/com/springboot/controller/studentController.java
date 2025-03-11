package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class studentController {
	
	@GetMapping("/")
	public String home() {
		return "index";
	}

}
