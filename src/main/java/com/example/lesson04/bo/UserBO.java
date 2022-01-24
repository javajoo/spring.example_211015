package com.example.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.dao.UserDAO;
import com.example.lesson04.model.User;

@Service
public class UserBO {
	
	@Autowired
	private UserDAO userDAO;
	
	public void addUser(String name, String yyyymmdd, String introduce,String email) {
		userDAO.insertUser(name, yyyymmdd, introduce, email);
		
	}
	
	//우리가 만든 User로 임포트 해줘야 한다.
	public User getLastUser() {
		// 무조건 마지막 하나만 가져오면 되니까 파라미터 필요없다.
		return userDAO.selectLastUser();
	}

}
