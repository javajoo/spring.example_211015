package com.example.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson02.dao.UsedGoodsDAO;
import com.example.lesson02.model.UsedGoods;

@Service
public class UsedGoodsBO {
	
	@Autowired // 상단에 써준다. new를 한거랑 똑같은 효과를 준다. 어노테이션 붙어있는지 꼭 확인한다.
	private UsedGoodsDAO usedGoodsDAO;
	// 가져오는 객체마다 반드시 위에 써줘야 한다. 한개에 한개씩
	
	//BO: business object (@Service)
	public List<UsedGoods> getUsedGoodslist() {
		// 관례적으로 이렇게 짓는다.
		return usedGoodsDAO.selectUsedGoodsList();
		
	}
	
}
