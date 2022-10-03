alert("欢迎来到车银优演绎介绍门户站")
/* var btn = document.getElementById('time');
var div = document.getElementById('show');
window.onload = function () {
    div.innerText = getDate();
}
function getDate() {
    var date = new Date();
    var year = date.getFullYear();
    var month = date.getMonth() + 1;
    var dates = date.getDate();
    var arr = ['星期天', '星期一', '星期二', '星期三', '星期四', '星期五', '星期六'];
    var day = date.getDay();
    return '今天是：' + year + '年' + month + '月' + dates + '日' + arr[day]
}
 */
function time() {
    var vWeek, vWeek_s, vDay;
    vWeek = ["星期天", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"];
    var date =  new Date();
    /* year = date.getFullYear();
    month = date.getMonth() + 1;
    day = date.getDate(); */
    hours = date.getHours();
    minutes = date.getMinutes();
    seconds = date.getSeconds();
    vWeek_s = date.getDay();
    document.getElementById("time").innerHTML =  hours + ":" + minutes + ":" + seconds + "\t" + vWeek[vWeek_s];

};
setInterval("time()", 1000);

