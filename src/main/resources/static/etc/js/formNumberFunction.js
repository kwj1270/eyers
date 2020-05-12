function CheckForm(){
    let phone_first = document.getElementById("phone_first")
    let phone_middle = document.getElementById("phone_middle")
    let phone_last = document.getElementById("phone_last")

    if(phone_first.value==""){
        window.alert("처음 휴대폰 번호를 선택하시오.");
        return false;
    }
    if(phone_middle.value.length <3 || phone_middle.value.length>4 ){ //3자리 또는 4자리가 아니면 
        window.alert("가운데 자리 번호는 3~4자리로 입력하시오.");
        phone_middle.value="";//입력된값을 지움.
        phone_middle.focus(); //마지막 번호로 포커스 이동.
        return false;
    }

    if(phone_last.value.length != 4){
        window.alert("마지막 자리 번호는 4자리로 입력하시오.");
        phone_last.value="";//입력된값을 지움.
        phone_last.focus(); //마지막 번호로 포커스 이동.
        return false;
    }
}
function onlyNumber() {
    if ((event.keyCode < 48) || (event.keyCode > 57))
        event.returnValue = false;
}