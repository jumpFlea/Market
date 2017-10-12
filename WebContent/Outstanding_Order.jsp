<%@page import="com.qst.serviceImpl.OrderServiceImpl"%>

<%@page import="com.qst.model.GoodsOrder"%>
<%@page import="com.qst.model.Goods"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%@page import="java.rmi.server.UID"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>未完成订单</title>
<link rel="stylesheet" href="./css/niunan/layout.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link href="css/public.css" type="text/css" rel="stylesheet" />
<link href="css/lanrenzhijia.css" rel="stylesheet" type="text/css" />
<script src="js/Calculation.js"></script>
</head>

<body style="background-color: black;">
		
	<div style="background-color: black;">
	<!--顶部快捷菜单-->
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


	<!--顶部Logo及搜索-->

		
		<!--  导航条    end-->


	<div class="gwc" style="margin: auto; border: solid  black; ">

		<table class="table table-striped" >
			<tr>
				<td>商品名字</td>
				<td>订单号</td>
				<td>数量</td>
				<td>价格</td>
				<td>支付状态</td>
			</tr>
		</table>
		
	<div>
		<form action="" method="post">
			<c:forEach items="${goodsOrders2_list}" var="goods">
				<table cellpadding="0" cellspacing="0" class="gwc_tb2">
                    <tr>
                        <td class="tb2_td2">
                            <a href="#">
                                <img src="${goods.image_zhanshi }"/>
                            </a>
                        </td>
                        <td class="tb2_td3">
                            <a href="#"><c:out value="${ goods.g_name}"></c:out></a>
                        </td>
                        <td class="tb2_td3">
                            <a href="#"><c:out value="${ goods.ordernumber}"></c:out></a>
                        </td>
                        <td class="tb1_td4">一件</td>
                     
                        <td class="tb1_td6">
                            <label class="tot" style="color: #ff5500; font-size: 14px; font-weight: bold;"><c:out value="${ goods.g_price}"></c:out></label>
                        </td>
                        <td class="tb1_td7"><a href="cancellationOrder?ordernumber=${goods.ordernumber }">放弃订单</a>|<a href="continuePayment?ordernumber=${goods.ordernumber }">马上去支付</a></td>

                    </tr>
                    </table>
				</c:forEach>		
		</form>
		</div>

	</div>
	
			<!--分页  -->
	<div class="page-num" style=" width:  100%">
		<nav>
		
		<div style="margin-left:50%; width:40% ">
			<ul class="pagination">
				<c:if test="${count!=1}">
					<li><a href="getAllorder?page=${count-1}"><span
							aria-hidden="true">&laquo;</span></a></li>
				</c:if>
				<c:forEach var="i" begin="1" end="${count}">
					<c:if test="${i==count}">
						<li ><a href="getAllorder?page=${i}">${i}</a></li>
					</c:if>
					<c:if test="${i!=count}">
						<li ><a href="getAllorder?page=${i}">${i}</a></li>
					</c:if>
				</c:forEach>
				<%-- <c:if test="${goodsorder.currentPage!=goodsorder.countPage}">
						<li><a
							href="getGoodsItems?page=${goodsorder.currentPage+1}&type=${type}"><span>&raquo;</span></a></li>
					</c:if> --%>
					</div>
			</ul>
		</nav>
	</div>
	</div>
		<!--分页  -->	
</body>
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/Calculation.js"></script>


</html>