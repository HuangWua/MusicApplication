<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,700'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<link rel="stylesheet" href="resource/css/normalize.min.css">
<link href='resource/css/style.css' rel='stylesheet' type='text/css'>

<title>Login</title>
</head>
<body>
	<div class="wrapper">
		<form class="login">
			<p class="title">Log in</p>
			<input type="text" id="adminname" placeholder="Username"
				autofocus="autofocus" /> <i class="fa fa-user"></i> <input
				id="adminpwd" type="password" placeholder="Password" /> <i
				class="fa fa-key"></i> <a href="#">Forgot your password?</a>
			<button>
				<i class="spinner"></i> <span class="state">Log in</span>
			</button>
		</form>

		<div style="text-align: center; clear: both; margin-top: 80px"></div>

		</p>
	</div>

	<script src='resource/js/jquery-3.4.1.min.js'></script>

	<script type="text/javascript">
		var working = false;
		$('.login').on('submit', function(e) {
			e.preventDefault();
			if (working)
				return;
			working = true;
			var $this = $(this), $state = $this.find('button > .state');
			$this.addClass('loading');
			$state.html('Authenticating');
			var name = $('#adminname').val();
			var pwd = $('#adminpwd').val();
			$.post("admin/login.action", {
				adminname : name,
				adminpwd : pwd
			}, function(data) {
				if (data.adminid == null) {
					//alert("登入失败！");
					setTimeout(function() {
						alert("登入失败！");
						$state.html('Log in');
						$this.removeClass('ok loading');
						working = false;
					}, 1500);
					return;
				} else {
					setTimeout(function() {
						$this.addClass('ok');
						$state.html('Welcome back!');
					}, 3000);
				}
				$(location).prop('href','musics/selectAllMusics.action');
			});
		});

	</script>
</body>
</html>