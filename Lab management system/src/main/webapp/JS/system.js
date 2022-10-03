function getTime() {
    let now = new Date();
    let month = (10 > (now.getMonth() + 1)) ? '0' + (now.getMonth() + 1) : now.getMonth() + 1;
    let day = (10 > now.getDate()) ? '0' + now.getDate() : now.getDate();
    let hour = (10 > now.getHours()) ? '0' + now.getHours() : now.getHours();
    let minute = (10 > now.getMinutes()) ? '0' + now.getMinutes() : now.getMinutes();
//   var second = ( 10 > now.getSeconds() ) ? '0' + now.getSeconds() : now.getSeconds();
    let today = now.getFullYear() + '-' + month + '-' + day;
    let todayTime = hour + ':' + minute;
    let time = today + " " + todayTime;
    return time;
}

$("#selectTime").click(function () {
    let startTime = $("#getStartTime").val();
    let endTime = $("#getEndtime").val();
    let url="/select?startTime=" + startTime + "&endTime=" + endTime;
    $.ajax({
        url: url,
        type: "post",
        success: function (result) {
            $("#download").text("下载文件");
            $("#download").attr("href",url);


            // let myurl="/select?startTime=" + startTime + "&endTime=" + endTime;
            // let request = new XMLHttpRequest();
            // request.open("get", "/select?startTime=" + startTime + "&endTime=" + endTime);
            // request.responseType = "blob";
            // request.send();
            // request.onload = function () {
            //
                // let response = request.response;
                // let fileurl = URL.createObjectURL(response);
                // console.log(fileurl);
                // const elementA = document.createElement("a")
                // elementA.setAttribute("href",myurl);
                // elementA.innerText="下载";
                // elementA.setAttribute("download","");
                // document.body.appendChild(elementA);
                // console.log(12313132121)

            //}
        }
    })
})
$("#download").click(function () {
    let startTime = $("#getStartTime").val();
    let endTime = $("#getEndtime").val();
    let url="/select?startTime=" + startTime + "&endTime=" + endTime;

    $("#download").attr("href",url);

    $.ajax({
        url: url,
        type: "post",
        success: function (result) {


            // let myurl="/select?startTime=" + startTime + "&endTime=" + endTime;
            // let request = new XMLHttpRequest();
            // request.open("get", "/select?startTime=" + startTime + "&endTime=" + endTime);
            // request.responseType = "blob";
            // request.send();
            // request.onload = function () {
            //
                // let response = request.response;
                // let fileurl = URL.createObjectURL(response);
                // console.log(fileurl);
                // const elementA = document.createElement("a")
                // elementA.setAttribute("href",myurl);
                // elementA.innerText="下载";
                // elementA.setAttribute("download","");
                // document.body.appendChild(elementA);
                // console.log(12313132121)

            //}
        }
    })
})

$("#signIN").click(function () {
    let time = getTime();
    $("#setStartTime").text(time);
})
$("#signOUT").click(function () {
    let time = getTime();
    $("#setEndtime").text(time);
})
$("#submit").click(function () {
    $.ajax({
        url: "/add?startTime=" + $("#setStartTime").text() + "&endTime=" + $("#setEndtime").text(),
        type: "POST",
        success: function (result) {
            alert(result);
        }
    })
})