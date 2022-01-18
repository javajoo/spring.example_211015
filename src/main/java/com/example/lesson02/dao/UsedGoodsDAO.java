package com.example.lesson02.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.lesson02.model.UsedGoods;

// 계층에 맞는 어노테이션도 붙여줘야 한다. 빼면 오류난다.
@Repository
public interface UsedGoodsDAO {
	// 인터페이스라서 구현체가 없다.
	public List<UsedGoods> selectUsedGoodsList();
}
