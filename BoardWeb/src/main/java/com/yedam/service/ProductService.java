package com.yedam.service;

import java.util.List;

import com.yedam.common.SearchVO;
import com.yedam.vo.TestVO;

public interface ProductService {
	List<TestVO> productList(SearchVO search);
	int getTotal(SearchVO search);
	
	List<TestVO> selectProduct(String name);
	
}
