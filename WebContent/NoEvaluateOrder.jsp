<%@page import="java.util.List"%>
<%@page import="java.rmi.server.UID"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="./css/niunan/layout.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link href="css/public.css" type="text/css" rel="stylesheet" />
<link href="css/lanrenzhijia.css" rel="stylesheet" type="text/css" />
<script src="js/Calculation.js"></script>
<title>未评价订单</title>

</head>
<body style="background-color: black;">
	<div style="background-color: black;">
	
	<div class="header-content toCenter" style="background-color: black; ">
        <h1 class="logo" title="牛男网商城">
            <a href="indexShow.action"><img src="images/logo.png" alt="" class="logo-img"></a>
        </h1>
        <div class="small-nav">
            <ul class="nav-wrap clear">

                <li class="nav-item end-item"><a href="">客户服务</a></li>
                <li class="nav-item"><a href="getshopcargoods.action">企业采购</a></li>
                <li class="nav-item"><a href="">商城会员</a></li>
                <li class="nav-item"><a href="myOrders.action">我的订单</a></li>
                <c:if test="${user == null}">
                    <li class="nav-item first-item">
                        [<a href="login.html" class="login">登录 </a>
                        <a href="login.html#signup" class="register">注册</a> ]
                    </li>
                </c:if>
                <c:if test="${user != null}">
                    <li class="nav-item"><a href="getshopcargoods.action">购物车</a></li>
                    <li class="nav-item">
                        <a href="showUserInfor.action">${user.username}
                            <span class="glyphicon glyphicon-menu-down"></span>
                        </a>
                    </li>
                </c:if>
            </ul>
        </div>
    </div>

		<div class="gwc" style="margin: auto; border: solid black; ">
			<table cellpadding="0" cellspacing="0" class="gwc_tb1">
				<tr>
					<td class="tb1_td3">商品</td>
					<td class="tb1_td4">商品信息</td>
					<td class="tb1_td5">数量</td>
					<td class="tb1_td6">单价</td>
					<td class="tb1_td7">操作</td>
				</tr>
			</table>

			<c:forEach items="${goodsorder.list}" var="goodsOrder">
				<form action="setEvalueInSession" method="post">
					<table cellpadding="0" cellspacing="0" class="gwc_tb2">
						<tr>

							<td class="tb2_td2"><a href="#"> <img
									src="${goodsOrder.image_zhanshi }" />
							</a></td>
							<td class="tb2_td3"><a href="#"><c:out
										value="${ goodsOrder.g_name}"></c:out></a></td>
							<td class="tb1_td4"><c:out
									value="${goodsOrder.ordernumber }"></c:out></td>

							<td class="tb1_td7">商品号： <input
								style="width: 20px; height: 18px; border: 1px solid #ccc;"
								disabled="disabled" value="${ goodsOrder.g_id}" name="gid" />
							</td>

							<td class="tb1_td7">你对商品的评价： <input
								style="width: 200px; height: 50px; border: 1px solid #ccc;"
								name="evaluate" /> <input type="hidden"
								value="${goodsOrder.ordernumber }" name="ordernumber" /> <input
								type="hidden" value="${goodsOrder.g_id}" name="g_id" /> <input
								type="submit" value="提交" />
							</td>


						</tr>
					</table>
				</form>
			</c:forEach>
			<!--移除session  -->
			<%
				session.removeAttribute("goodsOrders_list");
			%>


		</div>

		<div class="page-num" style="width: 100%">
			<nav>
			<div style="margin-left: 50%; width: 40%">

				<ul class="pagination">
					<c:if test="${goodsorder.currentPage!=1}">
						<li><a
							href="comletedOrderIndex?page=${goodsorder.currentPage-1}&type=${type}"><span
								aria-hidden="true">&laquo;</span></a></li>
					</c:if>
					<c:forEach var="i" begin="1" end="${goodsorder.countPage}">
						<c:if test="${i==goodsOrders_list.currentPage}">
							<li class="active"><a>${i}</a></li>
						</c:if>
						<c:if test="${i!=goodsorder.currentPage}">
							<li><a href="comletedOrderIndex?page=${i}&type=${type}">${i}</a></li>
						</c:if>
					</c:forEach>
					<c:if test="${goodsorder.currentPage!=goodsorder.countPage}">
						<li><a
							href="comletedOrderIndex?page=${goodsorder.currentPage+1}&type=${type}"><span>&raquo;</span></a></li>
					</c:if>
				</ul>
			</nav>
		</div>
	</div>
	</div>
</body>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
</html>
