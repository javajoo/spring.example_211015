package com.example.lesson05;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Lesson05Controller {

	//http://localhost:8080/lesson05/ex01
	@RequestMapping("/lesson05/ex01")
	public String ex01() {
		return "lesson05/ex01";
	}

	//http://localhost:8080/lesson05/ex02
	@RequestMapping("/lesson05/ex02")
	public String ex02(
			Model model
			) {
		// list
		List<String> fruits = new ArrayList<>();
		fruits.add("banana");
		fruits.add("apple");
		fruits.add("grape");
		fruits.add("peach");
		fruits.add("melon");
		
		
		List<Map<String,Object>> users = new ArrayList<>();
		
		Map<String,Object> user = new HashMap<>();
		user.put("name", "신보람");
		user.put("age", 20);
		user.put("hobby", "노래하기");
		users.add(user);
		
		user = new HashMap<>(); // new 는 꼭 해줘야 된다!!!
		user.put("name", "신바다");
		user.put("age", 40);
		user.put("hobby", "걷기");
		users.add(user);
		
		// 한 곳에 몰아서 써준다.
		model.addAttribute("fruits",fruits);
		model.addAttribute("users",users);
		
		
		return "lesson05/ex02";
	}
	
	// 서버가 켜진 상태에서 창 뜨면 terminate 눌러서 서버 꺼주고 다시 켜준다.
	
	//http://localhost:8080/lesson05/ex03
	@RequestMapping("/lesson05/ex03")
	public String ex03(
			Model model
			) {
		
		Date today = new Date();
		model.addAttribute("today",today);
		
		return "lesson05/ex03";
	}
	
	
	

}
