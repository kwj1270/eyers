$(document).ready(function(){
    let dataInputOk = false;
    $('#birth_year').focusout(function () {
        return dateDataCheck();
    });

    $('#birth_month').focusout(function () {
        return dateDataCheck();
    });

    $('#birth_day').focusout(function () {
        return dateDataCheck();
    });
})


function dataNoInputCheck(){
    $('#txt_birthdate_support').css('display','inline-block');
    if($('#birth_year').val() == null ||isNaN($('#birth_year').val()) || $('#birth_year').val() < 1 ){
        $('#txt_birthdate_support').text('년도 을 입력해주세요');
        $('#txt_birthdate_support').css('color', 'red');
        return false;
    } else if($('#birth_month').val() == null || isNaN($('#birth_month').val()) || $('#birth_month').val() < 1){
        $('#txt_birthdate_support').text('월 을 입력해주세요');
        $('#txt_birthdate_support').css('color', 'red');
        return false;
    }  else if($('#birth_day').val() == null ||isNaN($('#birth_day').val()) || $('#birth_day').val() < 1 ){
        $('#txt_birthdate_support').text('일 을 입력해주세요');
        $('#txt_birthdate_support').css('color', 'red');
        return false;
    }  
    return true;
}

/////////////////////// 공통도니 메소드이다. 
function jsDayCheck(format_date)
{
    let strValue = format_date;
    let chk1 =  /^(19|20)\d{2}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[0-1])$/;
    let chk2 = /^(19|20)\d{2}\/([0][1-9]|1[012])\/(0[1-9]|[12][0-9]|3[01])$/;
    //var chk2 = /^(19|20)\d{2}-([0][1-9]|1[012])-([012][1-9]|3[01])$/;
    if (strValue == "")
    { // 공백이면 무시
         return true;
    }

    //-------------------------------------------------------------------------------
    // 유효성 검사- 입력형식에 맞게 들왔는지 // 예) 2000-1-1, 2000-01-01 2가지 형태 지원
    //-------------------------------------------------------------------------------
    if (chk1.test(strValue) == false && chk2.test(strValue) == false)
    { // 유효성 검사에 둘다 성공하지 못했다면
        $('#txt_birthdate_support').text('유효하지 않은 날짜 또는 형식입니다. 다시한번 확인해주세요');
        $('#txt_birthdate_support').css('color', 'red');
        return false;
    }
    
    //-------------------------------------------------------------------------------
    // 존재하는 날자(유효한 날자) 인지 체크
    //-------------------------------------------------------------------------------
    let bDateCheck = true;
    let arrDate = format_date.split("-");
    let nYear = Number(arrDate[0]);
    let check_before_year = nYear-50;
    let check_after_year = nYear+50;
    let nMonth = Number(arrDate[1]);
    let nDay = Number(arrDate[2]);
    let focusDate = 0;

    if (nYear < check_before_year || nYear > check_after_year)
    { // 사용가능 하지 않은 년도 체크
        $('#birth_year').val('');
        focusDate += 4;
        bDateCheck = false;
    }

    if (nMonth < 1 || nMonth > 12)
    {   
        focusDate += 2;
        bDateCheck = false;
    }

    // 해당달의 마지막 일자 구하기
    let nMaxDay = new Date(new Date(nYear, nMonth, 1) - 86400000).getDate();
    if (nDay < 1 || nDay > nMaxDay)
    {   
        $('#birth_day').val('');
        focusDate += 1;
        bDateCheck = false;
    }

    if(focusDate > 3){
        $('#birth_year').focus();
    } else if (focusDate > 1){
        $('#birth_month').focus();
    } else if(focusDate > 0){
        $('#birth_day').focus();
    }

    if(bDateCheck == false) 
    { 
        $('#txt_birthdate_support').text('유효하지 않은 날짜 또는 형식입니다. 다시한번 확인해주세요');
        $('#txt_birthdate_support').css('color', 'red');
       return false;
    }
    $('#txt_birthdate_support').css('display','none');   
    $('#txt_birthdate_support').text('');
}

function dateCheck(){
    var format_date = "";
    format_date += $('#birth_year').val()+'-';
    format_date += $('#birth_month').val()+'-';
    format_date += $('#birth_day').val();
    jsDayCheck(format_date);
}

function dateDataCheck(){
    dataInputOk = dataNoInputCheck();
    if(dataInputOk){
        dataInputOk = dateCheck();
    }
    return dataInputOk;
}