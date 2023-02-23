
//회원가입
/*let index = {
	init: function() {
		$('#join-btn').on('click', () => {
			alert("ddd")
			this.save();
		});
	}
	, save:*/
function join() {
	alert("signup의 save 함수 호출");
	
	var birth1 = $('#birth').val();
	var phone1 = $('#phone').val(); 
	var user = {
		name: $('#name').val(),
		nick: $('#nick').val(),
		pwd: $('#pwd').val(),
		repeatpwd: $('#repeatpwd').val(),
		email: $('#email').val(),
		birth: birth1.replace(/-/g,''),
		phone: phone1.replace(/-/g,''),
		addr: $('#addr').val()
	};
	console.log(user);
	$.ajax({
		url: '/join',
		type: 'post',
		data: JSON.stringify(user),
		contentType: 'application/json; charset=utf-8',
		dataType: 'JSON'
	}).done(function(resp) {
		alert("회원가입이 완료되었습니다.");
		console.log(resp)
		location.href = '/login;'
	}).fail(function(error) {
		alert(JSON.stringify(error));
	});

}



/*$('#join-btn').on('click',function()  {
	console.log("join()실행")
	var user = new Object();
	var infoChk = 0;

	user.name = $('#name').val();
	user.nick = $('#nick').val();
	user.pwd = $('#pwd').val();
	user.repeatpwd = $('#repeatpwd').val();
	user.email = $('#email').val();
	user.birth = $('#birth').val();
	user.phone = $('#phone').val();
	user.addr = $('#addr').val();
	let reg = /[\{\}\[\]\/?.,;:|\)*~`!^\-_+<>@\#$%&\\\=\(\'\"]/g;//특수문자 확인
	let reg2 = /^[A-Za-z0-9]{1,30}$/; //글자수 확인

	if (reg.test(nick)) {
		alert("닉네임을 확인해주세요.")
		infoChk = 1;
	}
	if (!reg2.test(nick)) {
		alert("닉네임을 확인해주세요.")
		infoChk = 1;
	}

	if (pwd != repeatpwd) {
		alert("비밀번호 재입력을 확인해주세요")
		infoChk = 1;
	}

	if (infoChk == 0) {
		$.ajax({
			url: '/joinInsert',
			type: 'post',
			data: {
				nick: user.nick,
				name: user.name,
				email: user.email,
				pwd: user.pwd,
				birth: user.birth,
				phone: user.phone,
				addr: user.addr,
				auth: 2
			},
			dataType : 'JSON',
			contentType : "application/json; charset=utf-8"
			success: function(cnt) {
				
			}).fail(function() {
				alert("에러입니다.")
			});
		});
	} else {
		alert("개인 정보를 다시 확인해주세요.")
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
		url: '/nickCheck',
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