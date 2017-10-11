<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>小马交易</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/mall.css">
</head>
<body class="search-page">
	<!-- 顶部导航条 -->
	<div class="nav">
		<ul class="container" style="background: transparent;">
			<li class="nav-pull-down location"><img src="images/logo.png"></li>
			<li><a href="#">客户服务</a></li>
			<li><a href="release_goods.jsp">发布商品</a></li>
			<li><a href="#">商城会员</a></li>
			<li class="nav-pull-down my-shop"><a href="#">订单管理</a> <span class="glyphicon glyphicon-menu-down"></span></li>
			<c:if test="${user == null}">
				<li class="login-signup">[<a href="login.html">登录 </a> <a href="login.html#signup">注册</a> ]
				</li>
			</c:if>
			<c:if test="${user.state_type==1}">
				<li class="login-signup"><a href="" class="login">进入后台 </a>
				</li>
			</c:if>
			<c:if test="${user != null}">
				<li><a href="getshopcargoods">购物车</a></li>
				<li class="login-signup"><a href="showUserInfor.action">${user.username}</a></li>
			</c:if>
		</ul>
	</div>
	<form action="indexShow" method="post">
		<!-- 搜索框 -->
		<div class="search">
			<div class="search-body">
				<div class="input-group">
					<input type="text" class="form-control" placeholder="输入你想要的商品" name="gname"> <span class="input-group-btn"> <input name="page" value="1">
						<button class="btn btn-danger btn-search" type="submit">
							<i class="fa fa-search"></i>
						</button>
					</span>

				</div>
				<div class="search-keyword">
					<p>手机壳6plus 手机壳6 手机壳7 手机壳6s plus 手机壳7 手机壳华为 手机</p>
				</div>
			</div>
		</div>
	</form>
	<!-- 导航栏 -->
	<div class="search-nav">
		<div class="search-nav-container">
			<ul>
				<li>全部商品分类</li>
				<li><a href="showAction">首页</a></li>
				<li>服装城</li>
				<li>美妆馆</li>
				<li>京东超市</li>
				<li>生鲜</li>
				<li>全球购</li>
				<li>闪购</li>
				<li>拍卖</li>
				<li>金融</li>
			</ul>
		</div>
	</div>
	<!-- 内容主题开始 -->
	<div class="container-full">
		<div class="item-class-show">
			<div class="item-class-group item-class-group-top">
				<div class="item-class-name">
					<span>分类：</span>
				</div>
				<div class="item-class-select">
					<c:if test="${attri!=null}">
						<c:forEach items="${attri}" var="a">
							<a href="indexShow?type=${a}&page=${1}&gname="><span><c:out value="${a}"></c:out></span></a>
						</c:forEach>
					</c:if>
				</div>
			</div>
			<div class="item-class-group">
				<div class="item-class-name">
					<span>手机配件：</span>
				</div>
				<div class="item-class-select">
					<span>手机保护套</span> <span>苹果周边</span> <span>手机贴膜</span> <span>移动电源</span> <span>创意配件</span> <span>手机耳机</span> <span>手机支架</span>
				</div>
			</div>
			<div class="item-class-group">
				<div class="item-class-name">
					<span>款式：</span>
				</div>
				<div class="item-class-select">
					<span>软壳</span> <span>硬壳</span> <span>翻盖式</span> <span>边框</span> <span>运动臂包</span> <span>钱包式</span> <span>定制</span> <span>防水袋</span> <span>布袋</span> <span>其他</span>
				</div>
			</div>
			<div class="item-class-group">
				<div class="item-class-name">
					<span>材质：</span>
				</div>
				<div class="item-class-select">
					<span>塑料/PC</span> <span>硅胶</span> <span>金属</span> <span>电镀</span> <span>真皮</span> <span>树脂</span> <span>木质</span> <span>镶钻</span> <span>液态硅胶</span> <span>TPU</span>
				</div>
			</div>
		</div>
		<div class="item-list">
			<div class="item-list-left">
				<div class="item-as-title">
					<span>商品精选</span> <span>广告</span>
				</div>
				<div class="item-as">
					<div class="item-as-img">
						<img src="img/item-as-img-1.jpg" alt="">
					</div>
					<div class="item-as-price">
						<span><i class="fa fa-rmb text-danger"></i><span class="seckill-price text-danger">39.9</span></span>
					</div>
					<div class="item-as-intro">
						<span>SKSK 苹果7/7plus手机壳<br>iPhone 7 Plus保护套全包硬
						</span>
					</div>
					<div class="item-as-selled">
						已有<span>3140</span>人评价
					</div>
				</div>
				<div class="item-as">
					<div class="item-as-img">
						<img src="img/item-as-img-2.jpg" alt="">
					</div>
					<div class="item-as-price">
						<span><i class="fa fa-rmb text-danger"></i><span class="seckill-price text-danger">36.6</span></span>
					</div>
					<div class="item-as-intro">
						<span>狮普 苹果7/7 Plus手机壳<br>电镀超薄全包防摔保护外
						</span>
					</div>
					<div class="item-as-selled">
						已有<span>6160</span>人评价
					</div>
				</div>
				<div class="item-as">
					<div class="item-as-img">
						<img src="img/item-as-img-1.jpg" alt="">
					</div>
					<div class="item-as-price">
						<span><i class="fa fa-rmb text-danger"></i></span><span class="seckill-price text-danger">39.9</span>
					</div>
					<div class="item-as-intro">
						<span>SKSK 苹果7/7plus手机壳<br>iPhone 7 Plus保护套全包硬
						</span>
					</div>
					<div class="item-as-selled">
						已有<span>3140</span>人评价
					</div>
				</div>
				<div class="item-as">
					<div class="item-as-img">
						<img src="img/item-as-img-2.jpg" alt="">
					</div>
					<div class="item-as-price">
						<span><i class="fa fa-rmb text-danger"></i><span class="seckill-price text-danger">36.6</span></span>
					</div>
					<div class="item-as-intro">
						<span>狮普 苹果7/7 Plus手机壳<br>电镀超薄全包防摔保护外
						</span>
					</div>
					<div class="item-as-selled">
						已有<span>6160</span>人评价
					</div>
				</div>
				<div class="item-as">
					<div class="item-as-img">
						<img src="img/item-as-img-1.jpg" alt="">
					</div>
					<div class="item-as-price">
						<span><i class="fa fa-rmb text-danger"></i></span><span class="seckill-price text-danger">39.9</span>
					</div>
					<div class="item-as-intro">
						<span>SKSK 苹果7/7plus手机壳<br>iPhone 7 Plus保护套全包硬
						</span>
					</div>
					<div class="item-as-selled">
						已有<span>3140</span>人评价
					</div>
				</div>
				<div class="item-as">
					<div class="item-as-img">
						<img src="img/item-as-img-2.jpg" alt="">
					</div>
					<div class="item-as-price">
						<span><i class="fa fa-rmb text-danger"></i><span class="seckill-price text-danger">36.6</span></span>
					</div>
					<div class="item-as-intro">
						<span>狮普 苹果7/7 Plus手机壳<br>电镀超薄全包防摔保护外
						</span>
					</div>
					<div class="item-as-selled">
						已有<span>6160</span>人评价
					</div>
				</div>
			</div>
			<!--右边图片展示区-->
			<!---->
			<div class="item-list-right">
				<div class="item-list-tool">
					<ul>
						<li><span>综合 <strong><i class="fa fa-long-arrow-down"></i></strong></span></li>
						<li><span>销量 <strong><i class="fa fa-long-arrow-down"></i></strong></span></li>
						<li><span>评论数 <strong><i class="fa fa-long-arrow-down"></i></strong></span></li>
						<li><span>新品 <strong><i class="fa fa-long-arrow-down"></i></strong></span></li>
						<li><span>价格 <strong><i class="fa fa-long-arrow-down"></i></strong></span></li>
					</ul>
				</div>
				<c:forEach items="${pImageList.list}" var="list">
					<div class="item-container">
						<a href="goodsDetail?goodId=${list.g_id}">
							<div class="item-row">
								<div class="item-show-info">
									<div class="item-show-img">
										<img src="${list.image_zhanshi}">
									</div>
									<div class="item-show-detail">
										<span style="font-size: 20px">${list.g_name}</span>
									</div>
									<div class="item-show-price">
										<span><i class="fa fa-rmb text-danger"></i><span class="seckill-price text-danger">${list.g_price}</span></span>
									</div>

									<!-- 		<div class="item-show-num">
								已有<span>6160</span>人评价
							</div> -->
									<!-- 	<div class="item-show-seller">
								<span>元亨利配件专营店</span>
							</div> -->
								</div>
							</div>
						</a>
					</div>
				</c:forEach>
			</div>
		</div>
		<!--分页的样式-->
		<div class="page-num">
			<nav>
				<ul class="pagination">
					<c:if test="${pImageList.currentPage!=1}">
						<li><a href="indexShow?page=${pImageList.currentPage-1}&type=${type}"><span aria-hidden="true">&laquo;</span></a></li>
					</c:if>
					<c:forEach var="i" begin="1" end="${pImageList.countPage}">
						<c:if test="${i==pImageList.currentPage}">
							<li class="active"><a>${i}</a></li>
						</c:if>
						<c:if test="${i!=pImageList.currentPage}">
							<li><a href="indexShow?page=${i}&type=${type}">${i}</a></li>
						</c:if>
					</c:forEach>
					<c:if test="${pImageList.currentPage!=pImageList.countPage}">
						<li><a href="indexShow?page=${pImageList.currentPage+1}&type=${type}"><span>&raquo;</span></a></li>
					</c:if>
				</ul>
			</nav>
		</div>
	</div>
	<!-- 内容主题结束 -->

	<!-- 清除浮动 -->
	<div class="clearfix"></div>
	<!-- 底部 -->
	<footer class="footer">
		<div class="clearfix"></div>
		<div class="icon-row">
			<div class="footer-icon">
				<h5 class="footer-icon-child"></h5>
				<span class="footer-icon-text">品类齐全，轻松购物</span>
			</div>
			<div class="footer-icon">
				<h5 class="footer-icon-child footer-icon-child-2"></h5>
				<span class="footer-icon-text">多仓直发，极速配送</span>
			</div>
			<div class="footer-icon">
				<h5 class="footer-icon-child footer-icon-child-3"></h5>
				<span class="footer-icon-text">正品行货，精致服务</span>
			</div>
			<div class="footer-icon">
				<h5 class="footer-icon-child footer-icon-child-4"></h5>
				<span class="footer-icon-text">天天低价，畅选无忧</span>
			</div>
		</div>
		<div class="service-intro">
			<div class="servece-type">
				<div class="servece-type-info">
					<ul>
						<li>购物指南</li>
						<li>购物流程</li>
						<li>会员介绍</li>
						<li>生活旅行</li>
						<li>常见问题</li>
						<li>大家电</li>
						<li>联系客服</li>
					</ul>
				</div>
				<div class="servece-type-info">
					<ul>
						<li>配送方式</li>
						<li>上门自提</li>
						<li>211限时达</li>
						<li>配送服务查询</li>
						<li>配送费收取标准</li>
						<li>海外配送</li>
					</ul>
				</div>
				<div class="servece-type-info">
					<ul>
						<li>支付方式</li>
						<li>货到付款</li>
						<li>在线支付</li>
						<li>分期付款</li>
						<li>邮局汇款</li>
						<li>公司转账</li>
					</ul>
				</div>
				<div class="servece-type-info">
					<ul>
						<li>售后服务</li>
						<li>售后政策</li>
						<li>价格保护</li>
						<li>退款说明</li>
						<li>返修/退换货</li>
						<li>取消订单</li>
					</ul>
				</div>
			</div>
			<div class="clearfix"></div>
			<div class="friend-link">
				<div class="friend-link-item">
					<ul>
						<li><span class="link-item">关于我们</span></li>
						<li><span class="link-item">联系我们</span></li>
						<li><span class="link-item">联系客服</span></li>
						<li><span class="link-item">合作招商</span></li>
						<li><span class="link-item">商家帮助</span></li>
						<li><span class="link-item">营销中心</span></li>
						<li><span class="link-item">销售联盟</span></li>
						<li><span class="link-item">校园社区</span></li>
						<li><span class="link-item">风险监测</span></li>
						<li><span class="link-item link-last-item">隐私政策</span></li>
					</ul>
				</div>
			</div>
			<div class="clearfix"></div>
			<div class="copyright">
				<p>Copyright © 2017 BY Gavin 林智杰</p>
			</div>
		</div>
	</footer>

	<!-- 页面上的各种浮窗 -->
	<!-- 地理位置 -->
	<div class="city">
		<p>
			<span class="city-item">北京 </span> <span class="city-item">上海 </span> <span class="city-item">天津 </span> <span class="city-item">重庆 </span> <span class="city-item">河北 </span>
		</p>
		<p>
			<span class="city-item">山西 </span> <span class="city-item">河南 </span> <span class="city-item">辽宁 </span> <span class="city-item">吉林 </span> <span class="city-item">江苏 </span>
		</p>
		<p>
			<span class="city-item">福建 </span> <span class="city-item">湖北 </span> <span class="city-item">湖南 </span> <span class="city-item">广东 </span> <span class="city-item">广西 </span>
		</p>
		<p>
			<span class="city-item">江西 </span> <span class="city-item">四川 </span> <span class="city-item">海南 </span> <span class="city-item">贵州</span> <span class="city-item">云南</span>
		</p>
		<p>
			<span class="city-item">西藏</span> <span class="city-item">陕西</span> <span class="city-item">甘肃</span> <span class="city-item">青海</span> <span class="city-item">宁夏</span>
		</p>
	</div>
	<!-- 我的商城 -->
	<div class="my-shop-panel">
		<p>
			<a href="getAllorder"><span class="my-item">未付款订单</span></a><a href="getGoodsItems"><span class="my-item">已卖出未发货</span></a>
		</p>
		<p>
			<a href="comletedOrderIndex"><span class="my-item">未评价订单</span></a> <a href=""> <span class="my-item">全部订单</span></a>
		</p>
		<p>
			  <a href="evaluaedOrderIndex"> <span class="my-item">已评价订单</span></a> <a href=""> <span class="my-item">我的问答</span></a>
		</p>
	</div>
</body>
<script src="js/jquery-3.2.1.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script src="js/mall.js" type="text/javascript"></script>

</html>