package com.example.lesson03.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson03.dao.ReviewDAO;
import com.example.lesson03.model.Review;

@Service
public class ReviewBO {

	@Autowired
	// 클래스의 필드이기때문에 은닉화 해야 한다.(private)
	private ReviewDAO reviewDAO;
	
	// 단건이라 이렇게 써주면 된다.
	public Review getReview(int id) {
		return reviewDAO.selectReview(id);
	}
	
	public int addReview(Review review) {
		return reviewDAO.insertReview(review);
	
	// ctrl+shift+r 화면 열기 (유용하다)
	}
	
	public int addReviewAsField(int storeId, String menu, String userName, 
			Double point, String review) {
		// desc 정보 보고 null, nullable 확인하고 정의해준다.
		// id, createdAt, updatedAt은 생략 가능하다.
		
		return reviewDAO.insertReviewAsField(storeId, menu, userName, point, review);
	}
	
	// id를 통해서 리뷰를 update 하니까 updateReviewAsId로 해주면 된다.
	public int updateReviewAsId(int id, String review) {
		
		return reviewDAO.updateReviewAsId(id, review);
	}
	
	public int deleteReviewById(int id) {
		return reviewDAO.deleteReviewById(id);
	}
	
}
