package com.example.lesson06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.lesson04.bo.UserBO;

@Controller
public class Lesson06Controller {

	@Autowired
	private UserBO userBO;
	
	// 유저 추가 화면 (뷰만)
	//http://localhost:8080/lesson06/add_user_view
	@RequestMapping("/lesson06/add_user_view")
	public String add_user_view() {
		return "lesson06/addNewUser";
	}
	
	// 유저 추가 기능 
	@PostMapping("/lesson06/add_user")
	@ResponseBody
	// 기능을 수행하고 나서 데이터를 json으로 줘야 할때 @ResponseBody 추가하면 그냥 글자가 출력된다.
	public String addUser(
			@RequestParam("name") String name,
			@RequestParam("yyyymmdd") String yyyymmdd,
			@RequestParam("email") String email,
			@RequestParam( value = "introduce", required = false) String introduce
			) { // request params...
		
		// insert db
		userBO.addUser(name, yyyymmdd, introduce, email);
		
		// return string
		return "성공!"; // 브레이크 포인트 걸어서 잘 넘어오는지 확인한다.
	}
	
	
}
