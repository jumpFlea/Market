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
								<table>
								<form action="setAdress"  method="post">
									<div class="bd">
										<div class="item">
											<label>收货人姓名<span>*</span></label> <input type="text"
												name="name" id="Consignee" class="input"
												placeholder="收货人姓名" maxlength="15" autocomplete='off'>
											<p class="tip-msg tipMsg"></p>
										</div>
										<div class="item">
											<label>联系电话<span>*</span></label> <input type="text"
												name="tel" class="input" id="Telephone"
												placeholder="11位手机号" autocomplete='off'>
											<p class="tel-modify-tip" id="telModifyTip"></p>
											<p class="tip-msg tipMsg"></p>
										</div>
										<div class="item">
											<label>地址：<span>*</span></label> <input type="text"
												name="region" class="input" id="Telephone"
												placeholder="省市区" autocomplete='off'>
											<p class="tel-modify-tip" id="telModifyTip"></p>
											<p class="tip-msg tipMsg"></p>
										</div>
										<div class="item">
											<label>街道：<span>*</span></label> <input type="text"
												name="street" class="input" id="Telephone"
												placeholder="街道" autocomplete='off'>
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