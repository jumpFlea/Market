<%@page import="java.util.List"%>
<%@page import="java.rmi.server.UID"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>已完成未评价订单</title>
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
		<link href="css/public.css" type="text/css" rel="stylesheet" />
		<link href="css/lanrenzhijia.css" rel="stylesheet" type="text/css" />
		<script src="js/jquery-1.11.1.min.js"></script>
		<script src="js/Calculation.js"></script>

	</head>

	<body>
		<!--顶部快捷菜单-->
		<div class="shortcut_v2013 alink_v2013">
			<div class="w">
				<ul class="fl 1h">
					<li class="fl">
						<div class="menu">

							<div class="menu_bd">
								<ul>
									<li>
										<a href="#">App For Android</a>
									</li>
									<li>
										<a href="#">App For IOS</a>
									</li>
								</ul>
							</div>
						</div>
					</li>
					<li class="fl"><i class="shortcut_s"></i></li>
					<li class="fl">
						<div class="menu_hd">您好，欢迎来到锡货网！</div>
					</li>
					<li class="fl">
						<div class="menu_hd">
							<a href="#">请登录</a>
						</div>
					</li>
					<li class="fl">
						<div class="menu_hd">
							<a href="#">免费注册</a>
						</div>
					</li>
				</ul>
				<ul class="fr 1h">
					<li class="fl">
						<div class="menu_hd">
							<a href="userOrder.action">我的订单</a>
						</div>
					</li>
					<li class="fl"><i class="shortcut_s"></i></li>
					<li class="fl">
						<div class="menu_hd">
							<a href="#">我的锡货</a>
						</div>
					</li>
					<li class="fl"><i class="shortcut_s"></i></li>
					<li class="fl">
						<div class="menu_hd">
							<a href="#">服务中心</a>
						</div>
					</li>
					<li class="fl"><i class="shortcut_s"></i></li>
					<li class="fl">
						<div class="menu_hd">
							<a href="#">商家入驻</a>
						</div>
					</li>
					<li class="fl"><i class="shortcut_s"></i></li>
					<li class="fl">
						<div class="menu">
							<div class="menu_hd">
								<a href="#">网站导航</a><b><em></em></b></div>
							<div class="menu_bd">
								<ul>
									<li>
										<a href="#">网站导航</a>
									</li>
									<li>
										<a href="#">网站导航</a>
									</li>
								</ul>
							</div>
						</div>
					</li>
				</ul>
				<span class="clr"></span>
			</div>
		</div>
		<!--顶部快捷菜单-->

		<!--顶部Logo及搜索-->
		<div class="header_2013">
			<div class="w">
				<div class="logo_v2013">
					<a href="#">
						<img class="border_r" src="images/logo.jpg" width="120" height="50">
						<img src="images/slogan.jpg" width="170" height="50">
					</a>
				</div>
				<div class="header_searchbox">
					<form action="#">
						<input name="search" type="text" class="header_search_input" default_val="锡货网三期上线全场五折" autocomplete="off" x-webkit-speech="" x-webkit-grammar="builtin:search" lang="zh">
						<button type="submit" class="header_search_btn">搜索</button>
					</form>
					<ul class="hot_word">
						<li>
							<a class="red" href="#" target="_blank">礼品卡</a>
						</li>
						<li>
							<a target="_blank" href="#">百货五折</a>
						</li>
						<li>
							<a target="_blank" href="#">大闸蟹</a>
						</li>
						<li>
							<a target="_blank" href="#">年货</a>
						</li>
						<li>
							<a target="_blank" href="#">电子产品</a>
						</li>
					</ul>
				</div>
				<div id="cart_box" class="cart_box">
					<a id="cart" class="cart_link" href="#" rel="nofollow">
						<span class="text">去购物车结算</span>
						<img src="images/shopping_icon.png" width="24" height="24" class="cart_gif">

						<!-- 购物车没有物品时，隐藏此num -->
						<span class="num">12</span>
						<s class="icon_arrow_right"></s>
					</a>

					<div class="cart_content" id="cart_content">
						<i class="cart-icons"></i>
						<!-- 购物车没有物品时，显示cart_content_null、隐藏cart_content_all -->
						<div class="cart_content_null" style="display: none;">购物车中还没有商品，<br>快去挑选心爱的商品吧！</div>
						<div class="cart_content_all" style="display: block;">
							<div class="cart_left_time"><span>06分49.9秒</span> 后购物车将被清空，请及时结算</div>
							<div class="cart_content_center">
								<div class="cart_con_single">
									<div class="single_pic">
										<a href="#" target="_blank" alt="兰蔻 (Lancome)根源补养洁颜啫哩 125ml">
											<img src="images/goods_img01.jpg" />
										</a>
									</div>
									<div class="single_info">
										<a href="#" target="_blank" alt="兰蔻 (Lancome)根源补养洁颜啫哩 125ml" class="name">兰蔻 (Lancome)根源补养洁颜啫哩 125ml</a>
										<span class="price">￥269.00</span>
										<span class="price_plus"> x </span>
										<span class="price_num">1</span>
									</div>
								</div>
							</div>
							<div class="con_all">
								<div class="price_whole"><span>共<span class="num_all">12</span>件商品</span>
								</div>
								<div><span class="price_gongji">共计<em>￥</em><span class="total_price">69</span></span>
									<a href="#" class="cart_btn" rel="nofollow">去购物车结算</a>
								</div>
							</div>
						</div>
					</div>
				</div>
				<span class="clr"></span>
			</div>
		</div>
		<!--顶部Logo及搜索-->

		<hr style="border:solid 1px #E51924 ;width: 100%;" />
		<br /><br />
		<div style="margin-left: 80px;">
			<div class="box-hd ">
				<h2>购物车</h2>
			</div>

		</div>
		<% String flag=(String)request.getAttribute("flag");
			if(flag.equals("1"))
			{
				%>
			<div style=" margin: 0px auto; width: 100%; height: 900px; border:  solid 1px red;">
				<iframe style="width: 100%; height: 750px;" src="Goodsorder_Ifram.jsp" scrolling="no" frameborder="0"></iframe>

			</div>
				<%
			}else if(flag.equals("2"))
			{
				%>
					<div style=" margin: 0px auto; width: 100%; height: 900px; border:  solid 1px red;">
				<iframe style="width: 100%; height: 750px;" src="evaluateGoods_iF.jsp" scrolling="no" frameborder="0"></iframe>

			</div>
				<%

			}
		%>


		</div>

		<!--  导航条    end-->

		<!-- 底部 -->
		<div class="promise_box">
			<div class="w">
				<ul>
					<li><img src="images/promise_img01.jpg"><span>365天不打烊</span></li>
					<li><img src="images/promise_img02.jpg"><span>无理由退换货</span></li>
					<li><img src="images/promise_img03.jpg"><span>担保交易</span></li>
					<li><img src="images/promise_img04.jpg"><span>先行赔付</span></li>
					<li><img src="images/promise_img05.jpg"><span>支持定制</span></li>
				</ul>
			</div>
		</div>
		<div class="bottom-links">
			<ul class="clearfix cols">
				<li class="col">
					<div class="bottom-links-title">关于我们</div>
					<ul class="clearfix bottom-links-items">
						<li>
							<a href="#">招聘英才</a>
						</li>
						<li>
							<a href="#">公司简介</a>
						</li>
						<li>
							<a href="#">合作洽谈</a>
						</li>
						<li>
							<a href="#">联系我们</a>
						</li>
					</ul>
				</li>
				<li class="col">
					<div class="bottom-links-title">客服中心</div>
					<ul class="clearfix bottom-links-items">
						<li>
							<a href="#">收货地址</a>
						</li>
						<li>
							<a href="#">个人资料</a>
						</li>
						<li>
							<a href="#">修改密码</a>
						</li>
					</ul>
				</li>
				<li class="col">
					<div class="bottom-links-title">售后服务</div>
					<ul class="clearfix bottom-links-items">
						<li>
							<a href="#">退换货政策</a>
						</li>
						<li>
							<a href="#">退款说明</a>
						</li>
						<li>
							<a href="#">联系卖家</a>
						</li>
					</ul>
				</li>
				<li class="col">
					<div class="bottom-links-title">帮助中心</div>
					<ul class="clearfix bottom-links-items">
						<li>
							<a href="#">FAQ</a>
						</li>
						<li>
							<a href="#">积分兑换</a>
						</li>
						<li>
							<a href="#">积分细则</a>
						</li>
						<li>
							<a href="#">已购商品</a>
						</li>
					</ul>
				</li>

				<li class="col">
					<div class="bottom-links-title">锡好网公众号</div>
					<ul class="clearfix bottom-links-items">
						<li>
							<img src="images/weixin_big.jpg" />
						</li>
					</ul>
				</li>
				<li class="col">
					<div class="bottom-links-title">关注我们</div>
					<ul class="clearfix bottom-links-items">
						<li><img src="images/icon_sina.png" />
							<a href="#">新浪微博</a>
						</li>
						<li><img src="images/icon_tencent.png" />
							<a href="#">腾讯微博</a>
						</li>
						<li><img src="images/icon_dou.png" />
							<a href="#">豆瓣小站</a>
						</li>
						<li><img src="images/icon_weixin.png" />
							<a href="#">官方微信</a>
						</li>
					</ul>
				</li>

			</ul>
		</div>
		<div class="footer_v2013 bottom-about">
			<div class="w">
				<p class="foot_p1">
					<a href="#">首页</a>|
					<a href="#">招聘英才</a>|
					<a href="#">广告合作</a>|
					<a href="#">联系我们</a>|
					<a href="#">关于我们</a>
				</p>
				<pre>
    经营许可证：苏B2-20130223备案许可证：苏ICP备13041162号-1360网站安全检测平台
    ©2013-2014 无锡太湖云电商网络科技发展有限公司   版权所有
                </pre>
			</div>
			<p>
				<a href="#"><img src="images/bottom_img01.png"></a>
				<a href="#"><img src="images/bottom_img02.png"></a>
				<a href="#"><img src="images/bottom_img03.png"></a>
				<a href="#"><img src="images/bottom_img04.png"></a>
				<a href="#"><img src="images/bottom_img05.png"></a>
				<a href="#"><img src="images/bottom_img06.png"></a>
				<a href="#"><img src="images/bottom_img07.png"></a>
				<a href="#"><img src="images/bottom_img08.png"></a>
				<a href="#"><img src="images/bottom_img09.png"></a>
			</p>
		</div>
		<!-- 底部 -->
		<div class="fixed-buttons">
			<ul>
				<li>
					<a href="#" class="fixed-weixin"><img src="images/fixed_weixin.png" />
						<div class="weixin-pic"><img src="images/weixin_big.jpg"></div>
					</a>
				</li>
				<li><img id="imgBtn-to-top" src="images/back_top.png" /></li>
			</ul>
		</div>
		<script src="js/jquery-1.11.1.min.js" type="text/javascript"></script>
		<script src="js/unslider.min.js" type="text/javascript"></script>
		<script src="js/index.js" type="text/javascript"></script>

	</body>

</html>