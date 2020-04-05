package com.example.demo.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("/Healthtest")
	public String test() {
		return "HealthStore test api reached";
	}
}
