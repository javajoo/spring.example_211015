package com.example.lesson03.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.lesson03.model.Review;

@Repository
public interface ReviewDAO {

	public Review selectReview(@Param("id") int id);
	
	// 하나의 객체인경우 맵으로 넘길 필요 없기 때문에 @param으로 안해도 된다.
	public int insertReview(Review review);
	
}
