$("#userId").change(function(){
var userId = $('#userId').val();
		$.ajax({
			url : '/api/v1/join/id/check?userId='+userId,
			type : 'get',
			success : function(useOK) {
				if (useOK == false) {
						// 1 : 아이디가 중복되는 문구
						$("#id_check").text("사용중인 아이디입니다 (｡ŏ_ŏ。)");
						$("#id_check").css("color", "red");
					} else {
						if(userId == ""){
							$('#id_check').text('아이디를 입력해주세요 ღ\'ᴗ\'ღ');
							$('#id_check').css('color', 'black');
						} else{
							$('#id_check').text('사용 가능한 아이디입니다. (๑˃̵ᴗ˂̵)و ♡');
							$('#id_check').css('color', 'green');
						}
					}
				}, error : function() {
						console.log("실패");
				}
			});
		});

$("#userStudentnumber").change(function(){
var userStudentnumber = $('#userStudentnumber').val();
		$.ajax({
			url : '/api/v1/join/studentnumber/check?userStudentnumber='+userStudentnumber,
			type : 'get',
			success : function(useOK) {
				if (useOK == false) {
						$("#studentnumber_check").text("사용중인 학번입니다 (｡ŏ_ŏ。)");
						$("#studentnumber_check").css("color", "red");
					} else {
						if(userStudentnumber == ""){
							$('#studentnumber_check').text('학번을 입력해주세요 ღ\'ᴗ\'ღ');
							$('#studentnumber_check').css('color', 'black');
						} else{
							$('#studentnumber_check').text('사용 가능한 학번입니다. (๑˃̵ᴗ˂̵)و ♡');
							$('#studentnumber_check').css('color', 'green');
						}
					}
				}, error : function() {
						console.log("실패");
				}
			});
		});


$("#userNickname").change(function(){
var userNickname = $('#userNickname').val();
		$.ajax({
			url : '/api/v1/join/nickname/check?userNickname='+userNickname,
			type : 'get',
			success : function(useOK) {
				if (useOK == false) {
						$("#nickname_check").text("사용중인 별명입니다 (｡ŏ_ŏ。)");
						$("#nickname_check").css("color", "red");
					} else {
						if(userNickname == ""){
							$('#nickname_check').text('별명을 입력해주세요 ღ\'ᴗ\'ღ');
							$('#nickname_check').css('color', 'black');
						} else{
							$('#nickname_check').text('사용 가능한 별명입니다. (๑˃̵ᴗ˂̵)و ♡');
							$('#nickname_check').css('color', 'green');
						}
					}
				}, error : function() {
						console.log("실패");
				}
			});
		});

function submitCheck(){
    var id_color = $('#id_check').css('color');
    var studentnumber_color = $('#studentnumber_check').css('color');
    var nickname_color = $('#nickname_check').css('color');

    if(id_color == "rgb(0, 128, 0)" && studentnumber_color == "rgb(0, 128, 0)" && nickname_color == "rgb(0, 128, 0)"){
        return true;
    } else if(id_color == "rgb(0, 128, 1)" && studentnumber_color == "rgb(0, 128, 1)" && nickname_color == "rgb(0, 128, 1)"){
        alert("아이디, 학번, 별명의 값을 변경해주십시오")
    } else {
        alert("입력이 올바르지 않습니다")
    }
        return false;
}

function inNumber(){
  if(event.keyCode<48 || event.keyCode>57){
     event.returnValue=false;
  }
}

function noHan(obj){
    if(event.keyCode == 8 || event.keyCode == 9 || event.keyCode == 37 || event.keyCode == 39 || event.keyCode == 46 ){
        return ;
    }
    obj.value = obj.value.replace(/[\ㄱ-ㅎ ㅏ-ㅣ 가-힣]/g,'');
}
