$(document).ready(function(){
    $("#user_password").focusout(function(){
        checkPassword($('#user_password').val(),$('#user_id').val());
    });

    $("#user_password").focus(function(){
        $('#txt_password_support2').css('display', 'none');
        $('#txt_password_support').css('display', 'inline-block');
        $('#txt_password_support').css('color', 'black');
        $('#txt_password_support').text('8~15자리의 영문, 숫자, 특수문자의 입력이 가능합니다.');
    });
/*
    $("#user_password").focusout(function(){
        $('#txt_password_support').css('display', 'none');
        $('#txt_password_support').text('');
    });
*/
})    

function checkPassword(password,id){
	if(!/^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,25}$/.test(password)){
        $('#txt_password_support').css('display', 'none');     
        $('#txt_password_support2').css('display', 'inline-block');
        $('#txt_password_support2').css('color', 'red');
        $('#txt_password_support2').text('숫자+영문자+특수문자 조합으로 8자리 이상 사용해야 합니다.');
        $('#user_password').val('')
        return false;
    }    
    let checkNumber = password.search(/[0-9]/g);
    let checkEnglish = password.search(/[a-z]/ig);
    if(checkNumber <0 || checkEnglish <0){
        $('#txt_password_support').css('display', 'none');
        $('#txt_password_support2').css('display', 'inline-block');
        $('#txt_password_support2').css('color', 'red');
        $('#txt_password_support2').text("숫자와 영문자를 혼용하여야 합니다.");
        $('#user_password').val('')
        return false;
    }
    if(/(\w)\1\1\1/.test(password)){
        $('#txt_password_support').css('display', 'none');
        $('#txt_password_support2').css('display', 'inline-block');
        $('#txt_password_support2').css('color', 'red');
        $('#txt_password_support2').text('같은 문자를 4번 이상 사용하실 수 없습니다.');
        $('#user_password').val('')
        return false;
    }
        
    if(password.search(id) > -1){
        $('#txt_password_support').css('display', 'none');
        $('#txt_password_support2').css('display', 'inline-block');
        $('#txt_password_support2').css('color', 'red');
        $('#txt_password_support2').text("비밀번호에 아이디가 포함되었습니다.");
        $('#user_password').val('')
        return false;
    }
    $('#txt_password_support2').css('display', 'none');    
    $('#txt_password_support').text("사용할 수 있는 비밀번호 입니다.");
    $('#txt_password_support').css('display', 'inline-block');
    $('#txt_password_support').css('color', 'green');
    return true;
}
   

