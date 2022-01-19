package com.example.lesson03.model;

import java.util.Date;

public class Review {

//	id int AI PK 
//	storeId int 
//	menu varchar(32) 
//	userName varchar(32) 
//	point decimal(2,1) 
//	review varchar(256) 
//	createdAt timestamp 
//	updatedAt timestamp

	// nullable 컬럼이면 타입 맨앞 대문자로 해야 한다.
	private int id;
	private int storeId;
	private String menu;
	private String userName;
	private double point;
	private String review;
	private Date createdAt;
	private Date updatedAt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public double getPoint() {
		return point;
	}

	public void setPoint(double point) {
		this.point = point;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}
