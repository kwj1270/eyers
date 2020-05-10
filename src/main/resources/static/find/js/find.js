$("#find_button").click(function(){
        var find_url = $("#find_form").attr("action");
		$.ajax({
			url : find_url,
			data:$('form').serialize(),
			type : 'post',
			success : function(findOk) {
                    $('.find_text').empty();
                    $('.find_text').html(findOk);
				}, error : function() {
						console.log("실패");
				}
			});
		});