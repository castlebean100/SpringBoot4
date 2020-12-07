package com.iu.sb4.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	/*
	 Controller 만드는 법
	1. 순수한 java 클래스 생성
	2. 클래스 선언부에 @Controller 선언

	 */

	@GetMapping("/") // 누구나 들어올 수 있음 () 안에는 요청URI를 써줌.
	public String hone() throws Exception {

		return "index";
	}
}
