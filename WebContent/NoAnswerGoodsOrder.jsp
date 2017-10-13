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

<title>回答评价</title>
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

	<div class="gwc" style="margin: auto; border: solid black; " >
		<table cellpadding="0" cellspacing="0" class="gwc_tb1">
			<tr>

				
				<td class="tb2_td1">商品信息</td>
				<td class="tb1_td4">订单号</td>
				<td class="tb1_td7">商品号</td>
				<td class="tb1_td7">客户的评价</td>
				<td class="tb1_td7">我的回复</td>
			</tr>
		</table>
		.

		<c:forEach items="${ goodsorder}" var="goodsOrder">
			<form action="setReply" method="post">
				<table cellpadding="0" cellspacing="0" class="gwc_tb2">
					<tr>

						<td class="tb2_td2"><a href="#"> <img
								src="${goodsOrder.image_zhanshi }" />
						</a></td>
						<td class="tb2_td1"><a href="#"><c:out
									value="${ goodsOrder.g_name}"></c:out></a></td>
						<td class="tb1_td1"><c:out value="${goodsOrder.ordernumber }"></c:out></td>

						<td class="tb1_td3"> <input
							style="width: 20px; height: 18px; border: 1px solid #ccc;"
							disabled="disabled" value="${ goodsOrder.g_id}" name="gid" />
						</td>
						<td class="tb1_td4"> <input
							style="width: 200px; height: 30px; border: 1px solid #ccc;"
							disabled="disabled" value="${ goodsOrder.evaluate}" name="gid" />
						</td>
						<td class="tb1_td4"> <input
							style="width: 200px; height: 30px; border: 1px solid #ccc;"
							  name="reply" />
							 <input type="hidden" value="${goodsOrder.ordernumber }" name="ordernumber" />
							 <input type="hidden" value="${goodsOrder.session_id }" name="session_id"/> 
							 <input value="回复" type="submit"/>
						</td>
						

					</tr>
				</table>
			</form>
		</c:forEach>

		<!-- 分页  -->

		<%-- <div class="page-num" style="width: 100%">
			<nav>

			<div style="margin-left: 50%; width: 40%">
				<ul class="pagination">
					<c:if test="${goodsorder.currentPage!=1}">

						<li><a
							href="evaluaedOrderIndex?page=${goodsorder.currentPage-1}"><span
								aria-hidden="true">&laquo;</span></a></li>
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
						<li><a
							href="evaluaedOrderIndex?page=${goodsorder.currentPage+1}"><span>&raquo;</span></a></li>
					</c:if>
				</ul>
			</nav>
		</div>
	</div> --%>



	</div>

</body>
<script src="js/mall.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
</html>