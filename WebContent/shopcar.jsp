<%@page import="com.qst.model.Goods"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.qst.serviceImpl.goodsServiceImpl"%>
<%@page import="java.rmi.server.UID"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>jquery模拟购物车多选结算页面效果</title>
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
	<!--顶部快捷菜单-->


	<!--顶部Logo及搜索-->
	<div class="header_2013">
		<div class="w">
			<div class="logo_v2013">
				<a href="#"> <img class="border_r" src="images/logo.jpg"
					width="120" height="50"> <img src="images/slogan.jpg"
						width="170" height="50"></a>
			</div>
			<div class="header_searchbox">
				<form action="#">
					<input name="search" type="text" class="header_search_input"
						default_val="锡货网三期上线全场五折" autocomplete="off" x-webkit-speech=""
						x-webkit-grammar="builtin:search" lang="zh">
						<button type="submit" class="header_search_btn">搜索</button>
				</form>
				<ul class="hot_word">
					<li><a class="red" href="#" target="_blank">礼品卡</a></li>
					<li><a target="_blank" href="#">百货五折</a></li>
					<li><a target="_blank" href="#">大闸蟹</a></li>
					<li><a target="_blank" href="#">年货</a></li>
					<li><a target="_blank" href="#">电子产品</a></li>
				</ul>
			</div>
			<div id="cart_box" class="cart_box">
				<a id="cart" class="cart_link" href="#" rel="nofollow"> <span
					class="text">去购物车结算</span> <img src="images/shopping_icon.png"
					width="24" height="24" class="cart_gif"> <!-- 购物车没有物品时，隐藏此num -->
						<span class="num">12</span> <s class="icon_arrow_right"></s></a>

				<div class="cart_content" id="cart_content">
					<i class="cart-icons"></i>
					<!-- 购物车没有物品时，显示cart_content_null、隐藏cart_content_all -->
					<div class="cart_content_null" style="display: none;">
						购物车中还没有商品，<br>快去挑选心爱的商品吧！
					</div>
					<div class="cart_content_all" style="display: block;">
						<div class="cart_left_time">
							<span>06分49.9秒</span> 后购物车将被清空，请及时结算
						</div>
						<div class="cart_content_center">
							<div class="cart_con_single">
								<div class="single_pic">
									<a href="#" target="_blank" alt="兰蔻 (Lancome)根源补养洁颜啫哩 125ml">
										<img src="images/goods_img01.jpg" />
									</a>
								</div>
								<div class="single_info">
									<a href="#" target="_blank" alt="兰蔻 (Lancome)根源补养洁颜啫哩 125ml"
										class="name">兰蔻 (Lancome)根源补养洁颜啫哩 125ml</a> <span
										class="price">￥269.00</span> <span class="price_plus">
										x </span> <span class="price_num">1</span>
								</div>
							</div>
						</div>
						<div class="con_all">
							<div class="price_whole">
								<span>共<span class="num_all">12</span>件商品
								</span>
							</div>
							<div>
								<span class="price_gongji">共计<em>￥</em><span
									class="total_price">69</span></span><a href="#" class="cart_btn"
									rel="nofollow">去购物车结算</a>
							</div>
						</div>
					</div>
				</div>
			</div>
			<span class="clr"></span>
		</div>
	</div>
	<!--顶部Logo及搜索-->
	
		<div class="yHeader">
		<div class="shop_Nav">
			<div class="pullDown">
				<h2 class="pullDownTitle">
					<i></i>全部商品分类
				</h2>
			</div>

			<ul class="Menu_box">
				<li><a href="" target="_blank" class="yMenua">首页</a></li>
				<li><a href="" target="_blank">大划算</a></li>
				<li><a href="" target="_blank">抢拍</a></li>
				<li><a href="" target="_blank">锡货专场</a></li>
				<li><a href="" target="_blank">锡货超市</a></li>
			</ul>
			<div class="fr r_icon">
				<i class="i01"></i><span>30天退货</span><i class="i02"></i><span>满59包邮</span>
			</div>
		</div>
	</div>
		<!--  导航条    end-->
	
	<div class="banner_red_top"></div>

	<div class="gwc" style="margin: auto;">

		<table cellpadding="0" cellspacing="0" class="gwc_tb1">
			<tr>
				<td class="tb1_td1"><input id="Checkbox1" type="checkbox"
					class="allselect" /></td>
				<td class="tb1_td1">全选</td>
				<td class="tb1_td3">商品</td>
				<td class="tb1_td4">商品信息</td>
				<td class="tb1_td5">数量</td>
				<td class="tb1_td6">单价</td>
				<td class="tb1_td7">操作</td>
			</tr>
		</table>


		<form action="setGoodinOrder" method="post">

			<c:forEach items="${goodlist}" var="goods">



				<table cellpadding="0" cellspacing="0" class="gwc_tb2">
                    <tr>
                        <td class="tb2_td1">
                            <input type="checkbox" value="${ goods.g_price}" name="newslist" id="newslist-1"/></td>
                        <td class="tb2_td2">
                            <a href="#">
                                <img src="images/img1.jpg"/>
                            </a>
                        </td>
                        <td class="tb2_td3">
                            <a href="#"><c:out value="${ goods.g_name}"></c:out></a>
                        </td>
                        <td class="tb1_td4">一件</td>
                        <td class="tb1_td5">
                            <input class="min1" name="min1" style="width: 20px; height: 18px; border: 1px solid #ccc;" type="button" value="-"/>
                            <input id="text_box1" name="text_box1" type="text" value="1" style="width: 30px; text-align: center; border: 1px solid #ccc;"/>
                            <input class="add1" name="add1" style="width: 20px; height: 18px; border: 1px solid #ccc;" type="button" value="+"/>
                        </td>
                        <td class="tb1_td6">
                            <label id="total1" class="tot" style="color: #ff5500; font-size: 14px; font-weight: bold;"><c:out value="${ goods.g_price}"></c:out></label>
                        </td>
                        <td class="tb1_td7"><a href="#">删除</a></td>
                        <td class="tb1_td7">商品号：
                            <input style="width: 20px; height: 18px; border: 1px solid #ccc;" type="text" value="${goods.g_id  }" name="gid"/>
                        </td>
                    </tr>

					</c:forEach>



					<table cellpadding="0" cellspacing="0" class="gwc_tb3">
						<tr>
							<td class="tb1_td1"><input id="checkAll" class="allselect"
								type="checkbox" /></td>
							<td class="tb1_td1">全选</td>
							<td class="tb3_td1"><input id="invert" type="checkbox" />
								反选 <input id="cancel" type="checkbox" /> 取消</td>
							<td class="tb3_td2">已选商品
								<label id="shuliang" style="color: #ff5500; font-size: 14px; font-weight: bold;">0</label>
								件
							</td>
							<td class="tb3_td3">合计(不含运费):
								<span>￥</span>
								<span style="color: #ff5500;">
									<label id="zong1" style="color: #ff5500; font-size: 14px; font-weight: bold;"></label>
								</span>
							</td>

							<input type="submit" style="display: none;" class="jz2" id="jz2"
								value="结算" />结算

						</tr>
					</table>
		</form>


	</div>
</body>
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/Calculation.js"></script>
<script>
    $(document).ready(function() {

        //jquery特效制作复选框全选反选取消(无插件)
        // 全选
        $(".allselect").click(function() {
            $(".gwc_tb2 input[name=newslist]").each(function() {
                $(this).attr("checked", true);
                // $(this).next().css({ "background-color": "#3366cc", "color": "#ffffff" });
            });
            GetCount();
        });

        //反选
        $("#invert").click(function() {
            $(".gwc_tb2 input[name=newslist]").each(function() {
                if ($(this).attr("checked")) {
                    $(this).attr("checked", false);
                    //$(this).next().css({ "background-color": "#ffffff", "color": "#000000" });
                } else {
                    $(this).attr("checked", true);
                    //$(this).next().css({ "background-color": "#3366cc", "color": "#000000" });
                }
            });
            GetCount();
        });

		//取消
		$("#cancel").click(function() {
			$(".gwc_tb2 input[name=newslist]").each(function() {
				$(this).attr("checked", false);
				// $(this).next().css({ "background-color": "#ffffff", "color": "#000000" });
			});
			GetCount();
		});

        // 所有复选(:checkbox)框点击事件
        $(".gwc_tb2 input[name=newslist]").click(function() {
            if ($(this).attr("checked")) {
                //$(this).next().css({ "background-color": "#3366cc", "color": "#ffffff" });
            } else {
                // $(this).next().css({ "background-color": "#ffffff", "color": "#000000" });
            }
        });

        // 输出
        $(".gwc_tb2 input[name=newslist]").click(function() {
            // $("#total2").html() = GetCount($(this));
            GetCount();
            //alert(conts);
        });
    });
    //******************
    function GetCount() {
        var conts = 0;
        var aa = 0;
        $(".gwc_tb2 input[name=newslist]").each(function() {
            if ($(this).attr("checked")) {
                for (var i = 0; i < $(this).length; i++) {
                    conts += parseInt($(this).val());
                    aa += 1;
                }
            }
        });
        $("#shuliang").text(aa);
        $("#zong1").html((conts).toFixed(2));
        $("#jz1").css("display", "none");
        $("#jz2").css("display", "block");
    }


    //修改购物车商品数量
    $('.min1').click(function () {
        var v = parseInt( $(this).next().val() );
        if(v > 1){
            $(this).next().val(v - 1);
        }
    });
    $('.add1').click(function () {
        var v = parseInt( $(this).prev().val() );
        $(this).prev().val(1 + v);
    })
</script>

</html>