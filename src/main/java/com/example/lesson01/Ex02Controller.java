package com.example.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 뷰를 만들때는 controller
// 데이터를 날릴때는 responseBody
@Controller // @RestController가 아님에 주의, 뷰(jsp 화면이 나와서 뷰라고 한다)는 @responseBody가 없다.
public class Ex02Controller {

	@RequestMapping("/lesson01/ex02/1")
	// 뷰는 무조건 스트링으로 리턴한다!!!
	// @responseBody의 여부로 데이터, 뷰인지 판단한다.
	public String view() {
		// @responseBody가 아닌 상태로 String을 리턴하면
		// viewResolver에 의해 리턴된 String의 경로에 해당하는 view를 찾고 view 화면이 구성된다.
		
		return "lesson01/ex02"; // 경로
		//prefix , suffix 제거하고 사이에 있는 것만 리턴해준다. 
		//WEB-INF/jsp/ :  prefix 
		//lesson01/ex02   
		//.jsp         :  suffix 
	}

}
