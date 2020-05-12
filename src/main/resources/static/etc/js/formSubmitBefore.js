function inputHiddenUserDate(){
    let todayDate = new Date();
    let todayDateYear = todayDate.getFullYear();
    let birthYear = $('#birth_year').val();
    let age = todayDateYear-birthYear;
    let fulldate = "";
    fulldate += $('#birth_year').val();
    fulldate += $('#birth_month').val();
    fulldate += $('#birth_day').val();
    $('#user_age').val(age);
    $('#user_birth').val(fulldate);
}

function inputHiddenUserPhone(){
    let fullPhoneNum = "";
    fullPhoneNum += $('#phone_first').val()
    fullPhoneNum += $('#phone_middle').val()
    fullPhoneNum += $('#phone_last').val()
    $('#user_phone').val(fullPhoneNum);
}
$('#join_form').submit(function(){
    inputHiddenUserDate();
    inputHiddenUserPhone();
})
