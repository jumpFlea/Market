<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>订单提交－小马交易</title>
    <link rel="stylesheet" href="./css/niunan/neat.css">
    <link rel="stylesheet" href="./css/niunan/public.css">
    <link rel="stylesheet" href="./css/niunan/layout.css">
    <link rel="stylesheet" href="./css/niunan/shopping-success.css">
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
                <li class="nav-item"><a href="userOrder.action">我的订单</a></li>
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
    <div class="nn-inner-con">
        <div class="shop-info-box">
            <div class="shop-suc-icon text-center">
                <img src="./image/icon/shopping-success-icon.png" width="100" alt="">
            </div>
            <h2 class="text-center">您的订单已成功，现在就去付款吧</h2>
            <p class="text-center">
                <span class="color-subblack">您的订单号:</span>
                <span class="order-num var-item">${orderId}</span>
                <span class="color-subblack">应付金额:</span>
                <span class="price var-item">${price}</span>元
                <span class="color-subblack">支付方式:</span>
                <span class="style var-item">在线支付</span>
            </p>
            <%--<p class="text-center color-subblack">155****5777，如果小时内无法完成订单，系统会将您的订单取消。</p>--%>
        </div>
        <div class="payment-method-box">
            <h5 class="payment-title">请选择支付方式:</h5>
            <div class="pb-center-row payment-styles">
                <span class="pb-col-3">
                    <button class="alipay-btn">alipay</button>
                </span>
                <span class="pb-col-3">
                    <button class="weichatpay-btn">weichatpay</button>
                </span>
                <span class="pb-col-3">
                    <button class="billpay-btn">99billpay</button>
                </span>
                <span class="pb-col-3">
                    <button class="onlinepay-btn">onlinepay</button>
                </span>
            </div>
        </div>
        <div class="button-group text-right">
            <button class="fast-payment" onclick="pay()">立即支付</button>
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
                <div class="f-list-title">
                    新手指南
                </div>
                <p class="n-other-list"><a href="">注册登录</a></p>
                <p class="n-other-list"><a href="">选购商品</a></p>
                <p class="n-other-list"><a href="">订单支付</a></p>
                <p class="n-other-list"><a href="">收货退款</a></p>
            </div>
            <div class="f-content-item">
                <div class="f-list-title">
                    购物指南
                </div>
                <p class="n-other-list"><a href="">海淘专区</a></p>
                <p class="n-other-list"><a href="">尺码选择</a></p>
                <p class="n-other-list"><a href="">开具发票</a></p>
                <p class="n-other-list"><a href="">商品咨询</a></p>
            </div>
            <div class="f-content-item">
                <div class="f-list-title">
                    支付方式
                </div>
                <p class="n-other-list"><a href="">在线支付</a></p>
                <p class="n-other-list"><a href="">货到付款</a></p>
                <p class="n-other-list"><a href="">优惠券</a></p>
                <p class="n-other-list"><a href="">有赞商城</a></p>
            </div>
            <div class="f-content-item">
                <div class="f-list-title">
                    配送方式
                </div>
                <p class="n-other-list"><a href="">配送时间</a></p>
                <p class="n-other-list"><a href="">配送范围</a></p>
                <p class="n-other-list"><a href="">顺丰速运</a></p>
                <p class="n-other-list"><a href="">商品验收与签字</a></p>
            </div>
            <div class="f-content-item">
                <div class="f-list-title">
                    售后服务
                </div>
                <p class="n-other-list"><a href="">退换货政策</a></p>
                <p class="n-other-list"><a href="">退换货流程</a></p>
                <p class="n-other-list"><a href="">退款方式与时效</a></p>
                <p class="n-other-list"><a href="">投诉与建议</a></p>
            </div>
        </div>
    </div>
    <!-- 底部导航区结束 -->
    <div class="footer-content-wrap">
        <div class="foter-content toCenter">
            <div class="footer-logo fl">
                <a href="">
                    <img src="./images/footer-logo.png" alt="" class="footer-lgo-img">
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
                <p class="copyright">CopyRight 2016 上海财洋网络科技有限公司  NeoNan.com 版权所有    经营许可证编号：沪B2-201</p>
            </div>
        </div>
    </div>
</div>
<script src="js/jquery-3.2.1.min.js"></script>
<script>
    function pay() {
        var url = 'alipay/alipay.trade.page.pay.jsp?' + 'WIDout_trade_no=' + $('.order-num').text();
        url = url + '&WIDtotal_amount=' + $('.price').text();
        url = url + '&WIDsubject=小马交易二手商品交易';
        url = url + '&WIDbody=test';
        $.get(url,function (data) {
            window.document.write(data);
        })
    }
</script>
</body>
</html>