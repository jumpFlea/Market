<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset=UTF-8>
	<title>商品详情-小马交易</title>
	<link rel="stylesheet" href="css/niunan/neat.css">
	<link rel="stylesheet" href="css/goodsdetails.css">
	<link rel="stylesheet" href="css/niunan/layout.css">
	<link rel="stylesheet" href="css/niunan/goods-detail.css">
	<link rel="stylesheet" href="css/niunan/order-detail.css">
	<style type="text/css"></style>
</head>
<body>
	<div class="header">
		<div class="header-content toCenter">
			<h1 class="logo" title="牛男网商城">
				<a href=""><img src="images/logo.png" alt="" class="logo-img"></a>
			</h1>
			<div class="small-nav">
				<ul class="nav-wrap clear">

					<li class="nav-item end-item"><a href="">客户服务</a></li>
					<li class="nav-item"><a href="getshopcargoods.action">企业采购</a></li>
					<li class="nav-item"><a href="">商城会员</a></li>
					<li class="nav-item"><a href="#">我的订单</a></li>
					<c:if test="${user == null}">
						<li class="nav-item first-item">[<a href="login.html"
							class="login">登录 </a> <a href="login.html#signup"
							class="register">注册</a> ]
						</li>
					</c:if>
					<c:if test="${user != null}">
						<li class="nav-item"><a href="getshopcargoods.action">购物车</a></li>
						<li class="nav-item"><a href="showUserInfor.action">${user.username}
								<span class="glyphicon glyphicon-menu-down"></span>
						</a></li>
					</c:if>
				</ul>
			</div>
		</div>
	</div>
	<div class="content">
		<div class="detail-content toCenter clear">
			<div class="fl detail-pic">
				<div class="preview">
					<div id="vertical" class="bigImg">
						<!-- 第一张中等大小图 -->
						<img src="${good.image_zhanshi}" alt="" id="midimg" />
						<div id="winSelector"></div>
					</div>
					<div class="smallImg">
						<div class="per-img-wrap">
							<span class="per-img"></span>
						</div>
						<div id="imageMenu">
							<ul class="list-ul">
								<!-- src 为最小缩略图 data-mid 中等大小图 data-big 大图-->
								<li><img src="${good.image_zhanshi}" class="onlickImg"
									alt="" data-mid="${good.image_zhanshi}"
									data-big="${good.image_zhanshi}" /></li>
								<li><img src="${image.url2}" alt=""
									data-mid="${image.url2}" data-big="${image.url2}" /></li>
								<li><img src="${image.url3}" alt=""
									data-mid="${image.url3}" data-big="${image.url3}" /></li>
								<li><img src="${image.url4}" alt=""
									data-mid="${image.url4}" data-big="${image.url4}" /></li>
							</ul>

					</div>
					<div class="next-img-wrap">
						<span class="next-img"></span>
					</div>
				</div>

				<div id="bigView">
					<!-- 第一张大图 -->
					<img alt="" src="${good.image_zhanshi}" />
				</div>

				</div>
			</div>
			<div class="de-info">
				<div class="basic-info">
					<div class="b-title">${good.g_name}</div>
					<div class="b-qu">牛男原创专区</div>
					<div class="b-price clear">
						<span class="fl"> 跳蚤价 ：
							<span class="price-value-now">${good.g_price}</span>
						</span>
						<span class="fr on-market"> 市场价：
							<del>${good.market_price}</del>
						</span>
					</div>
				</div>
				<br>
				<span class="b-price pull-left detail-number">数量： </span>
				<span class="fourth-col-item detail-number">
					<div class="num-wrap-component pull-left" style="padding-top: 5px">
						<button class="subtraction-calc" disabled="disabled">-</button>
						<input type="text" class="item-number" value="1" maxlength="4">
						<button class="plus-calc">+</button>
					</div>
				</span>
				<!-- 已经添加到购物车状态 -->
				<div class="add-cart">
					<div class="add-car-tips" hidden>
						<p class="tips-value">商品已成功添加到 <a href="getshopcargoods.action">购物车</a>！</p>
						<p class="cart-info">
							购物车现有<span class="cart-count">...</span>件商品
						</p>
					</div>
					<div class="btn-row">
						<a class="to-buy" onclick="addToCart(this)"
						   ref="addInshopcar.action?item.price=${good.g_price}&item.gid=${good.g_id}&item.uid=${user.uid}">
							添加到购物车
							<span></span>
						</a>
						<a class="continue-find"
						   href="quickBuy.action?&goodsPrice=${good.g_price}&goodsId=${good.g_id}&uid=${user.uid}">
							立即购买
							<span></span>
						</a>
					</div>
				</div>
				<!-- end -->
				<!-- 选择商品状态 -->
				<div class="choose-goods" style="display: none">
					<div class="item c-color">
						<span class="c-color-text">颜色 ：</span> <span
							style="background-color: fff" class="active c-color-item"></span>
						<span class="c-color-item"></span> <span class="c-color-item"></span>
					</div>
					<div class="item c-size">
						<span class="c-size-text">尺码 ：</span> <span class="c-size-item">S</span>
						<span class="c-size-item">M</span> <span class="c-size-item">L</span>
						<span class="c-size-item active">XL</span> <span
							class="c-size-item">XXL</span>
					</div>
					<div class="item c-num">
						<span class="c-num-text">数量 ：</span> <span class="c-num-item plus">-</span>
						<span class="c-num-item end-all">1</span> <span
							class="c-num-item add">+</span>
					</div>
					<div class="buy-btn">
						<a href="" class="buy">立即购买</a> <a href="" class="collect">收藏</a>
					</div>
				</div>
				<!-- end -->
			</div>
		</div>
		<div class="more-detail toCenter clear">
			<div class="main-tab-wrap colorfff">
				<div class="add-margin">
					<div class="tabs">
						<ul class="tab-ul clear">
							<li class="tab-item tab1"><a href="" class="active">商品信息
									DESCRIPTION</a></li>
							<li class="tab-item tab2"><a href="" class="">材质洗涤
									MATERIALS</a></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="good-basic-info clear colorfff">
				<div class="gbi-item">
					<p class="add-padding">
						<span class="gbi-item-bold">编号</span> <span>N51207493</span>
					</p>
					<p class="add-padding">
						<span class="gbi-item-bold">衣长</span> <span>适中</span>
					</p>
					<p class="add-padding">
						<span class="gbi-item-bold">经典款型</span> <span>印花T恤</span>
					</p>
				</div>
				<div class="gbi-item">
					<p class="add-padding">
						<span class="gbi-item-bold">颜色</span> <span>黑色</span>
					</p>
					<p class="add-padding">
						<span class="gbi-item-bold">袖长</span> <span>短袖</span>
					</p>
					<p class="add-padding">
						<span class="gbi-item-bold">袖型</span> <span>收紧</span>
					</p>
				</div>
				<div class="gbi-item">
					<p class="add-padding">
						<span class="gbi-item-bold">性别</span> <span>男款</span>
					</p>
					<p class="add-padding">
						<span class="gbi-item-bold">版型</span> <span>正常</span>
					</p>
				</div>
				<div class="gbi-item without-border">
					<p class="add-padding">
						<span class="gbi-item-bold">领型</span> <span>圆领</span>
					</p>
					<p class="add-padding">
						<span class="gbi-item-bold">厚度</span> <span>中</span>
					</p>
				</div>
			</div>
			<!-- <div class="size-info colorfff">
            <div class="tab-wrap">
                <div class="tab-text">尺码信息 SIZE INFO</div>
            </div>
            <div class="side-detail">
                <img src="image/img/size-info.png">
            </div>
        </div> -->
		<div class="size-info colorfff goods-pic">
			<div class="tab-wrap">
				<div class="tab-text">商品详情 DETAILS</div>
			</div>
			<div class="side-detail">
				<img src="${good.image_zhanshi}">
				<img src="${good.image_zhanshi}">
				<img src="${good.image_zhanshi}">
				<img src="${good.image_zhanshi}">
			</div>
			<p class="goods-copy-right">&nbsp;&nbsp;&nbsp;&nbsp;${good.g_content}</p>
			<!-- <p class="goods-copy-right">owners and were used in
                demonstration purposes in order to set</p>
            <p class="goods-copy-right">the certain quality level of the
                future image content</p> -->
			</div>
			<div class="size-info colorfff">
				<div class="tab-wrap">
					<div class="tab-text">购买评价 COMMENT</div>
				</div>
				<div class="side-detail nopadding">
					<!--评价列表-->
					<c:if test="${evaluate!=null}">
						<c:forEach items="${evaluate}" var="item">
							<div class="commet-wrap">
								<!-- 评论列表项 -->
								<div class="commet-item clear">
									<!-- 头像 -->
									<div class="uer-head-pic">
										<div class="head-wrap">
											<img src="images/user-head-pic.png" alt="" class="head-pic">
										</div>
									</div>
									<!-- 时间，星级 -->
									<div class="c-time-star">
										<div class="c-star">
											<!-- 黄色星 .y-star 灰色星 .b-star -->
											<span class="y-star"></span> <span class="y-star"></span> <span
												class="y-star"></span> <span class="y-star"></span> <span
												class="b-star"></span>
										</div>
										<div class="commet-time">2016-05-26</div>
									</div>
									<!-- 评论主体 -->
									<div class="c-commet-body">
										<div class="c-user-name">NEONAN.COM</div>
										<div class="c-con"><c:out value="${item.session.evaluate}"></c:out></div>
										<div class="c-style"></div>
									</div>
								</div>
								<!-- 评论列表项结束 -->
							</div>
						</c:forEach>
					</c:if>
				</div>
			</div>
		</div>
	</div>
	<div class="footer">
		<!-- 底部导航曲，选择性加入 -->
		<div class="footer-nav">
			<div class="some-intro">
				<div class="intro-item">
					<span class="intro-list"><span class="color-ff-bold">100%</span>原单正品</span>
					<span class="intro-list"><span class="color-ff-bold">七天</span>无理由退换货</span>
					<span class="intro-list"><span class="color-ff-bold">便捷</span>在线客服解答</span>
				</div>
			</div>
			<div class="f-nav-content toCenter clear">
				<div class="f-content-item">
					<div class="f-list-title">新手指南</div>
					<p class="n-other-list">
						<a href="">注册登录</a>
					</p>
					<p class="n-other-list">
						<a href="">选购商品</a>
					</p>
					<p class="n-other-list">
						<a href="">订单支付</a>
					</p>
					<p class="n-other-list">
						<a href="">收货退款</a>
					</p>
				</div>
				<div class="f-content-item">
					<div class="f-list-title">购物指南</div>
					<p class="n-other-list">
						<a href="">海淘专区</a>
					</p>
					<p class="n-other-list">
						<a href="">尺码选择</a>
					</p>
					<p class="n-other-list">
						<a href="">开具发票</a>
					</p>
					<p class="n-other-list">
						<a href="">商品咨询</a>
					</p>
				</div>
				<div class="f-content-item">
					<div class="f-list-title">支付方式</div>
					<p class="n-other-list">
						<a href="">在线支付</a>
					</p>
					<p class="n-other-list">
						<a href="">货到付款</a>
					</p>
					<p class="n-other-list">
						<a href="">优惠券</a>
					</p>
					<p class="n-other-list">
						<a href="">有赞商城</a>
					</p>
				</div>
				<div class="f-content-item">
					<div class="f-list-title">配送方式</div>
					<p class="n-other-list">
						<a href="">配送时间</a>
					</p>
					<p class="n-other-list">
						<a href="">配送范围</a>
					</p>
					<p class="n-other-list">
						<a href="">顺丰速运</a>
					</p>
					<p class="n-other-list">
						<a href="">商品验收与签字</a>
					</p>
				</div>
				<div class="f-content-item">
					<div class="f-list-title">售后服务</div>
					<p class="n-other-list">
						<a href="">退换货政策</a>
					</p>
					<p class="n-other-list">
						<a href="">退换货流程</a>
					</p>
					<p class="n-other-list">
						<a href="">退款方式与时效</a>
					</p>
					<p class="n-other-list">
						<a href="">投诉与建议</a>
					</p>
				</div>
			</div>
		</div>
		<!-- 底部导航区结束 -->
		<div class="footer-content-wrap">
			<div class="foter-content toCenter">
				<div class="footer-logo fl">
					<a href=""> <img src="images/footer-logo.png" alt=""
						class="footer-lgo-img" jqimg="images/footer-logo.png">
					</a>
				</div>
				<div class="rights">
					<ul class="r-list-wrap clear">
						<li class="r-list first-list"><a href="">牛男官网</a></li>
						<li class="r-list"><a href="">联系我们</a></li>
						<li class="r-list"><a href="">商品入驻</a></li>
						<li class="r-list"><a href="">隐私条款</a></li>
						<li class="r-list end-list"><a href="">友情链接</a></li>
					</ul>
					<p class="copyright">CopyRight 2016 上海财洋网络科技有限公司 NeoNan.com
						版权所有 经营许可证编号：沪B2-201</p>
				</div>
			</div>
		</div>
	</div>
<script src="js/jquery.min.js"></script>
<script src="js/goods-detail.js"></script>
</body>
</html>