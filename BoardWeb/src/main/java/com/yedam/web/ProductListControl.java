package com.yedam.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.common.HttpUtils;
import com.yedam.common.PageDTO;
import com.yedam.common.SearchVO;
import com.yedam.service.ProductService;
import com.yedam.service.ProductServiceImpl;
import com.yedam.vo.TestVO;

public class ProductListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = "product/productList.tiles";

		
		SearchVO search = new SearchVO();
		String page = req.getParameter("page");
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");

		page = page == null ? "1" : page; // page 파라미터가 없을 경우에는 1페이지 출력.
		search.setPage(Integer.parseInt(page));
		search.setKeyword(kw);
		search.setSearchCondition(sc);
		
		ProductService svc = new ProductServiceImpl();

		List<TestVO> list = svc.productList(search);
		PageDTO pageDTO = new PageDTO(Integer.parseInt(page), svc.getTotal(search)); // 건수.

		
		req.setAttribute("productList", list);
		req.setAttribute("paging", pageDTO);
		req.setAttribute("searchCondition", sc);
		req.setAttribute("keyword", kw);

//		req.getRequestDispatcher(path).forward(req, resp);
		HttpUtils.forward(req, resp, path);
	}

}
