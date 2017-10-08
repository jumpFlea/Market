$(document).ready(function(){
    $('.next-img-wrap,.per-img-wrap').hover(function () {
        $(this).addClass('adjust');
    },function () {
        $(this).removeClass('adjust');
    });

	$('.next-img-wrap').on('click',function(){
		var all = $('li','.list-ul').length;
		var top = parseInt($('.list-ul').css('top'));
        if (top <= -122){

        }
        else {
            $('.list-ul').animate({
                top:"-=122px"
            },200);
        }
	});
	$('.per-img-wrap').on('click',function(){
		var top =  parseInt($('.list-ul').css('top'));
        if(top >= 0){
        }
        else {
            $('.list-ul').animate({
                top:"+=122px"
            },200)
        }
	});
    //点击到中图
    var midChangeHandler = null;

    $("#imageMenu").find("li img").bind("click", function(){
        $('.onlickImg').removeClass('onlickImg');
        $(this).addClass('onlickImg');

        var mid = $(this).attr('data-mid');
        var big = $(this).attr('data-big');
        midChange(mid,big);
        $("#imageMenu").find("li").removeAttr("id");
        $(this).parent().attr("id", "onlickImg");
	});

    function midChange(src,big) {
        $("#midimg").attr("src", src).load(function() {
            changeViewImg(big);
        });
    }

    //大视窗看图
    function mouseover(e) {
        if ($("#winSelector").css("display") == "none") {
            $("#winSelector,#bigView").show();
        }
        $("#winSelector").css(fixedPosition(e));
        e.stopPropagation();
    }
    function mouseOut(e) {
        if ($("#winSelector").css("display") != "none") {
            $("#winSelector,#bigView").hide();
        }
        e.stopPropagation();
    }


    $("#midimg").mouseover(mouseover); //中图事件
    $("#midimg,#winSelector").mousemove(mouseover).mouseout(mouseOut); //选择器事件

    var $divWidth = $("#winSelector").width(); //选择器宽度
    var $divHeight = $("#winSelector").height(); //选择器高度
    var $imgWidth = $("#midimg").width(); //中图宽度
    var $imgHeight = $("#midimg").height(); //中图高度
    var $viewImgWidth = $viewImgHeight = $height = null; //IE加载后才能得到 大图宽度 大图高度 大图视窗高度

    function changeViewImg(big) {
    	$("#bigView img").attr("src",big);
    }
    $("#bigView").scrollLeft(0).scrollTop(0);
    function fixedPosition(e) {
        if (e == null) {
            alert('出现错误')
            return;
        }
        var $imgLeft = $("#midimg").offset().left; //中图左边距
        var $imgTop = $("#midimg").offset().top; //中图上边距
        X = e.pageX - $imgLeft - $divWidth / 2; //selector顶点坐标 X
        Y = e.pageY - $imgTop - $divHeight / 2; //selector顶点坐标 Y
        X = X < 0 ? 0 : X;
        Y = Y < 0 ? 0 : Y;
        X = X + $divWidth > $imgWidth ? $imgWidth - $divWidth : X;
        Y = Y + $divHeight > $imgHeight ? $imgHeight - $divHeight : Y;

        if ($viewImgWidth == null) {
            $viewImgWidth = $("#bigView img").outerWidth();
            $viewImgHeight = $("#bigView img").height();
            if ($viewImgWidth < 200 || $viewImgHeight < 200) {
                $viewImgWidth = $viewImgHeight = 800;
            }

            $height = $divHeight * $viewImgHeight / $imgHeight;
            $("#bigView").width($divWidth * $viewImgWidth / $imgWidth);
            $("#bigView").height($height);
        }
        var scrollX = X * $viewImgWidth / $imgWidth;
        var scrollY = Y * $viewImgHeight / $imgHeight;

        $("#bigView img").css({ "left": scrollX * -1, "top": scrollY * -1 });
        $("#bigView").css({ "top": 0, "left": $(".preview").position().left + $(".preview").width() });
        var obj = { left: X, top: Y };
        return { left: X, top: Y };
    }

});


var $numInput = $(".num-wrap-component .item-number");
var $numInputComponent = $(".num-wrap-component");
var $sub = $numInputComponent.find(".subtraction-calc");
var $plus = $numInputComponent.find(".plus-calc");
var $goodsNumber = 1;
$numInput.on("keydown", function(eve){
    var kc = eve.which;
    var $this = $(this);
    setTimeout(function(){      // 立即获取的值跟keydown事件获取上有所冲突
        // 排除数字键 删除键 和 左右键
        if(!(kc >47 && kc < 58) && kc != 8 && kc != 37 && kc != 39){
            $this.val(1);
        } else {
            // 删除按钮删除到input中无值的情况下
            if(!$this.val())
                $this.val(1);
        }
        checkoutValidate($this)
    }, 10)
});
checkoutValidate($numInput);
function checkoutValidate($input, max){
    max = max ? max : 9999;
    var val = parseInt($input.val());
    var $sub = $input.siblings(".subtraction-calc");
    var $plus = $input.siblings(".plus-calc");
    if(val == 1){
        $sub.attr("disabled", true);
    } else {
        $sub.attr("disabled", false);
    }
    if(max && val == max){
        $plus.attr("disabled", true);
    } else {
        $plus.attr("disabled", false);
    }
}
$sub.on("click", function(){
    var $input = $(this).siblings(".item-number")
    var val = parseInt($input.val());
    $input.val(--val);
    $goodsNumber--;
    checkoutValidate($input);
});
$plus.on("click", function(){
    var $input = $(this).siblings(".item-number")
    var val = parseInt($input.val());
    $input.val(++val);
    $goodsNumber++;
    checkoutValidate($input);
});


function addToCart(button) {
    $.get($(button).attr('ref')+"&goodsNum="+$goodsNumber,function (data) {
        if(data === "login"){
            window.location.href="login.html";
        }
        else if(data === "success"){
            $('.add-car-tips').show();
            $('.detail-number').hide();
        }
        else {
            window.location.href="indexShow";
        }
    });
    $.get("cartCount",function (data) {
        $('.cart-count').text(" "+data);
    })
}