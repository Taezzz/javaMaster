package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.common.HttpUtils;
import com.yedam.service.ProductService;
import com.yedam.service.ProductServiceImpl;
import com.yedam.vo.TestVO;

public class ProductDetailControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "product/productInfo.tiles";
		
		TestVO test = new TestVO();
	    String code = req.getParameter("code");
	    ProductService svc = new ProductServiceImpl();
		
	    
		
		HttpUtils.forward(req, resp, path);

		
		
	}

}
