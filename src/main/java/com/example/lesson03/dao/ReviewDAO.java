package com.example.lesson03.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.lesson03.model.Review;

@Repository
public interface ReviewDAO {

	public Review selectReview(@Param("id") int id);
	
	// 하나의 객체인경우 맵으로 넘길 필요 없기 때문에 @param으로 안해도 된다.
	public int insertReview(Review review);
	
	
	public int insertReviewAsField(
			@Param("storeId") int storeId, 
			@Param("menu") String menu, 
			@Param("userName") String userName, 
			@Param("point") Double point, 
			@Param("review") String review);
	
	// 2개 이상이면 map 이기에 @Param 해줘야 한다.
	public int updateReviewAsId(
			@Param("id") int id, 
			@Param("review") String review);

	
	public int deleteReviewById(int id);
}
