<%@page import="com.qst.model.Adress"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>新增地址</title>

<script type="text/javascript" src="js/jquery_cart.js"></script>

</head>
<body>
<div class="xm-edit-addr-box" id="J_editAddrBox">
<% 
	int adid=Integer.parseInt( request.getParameter("adid"));
	String name=request.getParameter("name");
	String phone=request.getParameter("phone");
	String region=request.getParameter("region");
	String street=request.getParameter("street");
	
	request.setAttribute("adid", adid);
%>
								<table>
								<form action="editAdress"  method="post">
									<div class="bd">
										<div class="item">
											<label>地址id：<span>*</span></label> <input  type="hidden"
											value="<%=adid %>"	name="ad_id" id="Consignee" class="input"
												 maxlength="15" autocomplete='off'>
											<p class="tip-msg tipMsg" ></p>
										</div>
										<div class="item">
											<label>收货人姓名<span>*</span></label> <input type="text"
												name="name" id="Consignee" class="input"
												maxlength="15" autocomplete='off'>
											<p class="tip-msg tipMsg" ></p>
										</div>
										<div class="item">
											<label>联系电话<span>*</span></label> <input type="text"
												name="tel" class="input" id="Telephone"
												 autocomplete='off' >
											<p class="tel-modify-tip" id="telModifyTip"></p>
											<p class="tip-msg tipMsg"></p>
										</div>
										<div class="item">
											<label>地址：<span>*</span></label> <input type="text"
												name="region" class="input" id="Telephone"
												 autocomplete='off'>
											<p class="tel-modify-tip" id="telModifyTip"></p>
											<p class="tip-msg tipMsg"></p>
										</div>
										<div class="item">
											<label>街道：<span>*</span></label> <input type="text"
												name="street" class="input" id="Telephone"
												 autocomplete='off'>
											<p class="tel-modify-tip" id="telModifyTip"></p>
											<p class="tip-msg tipMsg"></p>
										</div>
										
										
									</div>
									<div class="ft clearfix">
										<button type="button" class="btn btn-lineDake btn-small "
											id="J_editAddrCancel">取消</button>
										<input type="submit" class="btn btn-primary  btn-small "
											id="J_editAddrOk" value="保存"/>
									</div>
									</form>
									</table>
								</div>

</body>
</html>