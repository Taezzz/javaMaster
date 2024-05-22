package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.common.SearchVO;
import com.yedam.mapper.ProductMapper;
import com.yedam.vo.TestVO;

public class ProductServiceImpl implements ProductService {
	
	SqlSession session = DataSource.getInstance().openSession(true);
	ProductMapper mapper = session.getMapper(ProductMapper.class);
	
	@Override
	public List<TestVO> productList(SearchVO search) {
		// TODO Auto-generated method stub
		return mapper.productListPaging(search);
	}
	
	@Override
	public List<TestVO> selectProduct(String name) {
		// TODO Auto-generated method stub
		return mapper.selectProduct(name);
	}

	@Override
	public int getTotal(SearchVO search) {
		return mapper.getTotalCnt(search);
	}
}
