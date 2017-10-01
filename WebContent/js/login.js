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
        url: 'login',
        method: 'post',
        data: $('#login-form').serialize(),
        success:function (data) {
            if(data.search("yes") !== -1){
                $('#login').find('h1').text("登录成功, 跳转中......");
                location.href="indexShow" 
                setTimeout(refresh,2000);
            }
            else {
                $('#login').find('h1').text("用户名或密码错误");
            }
        }
    })
}

function signup() {
    $('#signup').find('h1').text("注册中......");

    $.ajax({
        url: 'signup',
        method: 'post',
        data: $('#signup-form').serialize()
    }).done(function (data) {
        if(data.search("yes") !== -1){
            $('#signup').find('h1').text("注册成功, 刷新中......");
            setTimeout(refresh,2000);
        }
        else {
            $('#signup').find('h1').text("用户名已被占用");
        }
    }).fail(function () {
        $('#signup').find('h1').text("请刷新浏览器重试");
    });
}

function refresh() {
    window.location.href="login.html";
}