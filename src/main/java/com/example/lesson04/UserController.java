package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lesson04.bo.UserBO;
import com.example.lesson04.model.User;

// jsp -> @Controller
@Controller
@RequestMapping("/lesson04/ex01")
public class UserController {

	// http://localhost:8080/lesson04/ex01/add_user_view
	// 뷰를 띄운다. 뷰 화면으로 가는 controller
	@RequestMapping(path = "/add_user_view", method = RequestMethod.GET)
	// 주소를 치고 들어가려면 GET방식
	public String addUserView() { // @ResponseBody가 없으면 view의 경로를 리턴한다. -> String
		return "lesson04/addUser"; // /WEB-INF/jsp/lesson04/addUser.jsp prefix와 suffix 사이가 출력된다.

	}
	
	@Autowired
	private UserBO userBO;

	// http://localhost:8080/lesson04/ex01/add_user
	// 방식은 jsp랑 똑같이 해야 한다.
	// 주소, 폼태그 안되고 form-post 일치해야만 들어올 수 있다.
	@PostMapping("/add_user")
	public String addUser(
			@RequestParam("name") String name,
			@RequestParam("yyyymmdd") String yyyymmdd,
			@RequestParam(value = "introduce", required = false) String introduce,
			@RequestParam("email") String email
			) { // 비필수 nullable
		
		// 쿼리 파라미터들을 받아온다.
		
		// DB insert
		userBO.addUser(name, yyyymmdd, introduce, email);
		
		
		return "/lesson04/afterAddUser"; // 결과 VIEW 화면 (파라미터들이 잘 넘어왔는지 먼저 확인한다.)
		
		
	}
	
	//http://localhost:8080/lesson04/ex01/get_last_user
	@GetMapping("/get_last_user")
	public String getLastUser(Model model) { // 결과 jsp view에 객체값을 넘겨준다.
		// Model model은 jsp에 내가 담고 싶은 내용을 담아서 jsp에 운반해주는 객체, model 패키지랑은 상관없다!!
		
		// 마지막 (가장 최근)에 추가된 사람 한명 정보 가져오기
		User lastUser = userBO.getLastUser();
		model.addAttribute("result", lastUser);
		model.addAttribute("subject","회원 정보");
		
		return "lesson04/getLastUser";
	}

}





