$(document).ready(function(){
    $('#user_password2').focusout(function () {
        correctPassword($('#user_password').val(),$('#user_password2').val());
    });
})

function correctPassword(password,password2){
    if (password != "" || password2 != "") {
        if (password == password2) {
            $("#txt_passwordMatch_support").text('비밀번호가 일치합니다');
            $("#txt_passwordMatch_support").css('color', 'green');
        } else {
            $("#txt_passwordMatch_support").text('비밀번호가 틀립니다.');
            $("#txt_passwordMatch_support").css('color', 'red');
            $('#user_password2').val('');
        }
    }
}

