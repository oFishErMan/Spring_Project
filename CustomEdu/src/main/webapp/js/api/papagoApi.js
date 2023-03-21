$(function() {
	$("#getpapago").click(function() {
		var ko = $("#korean").val();
		$.ajax({
			url: "papagoApiEn",
			type: "post",
			dataType: "json",
			data: { korean: ko },
			success: function(data) {
				var china = data.message.result.translatedText;
				console.log(data);
				$("#english").html(china);
			}, error: function(e) {
				alert("오류")
				console.log(e);
			}
		});
		$.ajax({
			url: "papagoApiCh",
			type: "post",
			dataType: "json",
			data: { korean: ko },
			success: function(data) {
				var english = data.message.result.translatedText;
				console.log(data);
				$("#china").html(english);
			}, error: function(e) {
				alert("오류")
				console.log(e);
			}
		});
	});
})