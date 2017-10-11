<%@page import="java.util.List"%>
<%@page import="java.rmi.server.UID"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/lanrenzhijia.css" rel="stylesheet" type="text/css" />

<link href="css/public.css" type="text/css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="css/base.css" />
<script type="text/javascript" src="js/jquery_cart.js"></script>
<link rel="stylesheet" type="text/css" href="css/buyConfirm.css" />
<script src="js/jquery-1.11.1.min.js" type="text/javascript"></script>
<script src="js/unslider.min.js" type="text/javascript"></script>
<script src="js/index.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link href="css/public.css" type="text/css" rel="stylesheet" />
<link href="css/lanrenzhijia.css" rel="stylesheet" type="text/css" />
<script src="js/Calculation.js"></script>
<title>已评价订单</title>
</head>
<body>
	<div class="gwc" style=" margin:auto;">
	<table cellpadding="0" cellspacing="0" class="gwc_tb1">
				<tr>
					
					<td class="tb1_td3">商品</td>
					<td class="tb1_td4">商品信息</td>
					<td class="tb1_td5">数量</td>
					<td class="tb1_td6">单价</td>
					<td class="tb1_td7">操作</td>
				</tr>
			</table>.

		<c:forEach items="${ goodsorder.list}" var="goodsOrder">
		<form action="setEvalueInSession" method="post">
			<table cellpadding="0" cellspacing="0" class="gwc_tb2">
				<tr>
					
					<td class="tb2_td2"><a href="#"> <img
							src="${goodsOrder.image_zhanshi }" />
					</a></td>
					<td class="tb2_td3"><a href="#"><c:out value="${ goodsOrder.g_name}"></c:out></a>
					</td>
					<td class="tb1_td4"><c:out value="${goodsOrder.ordernumber }"></c:out></td>

					<td class="tb1_td7">商品号： <input
						style="width: 20px; height: 18px; border: 1px solid #ccc;"
						disabled="disabled" value="${ goodsOrder.g_id}" name="gid" />
					</td>
					</td>


				</tr>
			</table>
			</form>
			 </c:forEach>
			 
			<!-- 分页  -->		
			
				<div class="page-num">
					<nav>
						<ul class="pagination">
							<c:if test="${goodsorder.currentPage!=1}">
								
								<li><a href="evaluaedOrderIndex?page=${goodsorder.currentPage-1}"><span aria-hidden="true">&laquo;</span></a></li>
							</c:if>
							
							<c:forEach var="i" begin="1" end="${goodsorder.countPage}">
								
								<c:if test="${i==goodsorder.currentPage}">
									<li class="active"><a>${i}</a></li>
									
								</c:if>
								<c:if test="${i!=goodsorder.currentPage}">
									<li><a href="evaluaedOrderIndex?page=${i}">${i}</a></li>
									
								</c:if>
							</c:forEach>
							
							<c:if test="${goodsorder.currentPage!=goodsorder.countPage}">
								<li><a href="evaluaedOrderIndex?page=${goodsorder.currentPage+1}"><span>&raquo;</span></a></li>
							</c:if>
						</ul>
					</nav>
				</div>
			 
			 


</div>

</body>
<script src="js/mall.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
</html>