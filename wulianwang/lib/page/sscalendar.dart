import 'package:bruno/bruno.dart';
import 'package:flutter/material.dart';
import 'package:wulianwang/page/BrokenLine.dart';

import '../network/bike.dart';
import 'Chart.dart';

class ssscalendar extends StatefulWidget {
  int ID;

   ssscalendar({Key? key,required this.ID}) : super(key: key);

  @override
  State<ssscalendar> createState() => _ssscalendarState();
}



showChart(BuildContext context, String time, int ID, String showValue) {
  getBikeInfoByDate(time, ID).then((value) {
    List<AxisItem> Xlist = [];
    List<AxisItem> Ylist = [];
    List<BrnProgressBarItem> chartDataList = [];
    // for (int i = -20; i < 101; i++) {
    //   Xlist.add(AxisItem(showText: (i.toString())));
    // }
    for(int i=0;i<10;i++) {
      if(i==10){
        break;
      }
      chartDataList.add(
            BrnProgressBarItem(
              value: double.parse(value[i][showValue]),
              text: (value[i][showValue].toString()),
            ));
        Ylist.add(AxisItem(showText: ((value[i]["date"] + " " + value[i]["time"]))));
      // Xlist.add(AxisItem(showText: (double.parse(value[i][showValue])).toString()));
    }
    // value.forEach((e) {
    //   chartDataList.add(
    //     BrnProgressBarItem(
    //       value: double.parse(e[showValue]),
    //       text: (e[showValue].toString()),
    //     ),
    //   );
    //   Ylist.add(AxisItem(showText: ((e["date"] + " " + e["time"]))));
    //   Xlist.add(AxisItem(showText: (double.parse(e[showValue])).toString()));
    // });
    Navigator.push(context, MaterialPageRoute(builder: (BuildContext ctx) {
      return chart(
        Ylist: Xlist,
        Xlist: Ylist,
        charDataList: chartDataList,
      );
    }));
  });
}

showChart2(BuildContext context, String time, int ID) {
  getssss(time, ID).then((value) {
    List<AxisItem> Xlist = [];
    List<AxisItem> Ylist = [];
    List<BrnProgressBarItem> chartDataList = [];
    // for (int i = -20; i < 101; i++) {
    //   Xlist.add(AxisItem(showText: (i.toString())));
    // }
    for(int i=0;i<10;i++) {
      if(i==10){
        break;
      }
      chartDataList.add(
          BrnProgressBarItem(
            value: double.parse(value[i]),
            text: (value[i]["bikeFeed"].toString()),
          ));
      Ylist.add(AxisItem(showText: ((value[i]["date"] + " " + value[i]["time"]))));
    //   // Xlist.add(AxisItem(showText: (double.parse(value[i][showValue])).toString()));
    }
    // value.forEach((e) {
    //   chartDataList.add(
    //     BrnProgressBarItem(
    //       value: double.parse(e[showValue]),
    //       text: (e[showValue].toString()),
    //     ),
    //   );
    //   Ylist.add(AxisItem(showText: ((e["date"] + " " + e["time"]))));
    //   Xlist.add(AxisItem(showText: (double.parse(e[showValue])).toString()));
    // });
    Navigator.push(context, MaterialPageRoute(builder: (BuildContext ctx) {
      return chart(
        Ylist: Xlist,
        Xlist: Ylist,
        charDataList: chartDataList,
      );
    }));
  });
}


showBrokenLine(BuildContext context, String time, int ID, String showValue){
  List<BrnPointData> dataList=[];
// dataList.add(BrnPointData(pointText:" ",y:2,lineTouchData: BrnLineTouchData(tipWindowSize: const Size(60,40))));
  getBikeInfoByDate(time, ID).then((value) {
    for(int i=0;i<value.length;i++) {
      if(i==10){
        break;
      }
      dataList.add(BrnPointData(
          pointText: " ",

          y: double.parse(value[i][showValue]),
          lineTouchData: BrnLineTouchData(tipWindowSize: const Size(60, 40),onTouch: (){
            return Container(child: Column(children: [
              Text(value[i]["time"]),
              Text(value[i][showValue])
            ],),);
          })));
    }

  });
  List<BrnPointsLine> lines=[
    BrnPointsLine(
      isShowPointText: true,
      isShowXDial: true,
      lineWidth: 3,
      pointRadius: 4,
      isShowPoint: true,
      isCurve: true,
      points: dataList,
      shaderColors: [Colors.green.withOpacity(0.3), Colors.green.withOpacity(0.01)],
      lineColor: Colors.green,
    )
  ];
  Navigator.push(context, MaterialPageRoute(builder: (BuildContext ctx) {
    return BrokenLine(line:  lines);
  }));
}



class _ssscalendarState extends State<ssscalendar> {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      localizationsDelegates:[BrnLocalizationDelegate.delegate,],
      home: Scaffold(
        appBar: BrnAppBar(
          brightness: Brightness.dark,
          automaticallyImplyLeading: false,
          backgroundColor: Colors.blue,
          title: "湖南科技学院一队",
        ),
        body:  BrnCalendarView(
          displayMode: DisplayMode.month,
          selectMode: SelectMode.single,
          showControllerBar: true,
          weekNames: const ['星期天','星期一', '星期二', '星期三', '星期四', '星期五', '星期六'],
          dateChange: (Date){

            showChart2(context, (Date.toString()), widget.ID);
            // showBrokenLine(context,(Date.toString()), widget.ID, widget.showValue);
          },
        ),
      ),
    );
  }
}
