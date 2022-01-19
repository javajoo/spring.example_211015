package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBO;
import com.example.lesson03.model.Review;

@RestController
public class Lesson03Ex01RestController {

	@Autowired
	private ReviewBO reviewBO;
	
	//http://localhost:8080/lesson03/ex01
	//http://localhost:8080/lesson03/ex01?id=7
	//Servlet에서는 get파라미터를 가져왔지만 Spring에서는 	@RequestParam으로 파라미터를 받아올 수 있다.
	@RequestMapping("/lesson03/ex01")
	// 단건이라 하나의 객체로 만들어준다.
	public Review ex01(
		
			//@RequestParam(value="id") int id // 필수 파라미터
			//@RequestParam(value="id", required=true) int id // 필수 파라미터  
			//@RequestParam(value="id", required=false) Integer id // 비필수 파라미터
			//defaultValue 무조건 ""로 감싸줘야 한다.
			@RequestParam(value="id", defaultValue="1") int id // 비필수, 디폴트값 1
			// 아이디가 없으면 ID가 1번인 게 나온다. 
			
			
			// 파라미터가 안들어오면 null, Integer로 해야 null값도 저장이 된다.
			//null 들어갈 수 있으면 Integer, null 들어갈 수 없으면 int <구분해서 명확하게 사용해야 한다.>
			) {
		
		System.out.println("######### id:" + id); // 콘솔에 찍힌다. 안보이니까 ###로 표시함.
		return reviewBO.getReview(id);
	}
	
}
