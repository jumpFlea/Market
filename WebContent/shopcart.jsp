<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>商城整体布局</title>
    <link rel="stylesheet" href="./css/niunan/neat.css">
    <link rel="stylesheet" href="./css/niunan/public.css">
    <link rel="stylesheet" href="./css/niunan/layout.css">
    <link rel="stylesheet" href="./css/niunan/order-detail.css">
</head>
<body>
<div class="header">
    <div class="header-content toCenter">
        <h1 class="logo" title="牛男网商城">
            <a href=""><img src="images/logo.png" alt="" class="logo-img"></a>
        </h1>
        <div class="small-nav">
            <ul class="nav-wrap clear">

                <li class="nav-item end-item"><a href="">客户服务</a></li>
                <li class="nav-item"><a href="getshopcargoods">企业采购</a></li>
                <li class="nav-item"><a href="">商城会员</a></li>
                <li class="nav-item"><a href="#">我的订单</a></li>
                <c:if test="${user == null}">
                    <li class="nav-item first-item">
                        [<a href="login.html" class="login">登录 </a>
                        <a href="login.html#signup" class="register">注册</a> ]
                    </li>
                </c:if>
                <c:if test="${user != null}">
                    <li class="nav-item"><a href="getshopcargoods">购物车</a></li>
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

        <div class="nn-address-list">
            <div class="nn-address-list-wrap">
                <div class="address-list-item">
                    <div class="address-num-box">
                        <p class="address-string">
                            <span class="address-item-txt">收货地址</span>
                        </p>
                    </div>
                    <div class="address-item-detail">
                        <div class="right-button-group pull-right">
                            <span class="button-item"><a href="javascript:;" class="button">更换地址</a></span>
                        </div>
                        <div class="main-detail-box">
                            <p class="address-info-row">
                                <span class="address-info-title">收货人姓名：</span>
                                <span class="info-row">Teo Wang</span>
                            </p>
                            <p class="address-info-row">
                                <span class="address-info-title">地区：</span>
                                <span class="info-row">辽宁省 沈阳市</span>
                            </p>
                            <p class="address-info-row">
                                <span class="address-info-title">详细地址：</span>
                                <span class="info-row">大东区 宁夏路388号 6楼</span>
                            </p>
                            <p class="address-info-row">
                                <span class="address-info-title">邮编：</span>
                                <span class="info-row">113008</span>
                            </p>
                            <p class="address-info-row">
                                <span class="address-info-title">电话：</span>
                                <span class="info-row">155-4317-7777</span>
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="order-detail-wrap">
            <div class="order-list-bar shopping-cart">
                <div class="title-bar clearfix">
                    <span class="checkbox-col-item pull-left sub-title-style">&nbsp;</span>
                    <span class="first-col-item pull-left sub-title-style">&nbsp;</span>
                    <span class="second-col-item pull-left sub-title-style">商品详情</span>
                    <span class="third-col-item pull-left sub-title-style">单价</span>
                    <span class="fourth-col-item pull-left sub-title-style">数量</span>
                    <span class="fifth-col-item pull-left sub-title-style">小计</span>
                    <span class="button-col-item pull-left sub-title-style">&nbsp;</span>
                </div>

                <c:forEach items="${goodsList}" var="goods">
                    <div class="detail-bar clearfix">
                    <span class="checkbox-col-item pull-left text-center">
                        <input type="checkbox" value="">
                    </span>
                    <span class="first-col-item pull-left text-center">
                        <img src="${goods.imageSrc}" alt="">
                    </span>
                    <span class="second-col-item pull-left">
                        <p class="item-title"><a href="">${goods.goodsName}</a></p>
                        <p class="sub-title-style">
                            类型: <span class="item-color">${goods.attribute}</span>
                        </p>
                    </span>
                    <span class="third-col-item pull-left text-center">
                        <span class="sub-title-style">¥</span>
                        <span class="price-style">${goods.price}</span>
                    </span>
                    <span class="fourth-col-item pull-left">
                        <div class="num-wrap-component">
                            <button class="subtraction-calc">-</button>
                            <input type="text" class="item-number" value="${goods.number}" maxlength="4">
                            <button class="plus-calc">+</button>
                        </div>
                    </span>
                    <span class="fifth-col-item pull-left text-center">
                        <span class="sub-title-style">¥</span>
                        <span class="price-style">${goods.price * goods.number}</span>
                    </span>
                    <span class="button-col-item pull-left text-center">
                        <a href="addfavorite?uid=${user.uid}&goodsId=${goods.gid}" class="button">移入收藏</a>
                        <a href="delGoodsShopCart?uid=${user.uid}&goodsId=${goods.gid}" class="button">删除商品</a>
                    </span>
                </div>

                </c:forEach>
            </div>
        </div>
        <div class="order-total-box shopping-cart-total-box">
            <p class="shopping-goods-choose-box pull-left">
                <input type="checkbox" id="select-all">
                <label for="select-all">全选</label>
                <a href="javascript:;" class="remove-all">批量删除</a>
                <a href="javascript:;">移入收藏列表</a>
            </p>
            <p class="text-right">
                商品总价(<span>￥396.00</span>) - 活动(<span>￥0.00</span>) + 运费(<span>￥10.00</span>) = 商品金额总计(<span>￥406.00</span>)
            </p>
            <p class="text-right">
                商品总价（含运费）：￥<span class="price-style">406.00</span>
            </p>
            <div class="button-group clearfix">
                <button class="fast-payment pull-right">快速支付</button>
                <button class="continu-shop">继续购物</button>
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
    seajs.use("main/page-shopping-cart", function(init){
        init.initPage();
    });

</script>
</body>

</html>