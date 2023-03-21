<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<style>
.nick_ok {
	color: #008000;
	font-size: 12px;
	display: none;
}

.nick_already {
	color: #6A82FB;
	font-size: 12px;
	display: none;
}
</style>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script src="../../../js/user/member.js"></script>
<title>Sign up</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">

<!-- VENDOR CSS -->
<link rel="stylesheet"
	href="../../../assets/vendor/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="../../../assets/vendor/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet"
	href="../../../assets/vendor/linearicons/style.css">
<link rel="stylesheet"
	href="../../../assets/vendor/chartist/css/chartist-custom.css">
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


	<div id="wrapper">
		<!-- 네비게이션 바 시작 -->
		<nav class="navbar navbar-default navbar-fixed-top">
			<div class="brand">
				<a href="../index"><img src="../../../assets/img/logo-dark.png"
					alt="Klorofil Logo" class="img-responsive logo"></a>
			</div>
			<div class="container-fluid">
				<div class="navbar-btn">
					<button type="button" class="btn-toggle-fullwidth">
						<i class="lnr lnr-arrow-left-circle"></i>
					</button>
				</div>
				<form class="navbar-form navbar-left">
					<div class="input-group">
						<input type="text" value="" class="form-control"
							placeholder="Search dashboard..."> <span
							class="input-group-btn"><button type="button"
								class="btn btn-primary">Go</button></span>
					</div>
				</form>
				<%
				String id = (String) session.getAttribute("custom_user_email");
				%>
				<%
				if (id != null) {
				%>

				<div class="navbar-btn navbar-btn-right">
					<a class="btn btn-success update-pro" href="/member/logout"
						target="_blank"><i class="fa fa-rocket"></i> <span
						class="login_ok">로그아웃</span></a>
				</div>
				<%
				} else {
				%>
				<div class="navbar-btn navbar-btn-right">
					<a class="btn btn-success update-pro" href="/member/login"
						target="_blank"><i class="fa fa-rocket"></i> <span
						class="login_ok">로그인</span></a>
				</div>
				<%
				}
				%>

				<div id="navbar-menu">
					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown"><a href="#"
							class="dropdown-toggle icon-menu" data-toggle="dropdown"> <i
								class="lnr lnr-alarm"></i> <span class="badge bg-danger">5</span>
						</a>
							<ul class="dropdown-menu notifications">
								<li><a href="#" class="notification-item"><span
										class="dot bg-warning"></span>System space is almost full</a></li>
								<li><a href="#" class="notification-item"><span
										class="dot bg-danger"></span>You have 9 unfinished tasks</a></li>
								<li><a href="#" class="notification-item"><span
										class="dot bg-success"></span>Monthly report is available</a></li>
								<li><a href="#" class="notification-item"><span
										class="dot bg-warning"></span>Weekly meeting in 1 hour</a></li>
								<li><a href="#" class="notification-item"><span
										class="dot bg-success"></span>Your request has been approved</a></li>
								<li><a href="#" class="more">See all notifications</a></li>
							</ul></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown"><i class="lnr lnr-question-circle"></i>
								<span>Help</span> <i class="icon-submenu lnr lnr-chevron-down"></i></a>
							<ul class="dropdown-menu">
								<li><a href="#">Basic Use</a></li>
								<li><a href="#">Working With Data</a></li>
								<li><a href="#">Security</a></li>
								<li><a href="#">Troubleshooting</a></li>
							</ul></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown"> <%
							 if (id != null) {
							 %> <%=id%> <%
							 } else {
							 %><span class="login_no">로그인을 해주세요</span> <%
							 }
							 %> <i class="icon-submenu lnr lnr-chevron-down"></i></a>
							<ul class="dropdown-menu">
								<li><a href="#"><i class="lnr lnr-user"></i> <span>My
											Profile</span></a></li>
								<li><a href="#"><i class="lnr lnr-envelope"></i> <span>Message</span></a></li>
								<li><a href="#"><i class="lnr lnr-cog"></i> <span>Settings</span></a></li>
								<li><a href="#"><i class="lnr lnr-exit"></i> <span>Logout</span></a></li>
							</ul></li>
						<!-- <li>
							<a class="update-pro" href="https://www.themeineed.com/downloads/klorofil-pro-bootstrap-admin-dashboard-template/?utm_source=klorofil&utm_medium=template&utm_campaign=KlorofilPro" title="Upgrade to Pro" target="_blank"><i class="fa fa-rocket"></i> <span>UPGRADE TO PRO</span></a>
						</li> -->
					</ul>
				</div>
			</div>
		</nav>
		<!-- 네비게이션 바 끝 -->
		<!-- 사이드 바 시작 -->
		<div id="sidebar-nav" class="sidebar">
			<div class="sidebar-scroll">
				<nav>
					<ul class="nav">
						<li><a href="/" class="active"><i class="lnr lnr-home"></i>
								<span>Dashboard</span></a></li>
						<li><a href="/member/login"><i class="lnr lnr-file-empty"></i>
								<span>Login</span></a></li>
						<li><a href="/board/boardList" class=""><i
								class="lnr lnr-dice"></i> <span>Board</span></a></li>
						<li><a href="/jqgridapi/jqGrid" class=""><i
								class="lnr lnr-text-format"></i> <span>JqGrid</span></a></li>
						<li><a href="/api/papagoApiGo" class=""><i
								class="lnr lnr-linearicons"></i> <span>API</span></a></li>
					</ul>
				</nav>
			</div>
		</div>
		<!-- 사이드바 끝 -->


		<!-- 메인 -->
		<div class="main">
			<!-- MAIN CONTENT -->
			<div class="main-content">
				<div class="container-fluid">
					<div id="toastr-demo" class="panel">
						<!-- CONTEXTUAL -->
						<h3 class="page-title" style="font-weight: 400;">Sign Up</h3>
						<div class="form-group">
							<input type="text" class="form-control" id="name"
								placeholder="NAME">
						</div>
						<div class="form-group">
							<input type="text" class="form-control" id="nick" name="nick"
								placeholder="Nick" oninput="nickCheck()"> <span
								class="nick_ok">&nbsp;&nbsp;사용 가능한 아이디입니다.</span> <span
								class="nick_already">&nbsp;&nbsp;사용 불가능한 아이디입니다.</span>
						</div>
						<div class="form-group">
							<input type="password" class="form-control" id="pwd" name="pwd"
								placeholder="Pswd">
						</div>
						<div class="form-group">
							<input type="password" class="form-control" id="repeatpwd"
								name="repeatpwd" placeholder="ReapeatPwd">
						</div>
						<div class="form-group">
							<input type="text" class="form-control" id="email" name="email"
								placeholder="Email">
						</div>
						<div class="form-group">
							<input type="text" class="form-control" id="birth" name="birth"
								placeholder="Birth" oninput="oninputBirth(this)" maxlength="10">
						</div>
						<div class="form-group">
							<input type="text" class="form-control" id="phone" name="phone"
								placeholder="Phone" maxlength="13" oninput="oninputPhone(this)">
						</div>
						<div class="form-group">
							<input type="text" class="form-control" id="addr" name="addr"
								placeholder="Addr">
						</div>
						<input type="button" class="btn btn-primary btn-block"
							value="join" id="join-btn" onclick="join()"></input>
					</div>
				</div>
			</div>
			<!-- END MAIN CONTENT -->
		</div>
	</div>
</body>
</html>