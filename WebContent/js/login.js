$('.form').find('input, textarea').on('keyup blur focus', function (e) {

  var $this = $(this),
      label = $this.prev('label');

	  if (e.type === 'keyup') {
			if ($this.val() === '') {
          label.removeClass('active highlight');
        } else {
          label.addClass('active highlight');
        }
    } else if (e.type === 'blur') {
    	if( $this.val() === '' ) {
    		label.removeClass('active highlight');
			} else {
		    label.removeClass('highlight');
			}
    } else if (e.type === 'focus') {

      if( $this.val() === '' ) {
    		label.removeClass('highlight');
			}
      else if( $this.val() !== '' ) {
		    label.addClass('highlight');
			}
    }

});

$('.tab a').on('click', function (e) {

  e.preventDefault();

  $(this).parent().addClass('active');
  $(this).parent().siblings().removeClass('active');

  target = $(this).attr('href');

  $('.tab-content > div').not(target).hide();

  $(target).fadeIn(600);

});

function login() {
    $('#login').find('h1').text("登录中......");

    $.ajax({
        url: 'login',//跳转到struts
        method: 'post',//发起post请求，把数据传入login
        data: $('#login-form').serialize(),//得到form中的数据。传到login
        success:function (data) {//data是返回的结果
            if(data.search("yes") !== -1){
                $('#login').find('h1').text("登录成功, 跳转中......");
                location.href="indexShow"//从数据库获取数据，传入主界面
//                setTimeout(refresh,2000);
            }
            else {
                $('#login').find('h1').text("用户名或密码错误");
            }
        }
    })
}

//注册
function signup() {
	//打印提示信息
    $('#signup').find('h1').text("注册中......");

    var name = $('#username').val();//获取输入框的值

    $.get('validate?user.username=' + name, function (data) {//把获取的值传入user.username中，到action中
        if (data === "success") {
            $.ajax({
                url: 'signup',
                method: 'post',
                data: $('#signup-form').serialize()
            }).done(function (data) {//匹配返回值
                if(data.search("yes") !== -1){
                    $('#signup').find('h1').text("注册成功, 刷新中......");
                    setTimeout(refresh,3000);
                }
                else {
                    $('#signup').find('h1').text("用户名已被占用");
                }
            }).fail(function () {
                $('#signup').find('h1').text("请刷新浏览器重试");
            });
        }
        else {
            $('#signup').find('h1').text("用户名已被使用！");
        }
    });

}

function refresh() {
    window.location.href="login.html";
}