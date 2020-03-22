	$("user_id").change(function() {
		var id = $('#user_id').val();
		$.ajax({
			url : 'idCheck.do?id='+id,
			type : 'get',
			success : function(data) {						
				if (data == 1) {
						// 1 : 아이디가 중복되는 문구
						$("#id_check").text("사용중인 아이디입니다 :p");
						$("#id_check").css("color", "red");
					} else {
						if(id == ""){
							$('#id_check').text('아이디를 입력해주세요 :)');
							$('#id_check').css('color', 'green');
						} else{
							$('#id_check').text('사용가능한 아이디입니다. :)');
							$('#id_check').css('color', 'green');
						}
						
					}
				}, error : function() {
						console.log("실패");
				}
			});
		});