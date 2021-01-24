/**
 * 
 */
 
 
function checkPassword() {
	if (joinForm.password.value != joinForm.password2.value) {
		alert("같은 비밀번호를 입력해 주세요");
		return false;
	}
}

 
/* 
$(document).ready(function(){
	$(".commentList").load("getCommentList.do?ref=${board.ref}");	
	
	$("#insertComment").click(function(){
		var query = {
			writer: $("#writer").val(),
			content: $("#content").val(),
			passwd: $("#passwd").val(),
			ref: $("#ref").val()
		};
		
		$.ajax({
			type: "GET",
			url: "/myapp/insertComment.do",
			data: query,
			success: function(data) {
				$(".commentList").load("getCommentList.do");
				document.location.reload();
			}
		});	
	});
	
	$("#deleteComment").click(function(){
		alert("deleteComment");
		
		var query = {
			seq: $("seq").val()
		};
		
		$.ajax({
			type: "GET",
			url: "/myapp/deleteComment.do",
			data: query,
			success: function(data) {
				$(".commentList").load("getCommentList.do");
				document.location.reload();
			}
		});
		
	});	
	
});

*/