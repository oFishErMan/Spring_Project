<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<head>
<title>Typography | Klorofil - Free Bootstrap Dashboard Template</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<!-- JQuery 및 Js 연결 -->
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script src="../../../js/Board/board.js"></script>
<!-- VENDOR CSS -->
<link rel="stylesheet"
	href="../../../assets/vendor/bootstrap/css/bootstrap.min.css">
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
<style>
</style>

<body>
	<!-- WRAPPER -->
	<div id="wrapper">
		<!-- NAVBAR -->
		<nav class="navbar navbar-default navbar-fixed-top">
			<div class="brand">
				<a href="../"><img
					src="../../../assets/img/logo-dark.png" alt="Klorofil Logo"
					class="img-responsive logo"></a>
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
		<!-- END NAVBAR -->
		<!-- LEFT SIDEBAR -->
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
		<!-- END LEFT SIDEBAR -->
		<!-- MAIN -->
		<div class="main">
			<!-- MAIN CONTENT -->
			<div class="main-content">
				<div class="container-fluid">
					<div class="panel">
						<div class="panel-heading">
							<h2 class="panel-title">Reg Board</h2>
							<div style="text-align: right; ">
								<input type="button" class="btn btn-primary" value="수정"
									onclick="location.href='/board/modifyBoard?board_seq=${list.board_seq}'" id="regBoard-btn"
									style="margin-right: 5px;">
								<button type="button" class="btn btn-third"
									onclick="location.href='/board/boardList'">글 목록</button>
							</div>
						</div>
						<div>
							<div style="padding-left: 20px; padding-right: 20px;">
								<h4 style="font-weight: bold;">제목</h4>
								<span style="font-size: 18px">${list.board_title}</span>
								<h4 style="font-weight: bold;">작성자</h4>
								<span style="border: 2px;">${list.board_writer}</span>
								<h4 style="font-weight: bold;">작성 날짜</h4>
								<span style="border: 2px;">${list.board_reg_date}</span>
								<h4 style="font-weight: bold;">수정 날짜</h4>
								<span style="border: 2px;">${list.board_mod_date}</span>
								<h4 style="font-weight: bold;">내용</h4>
								<span style="border: 2px;">${list.board_text}</span>
								<h4 style="font-weight: bold;">이미지</h4>
								<img src="${path}/img/${list.board_img_path}" style="width: auto; height: auto; "><br>
								<div style="text-align: center;">
									<button  onclick="incGood()">추천<br>${list.board_good}</button>
								</div>
								<h4 style="font-weight: bold;">댓글</h4>
								
								<c:forEach items="${reply_list}" var="reply_list">
								<div style="border: 1px solid #d3d3d3; margin-bottom: 5px;">
								<span style="font-weight: bold;">작성자 : ${reply_list.reply_writer}</span><br><br>
								<span style=""> 내 용 : ${reply_list.reply_text}</span><br>
								</div>
								</c:forEach>
								<h4 style="font-weight: bold;">댓글 작성</h4>
								<form action="/board/addReply" method="post">
								<input type="hidden" value="<%=id%>" id="reply_writer" name="reply_writer">
								<input type="hidden" value="${list.board_seq}" id="reply_seq" name="reply_seq">
								<textarea id="reply_text" name="reply_text" rows="3" style="width: 400px;" ></textarea><br>
								<input type="submit" value="작성">
								</form>
							</div>
						</div>
						<div class="panel-body"></div>
					</div>
				</div>
			</div>
		</div>
		<!-- END MAIN CONTENT -->
	</div>
	<!-- END MAIN -->
	<div class="clearfix"></div>
	<footer>
		<div class="container-fluid">
			<p class="copyright">
				Shared by <i class="fa fa-love"></i><a
					href="https://bootstrapthemes.co">BootstrapThemes</a>
			</p>
		</div>
	</footer>
	<!-- END WRAPPER -->
	<!-- Javascript -->
	<script src="../../../assets/vendor/jquery/jquery.min.js"></script>
	<script src="../../../assets/vendor/bootstrap/js/bootstrap.min.js"></script>
	<script
		src="../../../assets/vendor/jquery-slimscroll/jquery.slimscroll.min.js"></script>
	<script src="../../../assets/scripts/klorofil-common.js"></script>
</body>

</html>
