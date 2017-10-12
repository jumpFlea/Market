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
<link href="css/lanrenzhijia.css" rel="stylesheet" type="text/css" />

<link href="css/public.css" type="text/css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/buyConfirm.css" />
<script src="js/unslider.min.js" type="text/javascript"></script>
<script src="js/index.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
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
						<a href="userOrder.action">我的订单</a>
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

		<table class="table table-striped" >
			<tr>
				<td>商品名字</td>
				<td>订单号</td>
				<td>数量</td>
				<td>价格</td>
				<td>支付状态</td>
			</tr>
		</table>
		

		<form action="" method="post">


			<c:forEach items="${goodsOrders2_list}" var="goods">



				<table cellpadding="0" cellspacing="0" class="gwc_tb2">
                    <tr>
                        <td class="tb2_td2">
                            <a href="#">
                                <img src="images/img1.jpg"/>
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

					</c:forEach>



					
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
                if ($('.allselect').prop("checked") === true) {
                    $(this).attr("checked", true);
                } else {
                    $(this).attr("checked", false);
                }
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
            GetCount();
        });

        // 输出
        $(".gwc_tb2 input[name=newslist]").click(function() {
            // $("#total2").html() = GetCount($(this));
            GetCount();
        });
    });
    //******************
    function GetCount() {
        var conts = 0;
        var aa = 0;
        $(".gwc_tb2 input[name=newslist]").each(function() {
            if ($(this).attr("checked")) {
				conts += parseInt($(this).val()) * parseInt(
                    $(this).closest('td').parent().find('input:nth-child(2)').val()
				);
				aa += 1;
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
        GetCount();
    });
    $('.add1').click(function () {
        var v = parseInt( $(this).prev().val() );
        $(this).prev().val(1 + v);
        GetCount();
    })
</script>

</html>