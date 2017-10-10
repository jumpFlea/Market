<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>我的订单－小马交易</title>
    <link rel="stylesheet" href="./css/niunan/neat.css">
    <link rel="stylesheet" href="./css/niunan/public.css">
    <link rel="stylesheet" href="./css/niunan/layout.css">
    <link rel="stylesheet" href="./css/niunan/user-public.css">
    <link rel="stylesheet" href="./css/niunan/user-order-list.css">
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
                    <li class="nav-item first-item">
                        [<a href="login.html" class="login">登录 </a>
                        <a href="login.html#signup" class="register">注册</a> ]
                    </li>
                </c:if>
                <c:if test="${user != null}">
                    <li class="nav-item"><a href="getshopcargoods.action">购物车</a></li>
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
        <!-- 左边菜单栏-->
        <div class="nn-left-menu pull-left">
            <ul class="nn-all-sort" id="all-sort">
                <li class="list-item">
                    <div class="inner-bar">
                        <span class="txt-title">个人中心</span>
                        <span class="triangle-up pull-right"></span>
                    </div>
                </li>
                <li class="list-item">
                    <div class="avatar-box text-center">
                        <c:if test="${u2.u_image != null}">
                            <img src="${u2.u_image}"/>
                        </c:if>
                        <c:if test="${u2.u_image == null}">
                            <img src="images/user-head-pic.png" alt=""/>
                        </c:if>
                    </div>
                </li>
                <li class="list-item active">
                    <div class="inner-bar">
                        <a href="showUserInfor.action">
						<span class="img-icon">
							<img src="image/icon/coat-icon.png" alt=""/>
							</span> <span class="txt-title" style="color: #333">个人信息</span>
                            <span class="pull-right img-icon"></span>
                        </a>
                    </div>
                </li>
                <li class="list-item">
                    <div class="inner-bar">
						<span class="img-icon"> <img
                                src="image/icon/coat-icon.png" alt="" />
						</span> <span class="txt-title">服务管理</span> <span
                            class="pull-right icon-toggle plus-icon"></span>
                    </div>
                    <ul class="sub-menu-list" style="display: none">
                        <li class="sub-list-item"><a href="myOrders.action" class="item-link">
                            <span class="triangle-right pull-left"></span> <span
                                class="sub-list-txt">我的订单</span>
                        </a></li>
                        <li class="sub-list-item"><a href="" class="item-link">
                            <span class="triangle-right pull-left"></span> <span
                                class="sub-list-txt">我的收藏</span>
                        </a></li>
                    </ul>
                </li>
                <li class="list-item">
                    <div class="inner-bar">
						<span class="img-icon"> <img
                                src="image/icon/coat-icon.png" alt="" />
						</span> <span class="txt-title">个人设置</span> <span
                            class="pull-right icon-toggle plus-icon"></span>
                    </div>
                    <ul class="sub-menu-list" style="display: none">
                        <li class="sub-list-item"><a href="userinfor_update.jsp" class="item-link">
                            <span class="triangle-right pull-left"></span> <span
                                class="sub-list-txt">信息修改</span>
                        </a></li>
                        <li class="sub-list-item"><a href="showAllAddress" class="item-link">
                            <span class="triangle-right pull-left"></span> <span
                                class="sub-list-txt">地址管理</span>
                        </a></li>
                    </ul>
                </li>

            </ul>
        </div>

        <!-- 右边内容分区栏 -->
        <div class="nn-right-content">

            <div class="nn-order-list">
                <p class="order-list-title">
                    <span class="order-list-title-txt">我的订单</span>
                </p>
                <p class="nn-order-status">
                    <span class="status-item"><a class="active" href="">全部订单</a></span>
                    <span class="status-item"><a href="">待付款</a></span>
                    <span class="status-item"><a href="">待发货</a></span>
                    <span class="status-item"><a href="">已发货</a></span>
                    <span class="status-item"><a href="">已完成</a></span>
                </p>

                <div class="nn-order-list-wrap" id="nn-order-list-wrap">
                    <c:forEach items="${orders}" var="order">
                        <div class="order-list-item">
                            <div class="order-num-box">
                                <p class="order-status pull-right">
                                    <c:if test="${order.status == '1'}">
                                        待付款
                                    </c:if>
                                    <c:if test="${order.status == '2'}">
                                        待发货
                                    </c:if>
                                    <c:if test="${order.status == '3'}">
                                        已发货
                                    </c:if>
                                    <c:if test="${order.status == '4'}">
                                        已完成
                                    </c:if>
                                </p>
                                <p class="order-string">
                                    <span class="order-item-txt">订单编号:</span>
                                    <span class="">${order.id}</span>
                                </p>
                            </div>
                            <div class="order-item-detail">
                                <div class="main-detail-box">

                                    <c:forEach items="${order.goodsList}" var="goods">
                                        <div>
                                            <div class="order-cover pull-left">
                                                <img src="${goods.image}" alt=""/>
                                            </div>
                                            <h3 class="order-title"><a href="${goods.id}">${goods.name}</a></h3>
                                            <p class="price-wrap">
                                            <span class="unit-price-wrap margin-r-20">
                                                ￥<span class="unit-wrap price">${goods.price}</span> X <span class="item-num">${goods.number}</span>
                                            </span>
                                            </p>
                                        </div>
                                        <div class="line"></div>
                                    </c:forEach>
                                    <div class="order-count">
                                        <p class="recieve-address pull-right">收货地址：${order.region} ${order.street} ${order.name}</p>
                                        <br>
                                        <span class="unit-price-wrap pull-right">
                                            总计：￥
                                            <span class="unit-wrap price">${order.price}</span>
                                        </span>
                                        <br>
                                        <div class="line"></div>
                                        <div class="right-button-group pull-right">
                                            <c:if test="${order.status == '1'}">
                                                <span class="button-item">
                                                    <a href="alipay/alipay.trade.page.pay.jsp?WIDout_trade_no=${order.id}&WIDtotal_amount=${order.price}&WIDsubject=小马交易二手商品交易&WIDbody=test"
                                                       class="button current">立即付款</a></span>
                                                <span class="button-item"><a href="cancellationOrder.action?ordernumber=${order.id}" class="button">取消订单</a></span>
                                            </c:if>
                                            <c:if test="${order.status == '2'}">
                                                <span class="button-item"><a href="javascript:;" class="button">查看订单</a></span>
                                                <span class="button-item"><a href="javascript:;" class="button">催牛哥发货</a></span>
                                            </c:if>
                                            <c:if test="${order.status == '3'}">
                                                <span class="button-item"><a href="javascript:;" class="button">查看订单</a></span>
                                                <span class="button-item"><a href="javascript:;" class="button">查看物流</a></span>
                                                <span class="button-item"><a href="javascript:;" class="button current">确定发货</a></span>
                                            </c:if>
                                            <c:if test="${order.status == '4'}">
                                                <span class="button-item"><a href="javascript:;" class="button">查看订单</a></span>
                                                <span class="button-item"><a href="javascript:;" class="button comment">五星好评</a></span>
                                                <span class="button-item"><a href="javascript:;" class="button">删除订单</a></span>
                                            </c:if>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                    <%-- 4 status: pend-payment, being-delivered, already-shipped, already-sign --%>

                </div>

                <div class="nn-loading-more">
                    <button class="loadding-more">加载更多...</button>
                </div>

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
                    <img src="../image/footer-logo.png" alt="" class="footer-lgo-img">
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
<!-- 评论框内容 -->
<div class="nn-comment-mask"></div>
<div class="nn-comment-content">
    <div class="close-row clearfix">
        <div class="close-comment pull-right"><img src="./image/icon/comment-close-icon.png" alt=""/></div>
    </div>
    <div class="star-wrap text-center">
        <img src="./image/icon/star-active-icon.png" alt=""/>
        <img src="./image/icon/star-icon.png" alt=""/>
        <img src="./image/icon/star-icon.png" alt=""/>
        <img src="./image/icon/star-icon.png" alt=""/>
        <img src="./image/icon/star-icon.png" alt=""/>
    </div>
    <div class="comment-content">
        <textarea class="content-area" placeholder="请填写评论，感谢您的支持！"></textarea>
    </div>
    <div class="text-center">
        <button class="comment-submit">提交评论</button>
    </div>
</div>

<script src="./js/lib/jquery.min.js"></script>
<script src="./js/user-public.js"></script>
<script>
    (function(){
        $(function(){
            var stars = ['../image/icon/star-active-icon.png', '../image/icon/star-icon.png'];
            var index = 1;      // 默认为1分
            $(".nn-comment-content .star-wrap").on("click", "img", function(){
                index = $(this).index() + 1;
                $(this).prevAll().add(this).attr("src", stars[0]);
                $(this).nextAll().attr("src", stars[1]);
            })
            //  提交评论
            $(".nn-comment-content .comment-submit").on("click", function(){
                var message = $.trim($(".nn-comment-content .content-area").val());
                if(!message){
                    alert("请填写评论信息.");
                    return;
                }
                var comment = {
                    score : index,
                    comment : message
                }
                alert(JSON.stringify(comment))
            })
        })
    })()
</script>
</body>
</html>