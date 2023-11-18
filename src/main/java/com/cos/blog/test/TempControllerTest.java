package com.cos.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TempControllerTest {
	
	// 
	@GetMapping("/temp/home")
	public String tempHome() {
		// 파일리턴 기본경로 : src/main/resources/static
		// 리턴명 : / home.html
		// 그렇게 안하면 statichome.html 이 되버림
		// + static 이하에는 정적파일만 넣어야 함!
		return "/home.html";
	}
	
	@GetMapping("/temp/test")
	public String tempJsp() {
		// prefix : /WEB-INF/views/
		// suffix : .jsp
		// 풀네임  : /WEB-INF/views//test.jsp.jsp (만약 /test.jsp로 할 경우)
		// 따라서 test로 해야한다.
		
		
		return "test";
	}
	
	
}

