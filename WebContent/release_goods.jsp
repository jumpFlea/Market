<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品详情</title>
<link rel="stylesheet" href="css/niunan/neat.css">
<link rel="stylesheet" href="css/goodsdetails.css">
<link rel="stylesheet" href="css/niunan/layout.css">
<link rel="stylesheet" href="css/niunan/goods-detail.css">
<link rel="stylesheet" href="css/niunan/user-public.css" />
<link rel="stylesheet" href="css/niunan/user-info-settings.css" />
<style type="text/css">
</style>
</head>

<body>
	<div class="header">
		<div class="header-content toCenter">
			<h1 class="logo" title="牛男网商城">
				<a href=""><img src="image/logo.png" alt="" class="logo-img"></a>
			</h1>
			<div class="small-nav">
				<ul class="nav-wrap clear">
					<li class="nav-item end-item"><a href="">手机版</a></li>
					<li class="nav-item"><a href="">购物车</a></li>
					<li class="nav-item"><a href="">我的订单</a></li>
					<!--<li class="nav-item first-item">［
							<a href="" class="login">登录</a>
							<a href="" class="regester">立即注册</a>］</li>-->
				</ul>
			</div>
		</div>
	</div>

	<div class="content">
		<div class="nn-inner-con">
			<%-- 左边内容分区栏 --%>
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
					<li class="list-item">
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
					<li class="list-item active">
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
						<span class="info-settings-txt">发布商品</span>
					</p>
					<form action="releaseGoods" enctype="multipart/form-data"
						  method="post">
						<div class="info-input-row">
							<p class="input-wrap">
								商品名字:<input type="text" name="goods.g_name" />
							</p>
						</div>
						<div class="info-input-row">
							<p class="input-wrap">
								商品类型:<select name="goods.g_attribute" id="type_good">
								<option value="上衣">上衣</option>
								<option value="牙刷">牙刷</option>
								<option value="电动车">电动车</option>
								<option value="汽车">汽车</option>
								<option value="电冰箱">电冰箱</option>
							</select>
							</p>
						</div>
						<div class="info-input-row">
							<p class="input-wrap"><a onClick="$('input[name=upload]').click()">添加图片</a>
							<div id="release_pic">

							</div>
							<input class="release_input" type="file" name="upload"
								   onchange="previewImage(this)">
							<span class="cover-show"></span>
							</p>
						</div>

						<div class="info-input-row">
							<p class="input-wrap">
								商品价格:<input type="text" name="goods.g_price" />
							</p>
						</div>
						<div class="info-input-row">
							<p class="input-wrap">
								市场价:<input type="text" name="goods.market_price" />
							</p>
						</div>
						<div class="info-input-row">
							<p class="input-wrap">
								商品数量:<input type="text" name="goods.restnum" />
							</p>
						</div>
						<div class="info-input-row">
							<p class="input-wrap">
								商品简介:
								<textarea id="introduce_good" name="goods.introduce"></textarea>
							</p>
						</div>
						<div class="info-input-row">
							<p class="input-wrap">
								详情介绍:
								<textarea  name="goods.g_content"></textarea>
							</p>
						</div>
						<div class="button-group">
							<button type="submit" class="save-btn">保存</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<!-- 底部导航区结束 -->
	<div class="footer-content-wrap">
		<div class="foter-content toCenter">
			<div class="footer-logo fl">
				<a href=""> <img src="image/footer-logo.png" alt=""
					class="footer-lgo-img" jqimg="image/footer-logo.png">
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
				<p class="copyright">CopyRight 2016 上海财洋网络科技有限公司 NeoNan.com 版权所有
					经营许可证编号：沪B2-201</p>
			</div>
		</div>
	</div>

	<script src="js/jquery-3.2.1.min.js"></script>
	<script src="js/goods-detail.js"></script>
	<!--在div框中显示本张上传图片-->
	<script>
		function previewImage(file) {
			var MAXWIDTH = 180;
			var MAXHEIGHT = 180;
			var div = document.getElementById('release_pic');
			if (file.files && file.files[0]) {
				div.innerHTML = '<img id=imghead>';
				var img = document.getElementById('imghead');
				img.onload = function() {
					var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT,
							img.offsetWidth, img.offsetHeight);
					img.width = rect.width;
					img.height = rect.height;
					img.style.marginLeft = rect.left + 'px';
					img.style.marginTop = rect.top + 'px';
				}
				var reader = new FileReader();
				reader.onload = function(evt) {
					img.src = evt.target.result;
				}
				reader.readAsDataURL(file.files[0]);
			}
		}

		function clacImgZoomParam(maxWidth, maxHeight, width, height) {
			var param = {
				top : 0,
				left : 0,
				width : width,
				height : height
			};
			if (width > maxWidth || height > maxHeight) {
				rateWidth = width / maxWidth;
				rateHeight = height / maxHeight;
				if (rateWidth > rateHeight) {
					param.width = maxWidth;
					param.height = Math.round(height / rateWidth);
				} else {
					param.width = Math.round(width / rateHeight);
					param.height = maxHeight;
				}
			}
			param.left = Math.round((maxWidth - param.width) / 2);
			param.top = Math.round((maxHeight - param.height) / 2);
			return param;
		}
	</script>
</body>
</html>