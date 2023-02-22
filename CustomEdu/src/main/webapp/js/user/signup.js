

function join() {
	//var name = document.getElementById("name");
	var user = new Object();


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


	if (!reg2.test(nick)) {
		alert("닉네임은 최소 1글자 최대 30글자까지 가능합니다.")
	}

	if (pwd != repeatpwd) {
		alert("비밀번호 재입력을 확인해주세요")
	}
	console.log("닉네임 체크 실행...");
}
function checkNick() {
	
	var user = new Object();
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