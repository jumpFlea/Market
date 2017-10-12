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
<title>未评价订单</title>

</head>
<body>
	<div class="gwc" style="margin: auto;">
		
		
		<table class="table table-striped">
 			<tr>
 				<td>订单号</td>
 				<td>商品名称</td>
 				<td>商品号</td>
 				<td>客户留言</td>
 			</tr>
 			</table>
 		
		
	
		<c:forEach items="${map}" var="map">
		
			 <form action="setOrderpay_type" method="post">
				<table cellpadding="0" cellspacing="0" class="gwc_tb2">
				
				<tr>
				<span>  <c:out value="${map.key }"></c:out></span>
				<c:forEach items="${map.value }" var="goodsOrder">
					
						<td class="tb2_td2"><a href="#"> <img
								src="${goodsOrder.image_zhanshi }" />
						</a></td>

						<td class="tb2_td3"><a href="#"><c:out
									value="${ goodsOrder.g_name}"></c:out></a></td>
						

						<td class="tb1_td7">商品号： <input
							style="width: 20px; height: 18px; border: 1px solid #ccc;"
							disabled="disabled" value="${ goodsOrder.g_id}" name="gid" />
						</td>

						<td class="tb1_td7">客户的留言：
						<%--  <c:out value="${ goodsOrder.message}"></c:out>
							<input style="width: 200px; height: 50px; border: 1px solid #ccc;"
						 name=""  value="${goodsOrder.message}" />  --%> <input
							type="hidden" value="${goodsOrder.ordernumber }"
							name="ordernumber" /> <input type="hidden"
							value="${goodsOrder.g_id}" name="g_id" /> <input type="submit"
							value="发货" />
						</td>
					</tr>
					
					</c:forEach>
					<br/>
				</table>
			</form> 
		</c:forEach>
		</div>
		<!--分页  -->
		<div class="page-num">
			<nav>

			<div>
				<ul class="pagination">
					<c:if test="${count!=1}">
						<li><a
							href="getOrdernumber?page=${count-1}"><span
								aria-hidden="true">&laquo;</span></a></li>
					</c:if>
					<c:forEach var="i" begin="1" end="${goodsorder.countPage}">
						<c:if test="${i==count}">
							<li class="active"><a>${i}</a></li>
						</c:if>
						<c:if test="${i!=count}">
							<li><a href="getGoodsItems?page=${i}&type=${type}">${i}</a></li>
						</c:if>
					</c:forEach>
					<%-- <c:if test="${goodsorder.currentPage!=goodsorder.countPage}">
						<li><a
							href="getGoodsItems?page=${goodsorder.currentPage+1}&type=${type}"><span>&raquo;</span></a></li>
					</c:if> --%>
				</ul>
			</nav>
		</div>
	</div>


	</div>



</body>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
</html>