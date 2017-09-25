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

</head>

<body>
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
                            <input type="checkbox" value="${ goods.g_price}" name="newslist"/></td>
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
                            <input name="text_box1" type="text" value="1" style="width: 30px; text-align: center; border: 1px solid #ccc;"/>
                            <input class="add1" name="add1" style="width: 20px; height: 18px; border: 1px solid #ccc;" type="button" value="+"/>
                        </td>
                        <td class="tb1_td6">
                            <label class="tot" style="color: #ff5500; font-size: 14px; font-weight: bold;"><c:out value="${ goods.g_price}"></c:out></label>
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