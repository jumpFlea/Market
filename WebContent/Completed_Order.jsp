<%@page import="java.util.List"%>
<%@page import="java.rmi.server.UID"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>已完成订单</title>

<link href="css/lanrenzhijia.css" rel="stylesheet" type="text/css" />

<link href="css/public.css" type="text/css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="css/base.css" />
<script type="text/javascript" src="js/jquery_cart.js"></script>
<link rel="stylesheet" type="text/css" href="css/buyConfirm.css" />
<script src="js/jquery-1.11.1.min.js" type="text/javascript"></script>
<script src="js/unslider.min.js" type="text/javascript"></script>
<script src="js/index.js" type="text/javascript"></script>
</head>
<body>
	<div class="shortcut_v2013 alink_v2013">
		<div class="w">
			<ul class="fl 1h">
				<li class="fl">
					<div class="menu">
						<div class="menu_hd">
							<a href="#"> <img src="images/top_phone_icon.png"
								width="12px" height="16px" /> 手机锡货
							</a> <b><em></em></b>
						</div>
						<div class="menu_bd">
							<ul>
								<li><a href="#">App For Android</a></li>
								<li><a href="#">App For IOS</a></li>
							</ul>
						</div>
					</div>
				</li>
				<li class="fl"><i class="shortcut_s"></i></li>
				<li class="fl"><div class="menu_hd">您好，欢迎来到锡货网！</div></li>
				<li class="fl"><div class="menu_hd">
						<a href="#">请登录</a>
					</div></li>
				<li class="fl"><div class="menu_hd">
						<a href="#">免费注册</a>
					</div></li>
			</ul>
			<ul class="fr 1h">
				<li class="fl"><div class="menu_hd">
						<a href="#">我的订单</a>
					</div></li>
				<li class="fl"><i class="shortcut_s"></i></li>
				<li class="fl"><div class="menu_hd">
						<a href="#">我的锡货</a>
					</div></li>
				<li class="fl"><i class="shortcut_s"></i></li>
				<li class="fl"><div class="menu_hd">
						<a href="#">服务中心</a>
					</div></li>
				<li class="fl"><i class="shortcut_s"></i></li>
				<li class="fl"><div class="menu_hd">
						<a href="#">商家入驻</a>
					</div></li>
				<li class="fl"><i class="shortcut_s"></i></li>
				<li class="fl">
					<div class="menu">
						<div class="menu_hd">
							<a href="#">网站导航</a><b><em></em></b>
						</div>
						<div class="menu_bd">
							<ul>
								<li><a href="#">网站导航</a></li>
								<li><a href="#">网站导航</a></li>
							</ul>
						</div>
					</div>
				</li>
			</ul>
			<span class="clr"></span>
		</div>
	</div>
	<!-- 顶部导航条 -->
	
	<form action="setGoodinOrder" method="post">

		



				<table cellpadding="0" cellspacing="0" class="gwc_tb2">
                    <tr>
                        <td class="tb2_td1">
                            <input type="checkbox" value="价格" name="newslist"/></td>
                        <td class="tb2_td2">
                            <a href="#">
                                <img src="images/img1.jpg"/>
                            </a>
                        </td>
                        <td class="tb2_td3">
                            <a href="#"><c:out value="名字"></c:out></a>
                        </td>
                        <td class="tb1_td4">一件</td>
                      
                        <td class="tb1_td6">
                            <label class="tot" style="color: #ff5500; font-size: 14px; font-weight: bold;"><c:out value=""></c:out></label>
                        </td>
                      
                        <td class="tb1_td7">商品号：
                            <input style="width: 20px; height: 18px; border: 1px solid #ccc;" disabled="disabled" value="" name="gid"/>
                        </td>
                    </tr>

				
</body>
</html>