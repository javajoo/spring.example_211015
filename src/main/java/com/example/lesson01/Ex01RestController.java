package com.example.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/lesson01/ex01")
@RestController
// @Controller + @ResponseBody
public class Ex01RestController { // Spring Bean

	//http://localhost:8080/lesson01/ex01/3
	
	@RequestMapping("/3")
	public String printString() {
		return "@RestController를 사용해서 String을 리턴해본다.";
	}
	
	//http://localhost:8080/lesson01/ex01/4
	@RequestMapping("/4")
	public Map<String, String> printMap() {
		Map<String, String> map = new HashMap<>();
		map.put("가", "A");
		map.put("나", "B");
		map.put("다", "C");
		return map;
	}
	
	//http://localhost:8080/lesson01/ex01/5
	
	@RequestMapping("/5")
	public Data printData() {
		Data data = new Data(); // 일반 자바 bean
		data.setId(1);
		data.setName("신보람");
		
		return data; // 일반 bean 객체도 json으로 내려간다.
		
	}
	
	
	//http://localhost:8080/lesson01/ex01/6
	@RequestMapping("/6")
	public ResponseEntity<Data> printEntity() { // 임포트 해야한다.
		Data data = new Data();
		data.setId(2);
		data.setName("신바다");
		
		
		
		// 개발자가 에러를 정의해서 내리고 싶을때 (에러처리를 디테일하게 잡고싶을 때 좋다.)
		// return new ResponseEntity<>(data, HttpStatus.OK); //200ok
		return new ResponseEntity<>(data, HttpStatus.INTERNAL_SERVER_ERROR); // 500 error
	}
	
	
}





