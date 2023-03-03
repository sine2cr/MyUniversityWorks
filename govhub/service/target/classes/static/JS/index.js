$("#submit").click(function (result) {
    $.ajax({
        url: "/citys/getByDate",
        type: "GET",
        dataType: "JSON",
        contentType: "application/x-www-form-urlencoded",
        data: "",
        headers: {
            "city": $("#selectCity").val(),
            "time": $("#datetable").val()
        },
        success: function (data) {
            let titles = new Array();
            let urls = new Array();
            for (let i = 0; i < data.length; i++) {
                titles.push(data[i].title);
                urls.push(data[i].url);
            }
            $("#box2").empty();
            $("#box2").append("<h3>显示数据</h3>")
            showData(titles, urls, "box2")
        }
    })
})

function showData(titles, urls, box) {

    for (let i = 0; i < titles.length; i++) {
        let element = $("<a></a>").text(titles[i]).attr("href", urls[i]);
        let a = $("<p></p>").append(element);
        $("#" + box).append(a)
    }
}

function getByTimeQuantum(q, box) {
    $.ajax({
        url: "/citys/getByTimeQuantum",
        type: "GET",
        dataType: "JSON",
        contentType: "application/x-www-form-urlencoded",
        data: "",
        headers: {
            "city": $("#selectCity").val(),
            "startTime": getnowtime(3),
            "endTime": getnowtime()
        },
        success: function (data) {
            let titles = new Array();
            let urls = new Array();
            for (let i = 0; i < data.length; i++) {
                titles.push(data[i].title);
                urls.push(data[i].url);
            }
            $("#box3").empty();
            $("#box3").append("<h3>最近三日</h3>")
            showData(titles, urls, box)
        }
    })
}

function getnowtime(lt) {
    if (lt == null) {
        lt = 0
    }
    let n;
    let c;
//获取当前时间
    let d = new Date();
    //包装年月日的格式
    let a = d.getFullYear() + "-";
    //月是从零开始的所以得加1，并且判断月份是否大于等于10月，如果大于十月得个前面加零来跟格式匹配
    if (d.getMonth() + 1 >= 10) {
        c = (d.getMonth() + 1) + "-";
    } else {
        c = "0" + (d.getMonth() + 1) + '-';
    }
    //不能使用getDay()方法得原因是因为他获取的是今天星期几，只有7天
    if (d.getDate() >= 10) {
        n = d.getDate();
    } else {
        n = "0" + d.getDate();
    }
    if (n - lt > 0) {
        return a + c + (n - lt);
    } else if (n - lt < 0 && c - 1 <= 0) {
        return a - 1 + 12 + (31 + n - lt)
    } else {
        return a + c + n
    }
}


getByTimeQuantum(3, "box3")

