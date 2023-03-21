//게시글 삭제(board_del_yn y ->n)
// foreach문 고려
function delBoard() {
	alert("board.js의 delBoard 함수 호출");

	var url = "delBoard";
	var valueArr = new Array();
	var list = $("input[name='target']");

	for (var i = 0; i < list.length; i++) {
		if (list[i].checked) {//선택되어 있으면 배열에 값을 저장함
			valueArr.push(list[i].value);
		}
	}
	if (valueArr.length == 0) {
		alert("삭제할 글을 선택해 주세요.")
	}
	else {
		var chk = confirm("정말 삭제하시겠습니까?")
		$.ajax({
			url: url,
			type: 'post',
			data: {
				'valueArr': valueArr
			},
			success: function() {
				alert("삭제가 완료되었습니다.")
				location.reload();
			},
			error: function(error) {
				alert("에러 발생");
			}
		})
	}
}

//게시글 검색
function searchBoard() {
	alert("board.js의 searchBoard 함수 호출");

	var searchBoard = $('#searchBoard').val();
	location.href = '/board/boardList?search=' + searchBoard
}
//게시글 수정
function modifyBoard() {

	alert("board.js의 modifyBoard 함수 호출");

	var board = {
		"board_seq": $('#hiddenId').val(),
		"board_title": $('#board_title').val(),
		"board_text": $('#board_text').val()
	};
	console.log(board);

	$.ajax({
		url: 'modifyBoardGo',
		type: 'post',
		data: board,
		success: function() {
			alert("게시글 수정이 완료되었습니다.");
			location.href = '/board/boardList'
		},
		error: function(error) {
			alert("에러");
		}
	});
}

function incGood() {

	let list = {
		"board_seq" : $('#reply_seq').val(),
		"board_email" : $('#reply_writer').val()
	}; 
 
	console.log(seq);
	$.ajax({
		url: 'incGood',
		type: 'post',
		data: JSON.stringify(list),
		contentType: 'application/json; charset=utf-8',
		success: function() {
			alert("추천이 완료되었습니다.");
			location.reload();
		},
		error: function(error) {
			alert("에러");
		}
	});
}




//로그팩토리 로거
//게시글 등록
/*function addBoard() {

	let img_upload = new FormData();

	let inputFile = $("input[name='img-upload']");

	let files = inputFile[0].files;

	console.log("thisisimg" + inputFile)

	img_upload.append("img-upload", inputFile);

	for (var i = 0; i < files.length; i++) {
		img_upload.append("img_upload", files[i])
	}

	var board = {
		board_title: $('#board_title').val(),
		board_writer: $('#board_writer').val(),
		board_text: $('#board_text').val()
	};
	console.log(board);
	console.log(img_upload);

	$.ajax({
		url: 'addBoard',
		type: 'post',
		data: JSON.stringify(board),
		contentType: 'application/json; charset=utf-8',
		success: function() {
			alert("게시글이 등록되었습니다.");
			location.href = '/board/boardList'
		},
		error: function(error) {
			alert("에러");
		}
	});

}*/