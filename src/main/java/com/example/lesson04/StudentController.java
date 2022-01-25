package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.lesson04.bo.StudentBO;
import com.example.lesson04.model.Student;

@Controller
public class StudentController {
	
	// 아무문제가 없는 것 같은데 화면 안나오면 project - clean 으로 해보기!!
	
	// 순서 : 주소로 들어가는 화면 -> jsp -> jsp로 들어가서 나오는 화면
	// 주소 들어갈 때 : get
	// jsp 사용자 정보 입력시 : action : post
	// post 불러올때 : 똑같이 post
	
	
	@Autowired
	private StudentBO studentBO;
	
	
	
	//http:localhost:8080/lesson04/ex02/1 -> 학생 추가 화면
	//@GetMapping("/lesson04/ex02/1")
	@GetMapping("/lesson04/ex02/1")
	public String ex02_1() {
		return"lesson04/addStudent";
	}
	
	@PostMapping("/lesson04/ex02/add_student")
	public String addStudent(
//			@RequestParam("name") String name,
//			@RequestParam("phoneNumber") String phoneNumber,
//			@RequestParam("email") String email,
//			@RequestParam("dreamJob") String dreamJob
			
			// 위에 @RequestParam를 한번에 정의할 수 있다.
			@ModelAttribute Student student, // name 속성의 이름과 일치하는 필드에 값이 들어간다.
			Model model
			) {
		
		// DB insert
		// @ModelAttribute Student student에 들어있다.
		studentBO.addStudent(student);
		
		System.out.println("################ id:" + student.getId());
		// DB select
		
		Student result = studentBO.getStudentById(student.getId());
		model.addAttribute("result", result);
		model.addAttribute("subject", "학생 정보");
		
		return "lesson04/afterAddStudent"; // 추가된 학생 정보 jsp
	}

}
