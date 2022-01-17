package com.example.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


// 제일 첫번째로 해야 한다.
@Controller
public class Ex01Controller {

	// String 출력하기
	// http://localhost:8080/lesson01/ex01/1
	
	@ResponseBody
	// 리턴되는 값을 Response로 보낸다.
	
	@RequestMapping("/lesson01/ex01/1") 
	// 주소를 매핑한다.
	
	public String printString() {
		String text = "<h1>예제1번</h1> 문자열을 response body로 보내는 예제";
		return text;
	}
	
	// Map 리턴하기 -> JSON 리턴하기
	// http://localhost:8080/lesson01/ex01/2
	@ResponseBody 
	@RequestMapping("/lesson01/ex01/2")
	// public @ResponseBody  Map<String, Object> printMap() {
	// 맨위에 넣으나 위처럼 넣으나 상관없다!!
	public Map<String, Object> printMap() {
		Map<String, Object> map = new HashMap<>();
		map.put("apple", 1);
		map.put("banana", 2);
		map.put("kiwi", 3);
		map.put("pitch", 4);
		
		// Map으로 리턴하면 json으로 나타난다.
		// Web starter에 Jackson 라이브러리가 포함되어 있기 때문이다.
		return map;
		
	}
	
		
	
	
}





