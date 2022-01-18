package com.example.lesson02.model;

import java.util.Date;

public class UsedGoods {
	
	//  db에 있는 스키마 정보를 보고 자바식으로 바꿔주면 된다.
	//	id int AI PK 
	//	sellerId int 
	//	title varchar(64) 
	//	description text 
	//	price int 
	//	picture varchar(512) 
	//	createdAt timestamp  
	//	updatedAt timestamp
	
	// Entity : 가공이 안된 객체
	private int id;
	private int sellerId;
	private String title;
	private String description;
	private int price;
	private String picture;
	private Date createdAt; // Date 객체로 받고, utill로 임포트 해주면 된다.
	private Date updatedAt;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSellerId() {
		return sellerId;
	}
	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
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
