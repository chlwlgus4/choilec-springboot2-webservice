/*$(function(){
    $(".zeta-menu li").hover(function(){
        $('ul:first',this).show();
    }, function(){
        $('ul:first',this).hide();
    });
    $(".zeta-menu>li:has(ul)>a").each( function() {
        $(this).html( $(this).html()+' &or;' );
    });
    $(".zeta-menu ul li:has(ul)")
        .find("a:first")
        .append("<p style='float:right;margin:-3px'>&#9656;</p>");
});*/
/******************************************************************************
 * 설명   : null 체크
 * 작성자  : 최지현
 * @param data 체크할 값
 * 작성일 : 2019-06-04
 ******************************************************************************/
function isNull(data){
    return (data == "" || data === null || data === undefined) ? true : false;
}

/******************************************************************************
 * 설명   : 쿠키 저장 삭제
 * 작성자  : 최지현
 * @param name 저장 할 쿠키 이름, value 값, expiredays 기간
 * 작성일 : 2019-09-08
 ******************************************************************************/
function setCookie(name, value, expiredays){
    var todayDate = new Date();
    todayDate.setDate (todayDate.getDate() + expiredays);
    cookieValue = escape(value) + "; path=/; expires=" + todayDate.toGMTString();
    document.cookie = name + "=" + cookieValue + ";";
}
function deleteCookie(name){
    var expireDate = new Date();
    expireDate.setDate(expireDate.getDate()-1);
    document.cookie = name + "= " + "; path=/; expires=" + expireDate.toGMTString();
}

function getCookie(name) {
    name = name + '=';
    var cookieData = document.cookie;
    var start = cookieData.indexOf(name);
    var cookieValue = '';
    if(start != -1){
        start += name.length;
        var end = cookieData.indexOf(';', start);
        if(end == -1)end = cookieData.length;
        cookieValue = cookieData.substring(start, end);
    }
    return unescape(cookieValue);
}
/******************************************************************************
 * 설명   : 이메일 정규식
 * 작성자  : 최지현
 * @param data 비교할 값
 * 작성일 : 2020-01-21
 ******************************************************************************/
function isEmail(data) {
    let regExp = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
    return regExp.test(data); // 형식에 맞는 경우 true 리턴
}

/******************************************************************************
 * 설명   : 비밀번호 정규식
 * 작성자  : 최지현
 * @param data 비교할 값
 * 작성일 : 2020-01-21
 ******************************************************************************/
function isPassword(data) {

    var regExp = /^(?=.*[a-zA-Z])(?=.*[^a-zA-Z0-9])(?=.*[0-9]).{8,16}$/; //  8 ~ 16자 영문, 숫자, 특수문자 조합
    return regExp.test(data); // 형식에 맞는 경우 true 리턴

}