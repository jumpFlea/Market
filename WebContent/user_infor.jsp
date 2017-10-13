<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>个人信息－小马交易</title>
	<link rel="stylesheet" href="./css/niunan/neat.css">
	<link rel="stylesheet" href="css/niunan/public2.css">
	<link rel="stylesheet" href="css/niunan/user-public.css" />
	<link rel="stylesheet" href="./css/niunan/layout.css">
	<link rel="stylesheet" href="css/niunan/user-info-settings.css" />
</head>
<body>
<div class="header">
	<div class="header-content toCenter">
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
</div>
<div class="content">
	<div class="nn-inner-con">
		<!-- 左边菜单栏-->
		<div class="nn-left-menu pull-left">
			<ul class="nn-all-sort" id="all-sort">
				<li class="list-item">
					<div class="inner-bar text-center">
						<span class="txt-title">个人中心</span>
					</div>
				</li>
				<li class="list-item">
					<div class="avatar-box text-center">
						<img src="${u2.u_image}" onerror="src='images/user-head-pic.png'"/>
					</div>
				</li>
				<li class="list-item active">
					<div class="inner-bar">
						<a href="showUserInfor.action">
						<span class="img-icon">
							<img src="image/icon/coat-icon.png" alt=""/>
							</span> <span class="txt-title" style="color: #333">我的信息</span>
							<span class="pull-right img-icon"></span>
						</a>
					</div>
				</li>
				<li class="list-item">
					<div class="inner-bar">
						<a href="myOrders.action">
						<span class="img-icon">
							<img src="image/icon/coat-icon.png" alt=""/>
							</span> <span class="txt-title" style="color: #333">我的订单</span>
							<span class="pull-right img-icon"></span>
						</a>
					</div>
				</li>
				<li class="list-item">
					<div class="inner-bar">
						<a href="showReleaseGoods.action">
						<span class="img-icon">
							<img src="image/icon/coat-icon.png" alt=""/>
							</span> <span class="txt-title" style="color: #333">我的商品</span>
							<span class="pull-right img-icon"></span>
						</a>
					</div>
				</li>
				<li class="list-item">
					<div class="inner-bar">
						<a href="myFavorites.action">
						<span class="img-icon">
							<img src="image/icon/coat-icon.png" alt=""/>
							</span> <span class="txt-title" style="color: #333">我的收藏</span>
							<span class="pull-right img-icon"></span>
						</a>
					</div>
				</li>
				<li class="list-item">
					<div class="inner-bar">
						<a href="showAllAddress.action">
						<span class="img-icon">
							<img src="image/icon/coat-icon.png" alt=""/>
							</span> <span class="txt-title" style="color: #333">我的地址</span>
							<span class="pull-right img-icon"></span>
						</a>
					</div>
				</li>
				<c:if test="${authority >= 1}">
						<li class="list-item">
							<div class="inner-bar">
								<a href="member.action">
						<span class="img-icon">
							<img src="image/icon/coat-icon.png" alt=""/>
							</span> <span class="txt-title" style="color: #333">会员管理</span>
									<span class="pull-right img-icon"></span>
								</a>
							</div>
						</li>
					</c:if>
			</ul>
		</div>

		<!-- 右边内容分区栏 -->
		<div class="nn-right-content">

			<div class="nn-info-settings">
				<p class="info-settings">
					<span class="info-settings-txt">我的信息</span>
				</p>
				<br>
				<div class="pb-col-4">
					<img src="${u2.u_image}" height="200px" width="200px" height="200px" onerror='src="images/user-head-pic.png"'/>
					<span class="cover-show"></span>
				</div>
				<div class="pb-col-8">
					<br>
					<h4>
						用户名:<strong>${u2.username}</strong>
					</h4>
					<h4>
						邮箱:<strong>${u2.email}</strong>
					</h4>
				</div>
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
					class="footer-lgo-img">
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
<script src="./js/lib/sea.js"></script>
<script>
    seajs.config({
        base: "./js",
        alias: {
            "jquery": "lib/jquery.min",
            'swiper': 'lib/swiper.min'
        }
    });
    // 加载入口模块
    seajs.use("main/page-user-settings", function(init){
        init.initPage();
    });
</script>
</body>
</html>