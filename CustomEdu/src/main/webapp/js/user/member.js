
//회원가입
/*let index = {
	init: function() {
		$('#join-btn').on('click', () => {
			alert("ddd")
			this.save();
		});
	}
	, save:*/


//회원가입
function join() {


	var custom_user_birth1 = $('#birth').val();
	var custom_user_phone1 = $('#phone').val();
	var user = {
		custom_user_name: $('#name').val(),
		custom_user_nick: $('#nick').val(),
		custom_user_pswd: $('#pwd').val(),
		custom_user_repeatpwd: $('#repeatpwd').val(),
		custom_user_email: $('#email').val(),
		custom_user_birth: custom_user_birth1.replace(/-/g, ''),
		custom_user_phone: custom_user_phone1.replace(/-/g, ''),
		custom_user_address: $('#addr').val()
	};
	console.log(user);
	if (user.custom_user_pswd != user.custom_user_repeatpwd) {

	} else {
		$.ajax({
			url: 'join',
			type: 'post',
			data: JSON.stringify(user),
			contentType: 'application/json; charset=utf-8',
			success: function() {
				alert("회원가입이 완료되었습니다.");
				location.href = '/login'
			},
			error: function(error) {
				alert("에러");
			}
		});
	}



}


//로그인
function signIn() {

	var user = {
		custom_user_pswd: $('#signin-pwd').val(),
		custom_user_email: $('#signin-email').val()
	};
	console.log(user);

	$.ajax({
		url: 'signIn',
		type: 'get',
		data: user,
		dataType: 'json',
		contentType: 'application/json; charset=utf-8',
		success: function(cnt) {
			if (cnt == 0) {
				alert("아이디 혹은 비밀번호를 다시 확인해주세요.")
				console.log(cnt + ' ' + user);

			} else {
				alert("로그인이 완료되었습니다.");
				location.href = '../index';
				console.log(cnt);
			}

		},
		error: function(error) {
			alert("login 함수 에러");
		}
	});

}
/*function loginSessionCheck() {
	if (cnt == 0) {
		$('.login_ok').css("display");
		$('.nick_already').css("display");
	} else {
		$('.nick_already').css("display");
		$('.nick_ok').css("display",);
		$('#nick').val('');
	}
}*/

//닉네임 유효성 검사
function nickCheck() {

	var user = new Object();
	user.name = $('#name').val();
	user.nick = $('#nick').val();
	user.pwd = $('#pwd').val();
	user.repeatpwd = $('#repeatpwd').val();
	user.email = $('#email').val();
	user.birth = $('#birth').val();
	user.phone = $('#phone').val();
	user.addr = $('#addr').val();

	$.ajax({
		url: 'nickCheck', //member Cont 연결
		type: 'post',
		data: { nick: user.nick },
		success: function(cnt) {
			if (cnt == 0) {
				$('.nick_ok').css("display", "inline-block");
				$('.nick_already').css("display", "none");
			} else {
				$('.nick_already').css("display", "inline-block");
				$('.nick_ok').css("display", "none");
				alert("아이디를 다시 입력해주세요.");
				$('#nick').val('');
			}
		},
		error: function() {
			alert("에러입니다.")
		}
	});
};
//전화번호 자동 형식
function oninputPhone(target) {
	target.value = target.value
		.replace(/[^0-9]/g, '')
		.replace(/(^02.{0}|^01.{1}|[0-9]{3})([0-9]{4})([0-9]{4})/g, "$1-$2-$3");
}
//생년월일 자동 형식
function oninputBirth(target) {
	target.value = target.value
		.replace(/[^0-9]/g, '')
		.replace(/(^02.{0}|^01.{1}|[0-9]{4})([0-9]{2})([0-9]{2})/g, "$1-$2-$3");
}