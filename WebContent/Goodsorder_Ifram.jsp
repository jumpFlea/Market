<%@page import="java.util.List"%>
<%@page import="java.rmi.server.UID"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/lanrenzhijia.css" rel="stylesheet" type="text/css" />

<link href="css/public.css" type="text/css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="css/base.css" />
<script type="text/javascript" src="js/jquery_cart.js"></script>
<link rel="stylesheet" type="text/css" href="css/buyConfirm.css" />
<script src="js/jquery-1.11.1.min.js" type="text/javascript"></script>
<script src="js/unslider.min.js" type="text/javascript"></script>
<script src="js/index.js" type="text/javascript"></script>
<title></title>
</head>
<body>
	<div>
		<form action="setGoodinOrder" method="post">
		<c:forEach items="${goodsOrders_list}" var="goodsOrder">
			<table cellpadding="0" cellspacing="0" class="gwc_tb2">
				<tr>
					<td class="tb2_td1"><input type="checkbox" value="${ goodsOrder.g_price}"
						name="newslist" /></td>
					<td class="tb2_td2"><a href="#"> <img
							src="images/img1.jpg" />
					</a></td>
					<td class="tb2_td3"><a href="#"><c:out value="${ goodsOrder.g_name}"></c:out></a>
					</td>
					<td class="tb1_td4"><c:out value="${goodsOrder.ordernumber }"></c:out></td>

					<td class="tb1_td6"><label class="tot"
						style="color: #ff5500; font-size: 14px; font-weight: bold;"><c:out
								value=""></c:out></label></td>
					<td class="tb1_td7">商品号： <input
						style="width: 20px; height: 18px; border: 1px solid #ccc;"
						disabled="disabled" value="${ goodsOrder.g_id}" name="gid" />
					</td>
				</tr>
			</table>
			</c:forEach>
		</form>

	</div>
</body>
</html>