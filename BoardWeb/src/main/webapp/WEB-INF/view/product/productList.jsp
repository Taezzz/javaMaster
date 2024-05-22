<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<h3>상품목록페이지</h3>

<div class="container">
	<div class="row">
		<c:forEach var="product" items="${productList }">
			<div class="col-xs-12 col-sm-6 col-lg-4 col-xl-3">
				<div class="card m-b-20">
					<ul class="list-group list-group-flush">
						<li class="list-group-item"><a
							href="productDetail.do?code=${product.prodCode }"
							class="card-link"> <img class="img-fluid"
								src="/BoardWeb/image/${product.prodImage }">
						</a></li>
						<li class="list-group-item">${product.prodName }</li>
						<li class="list-group-item"><a
							href="https://www.goobnemall.com/shop/shopbrand.html?type=M&amp;xcode=003&amp;mcode=001"
							class="card-link" target="_blank"> <img class="img-fluid"
								src="https://www.goobnemall.com/design/goobne/wib/img/pc/icon_cartBg.svg">
						</a> <a
							href="https://www.goobnemall.com/shop/shopbrand.html?type=M&amp;xcode=003&amp;mcode=001"
							class="card-link" target="_blank"> <img class="img-fluid"
								src="https://www.goobnemall.com/design/goobne/wib/img/pc/icon_heartBg.svg">
						</a></li>
						<li class="list-group-item">가격 : ${product.price }</li>
					</ul>
				</div>
			</div>
		</c:forEach>
	</div>
	<hr />
		<!-- Pagination -->
	<my:paging2 pageInfo="${paging }"/>
		

</div>