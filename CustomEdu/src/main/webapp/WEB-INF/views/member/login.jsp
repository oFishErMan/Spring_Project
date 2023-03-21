<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>Login | Klorofil - Free Bootstrap Dashboard Template</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script src="../../../js/user/member.js"></script>
<!-- VENDOR CSS -->
<link rel="stylesheet" href="../../../assets/css/bootstrap.min.css">
<link rel="stylesheet"
	href="../../../assets/vendor/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet"
	href="../../../assets/vendor/linearicons/style.css">
<!-- MAIN CSS -->
<link rel="stylesheet" href="../../../assets/css/main.css">
<!-- FOR DEMO PURPOSES ONLY. You should remove this in your project -->
<link rel="stylesheet" href="../../../assets/css/demo.css">
<!-- GOOGLE FONTS -->
<link
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700"
	rel="stylesheet">
<!-- ICONS -->
<link rel="apple-touch-icon" sizes="76x76"
	href="../../../assets/img/apple-icon.png">
<link rel="icon" type="image/png" sizes="96x96"
	href="../../../assets/img/favicon.png">
</head>

<body>
	<!-- WRAPPER -->
	<div id="wrapper">
		<div class="vertical-align-wrap">
			<div class="vertical-align-middle">
				<div class="auth-box ">
					<div class="left">
						<div class="content">
							<div class="header">
								<div class="logo text-center">
									<img src="../../../assets/img/logo-dark.png"
										alt="Klorofil Logo">
								</div>
								<p class="lead">Login to your account</p>
							</div>
							<form class="form-auth-small" action="${cpath}/signIn} method="post">
								<div class="form-group">
									<label for="signin-email" class="control-label sr-only">Email</label>
									<input type="email" class="form-control" id="signin-email"
										name="signin-email" placeholder="Email" required="required"
										autofocus="autofocus">
								</div>
								<div class="form-group">
									<label for="signin-password" class="control-label sr-only">Password</label>
									<input type="password" class="form-control" id="signin-pwd"
										name="signin-pwd" required="required" placeholder="Password">
								</div>
								<div class="form-group clearfix">
									<label class="fancy-checkbox element-left"> <input
										type="checkbox" id="save_id" name="save_id"> <span>Remember me</span>
									</label>
								</div>
								<button type="button" class="btn btn-primary btn-lg btn-block"
									id="login-btn" onclick="signIn()">LOGIN</button>
								<button type="button" class="btn btn-secondary btn-lg btn-block"
									onclick="location.href = 'signup';">Sign Up</button>
								<div class="bottom">
									<span class="helper-text"><i class="fa fa-lock"></i> <a
										href="#">Forgot password?</a></span>

								</div>
							</form>
						</div>
					</div>
					<div class="right">
						<div class="overlay"></div>
						<div class="content text">
							<h1 class="heading">Free Bootstrap dashboard template</h1>
							<p>by The Develovers</p>
						</div>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
	</div>
	<!-- END WRAPPER -->
</body>

</html>