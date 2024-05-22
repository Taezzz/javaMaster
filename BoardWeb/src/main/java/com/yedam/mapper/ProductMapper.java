package com.yedam.mapper;

import java.util.List;

import com.yedam.common.SearchVO;
import com.yedam.vo.TestVO;

public interface ProductMapper {
	List<TestVO> productList();
	List<TestVO> productListPaging(SearchVO search);
	int getTotalCnt(SearchVO search);

	List<TestVO> selectProduct(String name);
}
