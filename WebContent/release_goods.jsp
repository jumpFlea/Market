<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>商品详情</title>
<link rel="stylesheet" href="css/neat.css">
<link rel="stylesheet" href="css/goodsdetails.css">
<link rel="stylesheet" href="css/layout.css">
<link rel="stylesheet" href="css/goods-detail.css">
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
		<form  action="releaseGoods"  enctype="multipart/form-data" method="post">

			<table id="release_table">
				<tr>
					<td>商品名字:<input class="release_input" type="text"
						name="goods.g_name">
					</td>
				</tr>
				<tr>
					<td>
						<div id="release_p">
							<div id="release_pic">
								<a onClick="$('input[name=upload]').click()" >添加图片</a>
								<!-- <img src="" alt=""
								width="170" height="170" /> -->
							</div>
						</div>
					</td>
				</tr>
				<div id="release_attribute">
					<tr>
						<td><input class="release_input" type="file" name="upload" onchange="previewImage(this)"></td>
					</tr>
					<tr>
						<td>商品类型: <select name="goods.g_attribute">
								<option value="上衣">上衣</option>
								<option value="牙刷">牙刷</option>
								<option value="电动车">电动车</option>
								<option value="汽车">汽车</option>
								<option value="电冰箱">电冰箱</option>
						</select>
						</td>
					</tr>
					<tr>
						<td>商品价格:<input class="release_input" type="text"
							name="goods.g_price">
						</td>
					</tr>
					<tr>
						<td>市场价:<input class="release_input" type="text"
							name="goods.market_price">
						</td>
					</tr>
					<tr>
						<td>商品数量:<input class="release_input" type="text"
								name="goods.restnum"></input>
						</td>
					</tr>
					<tr>
						<td>商品介绍:<textarea class="release_input" type="text"
								name="goods.introduce"></textarea>
						</td>
					</tr>
					
					<tr>
						<td><input type="submit" value="提交"></td>
					</tr>

				</div>
			</table>
		</form>
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