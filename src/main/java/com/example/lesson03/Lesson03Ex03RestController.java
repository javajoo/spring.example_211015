package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBO;

@RestController
public class Lesson03Ex03RestController {

	@Autowired
	private ReviewBO reviewBO;
	
	// id 24번째의 review 내용을 바꿔준다.
	//http://localhost:8080/lesson03/ex03?id=23&review=도미노피자 역시 맛있어~~
	@RequestMapping("/lesson03/ex03")
	public String ex03(
			@RequestParam(value="id") int id,
			@RequestParam(value="review") String review) {
		// 처음에 빨간줄 뜨는건 return 값이 없어서 그런것.. 무시해도 된다.
		
		int rowCount = reviewBO.updateReviewAsId(id, review);
				
		return "변경완료: " + rowCount;
		
		
	}
	
}
