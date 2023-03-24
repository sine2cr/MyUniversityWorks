import 'dart:async';

import 'package:flutter/material.dart';
import 'package:bruno/bruno.dart';

import 'package:wulianwang/network/bike.dart';
import 'package:wulianwang/page/Chart.dart';
import 'package:wulianwang/page/calendar.dart';
import 'package:wulianwang/page/sscalendar.dart';
import 'package:wulianwang/widget/slist.dart';

class detail extends StatefulWidget {
  String ID;
  Map data;

  detail({Key? key, required this.ID, required this.data}) : super(key: key);

  @override
  State<detail> createState() => _detailState();
}
//
// showChart(BuildContext context, String time, int ID, String showValue) {
//   getBikeInfoByDate(time, ID).then((value) {
//     List<AxisItem> Xlist = [];
//     List<AxisItem> Ylist = [];
//     List<BrnProgressBarItem> chartDataList = [];
//     // for (int i = -20; i < 101; i++) {
//     //   Xlist.add(AxisItem(showText: (i.toString())));
//     // }
//     value.forEach((e) {
//       chartDataList.add(
//         BrnProgressBarItem(
//           value: double.parse(e[showValue]),
//           text: (e[showValue].toString()),
//         ),
//       );
//       Ylist.add(AxisItem(showText: ((e["date"] + " " + e["time"]))));
//       // Xlist.add(AxisItem(showText: (double.parse(e[showValue])).toString()));
//     });
//     Navigator.push(context, MaterialPageRoute(builder: (BuildContext ctx) {
//       return chart(
//         Ylist: Xlist,
//         Xlist: Ylist,
//         charDataList: chartDataList,
//       );
//     }));
//   });
// }

class _detailState extends State<detail> {
  StringToInt() {
    widget.data['bikeLock'] = int.parse(widget.data['bikeLock']);
    widget.data['bikeMotorLock'] = int.parse(widget.data['bikeMotorLock']);
    widget.data['bikeLedLeft'] = int.parse(widget.data['bikeLedLeft']);
    widget.data['bikeLedRight'] = int.parse(widget.data['bikeLedRight']);
    widget.data['bikeLedLight'] = int.parse(widget.data['bikeLedLight']);
    widget.data['bikeFeed'] = int.parse(widget.data['bikeFeed']);
  }

  @override
  void initState() {
    StringToInt();
    flash();
  }

  late Timer _timer;

  flash() {
    _timer = Timer.periodic(const Duration(seconds: 5), (timer) {
      print("定时器运行中");
      getBikeInfoById(int.parse(widget.ID)).then((value) {
        setState(() {
          widget.data = value;
          StringToInt();
        });
      });
    });
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: Scaffold(
        appBar: BrnAppBar(
          brightness: Brightness.dark,
          automaticallyImplyLeading: false,
          backgroundColor: Colors.blue,
          title: "湖南科技学院一队",
        ),
        body: GestureDetector(
          child: Container(
            width: MediaQuery.of(context).size.width,
            decoration: BoxDecoration(
              color: Colors.white10,
              border: Border.all(color: Colors.blue, width: 2.0),
              borderRadius: const BorderRadius.all(
                //  Radius.circular(150),    //圆形
                Radius.circular(10),
              ),
            ),
            child: Column(
              children: [
                Row(
                  mainAxisAlignment: MainAxisAlignment.spaceBetween,
                  children: [
                    Text(
                      "饮水机ID:" + "    " + widget.data["bikeId"],
                      style: const TextStyle(
                        fontSize: 15,
                      ),
                      textAlign: TextAlign.left,
                      maxLines: 2,
                      overflow: TextOverflow.ellipsis,
                    )
                  ],
                ),
                Row(
                  mainAxisAlignment: MainAxisAlignment.spaceBetween,
                  children: [
                    Text(
                      "饮水机是否故障:" +"   "+  (widget.data['code'].toString()=="0"? "正常":"故障"),
                      style: const TextStyle(
                        fontSize: 15,
                      ),
                      textAlign: TextAlign.left,
                      maxLines: 2,
                      overflow: TextOverflow.ellipsis,
                    )
                  ],
                ),
                Row(
                  mainAxisAlignment: MainAxisAlignment.spaceBetween,
                  children: [
                    Text(
                      "饮水机是否报警:"+"   "+(widget.data['code1'].toString()=="0"? "正常":"报警"),
                      style: const TextStyle(
                        fontSize: 15,
                      ),
                      textAlign: TextAlign.left,
                      maxLines: 2,
                      overflow: TextOverflow.ellipsis,
                    )
                  ],
                ),
                Row(
                  mainAxisAlignment: MainAxisAlignment.spaceBetween,
                  children: [
                     Text(
                      "饮水机状态:" + "   " + (widget.data['bikeLock'].toString()=="0"? "关闭":"开启"),
                      style: TextStyle(
                        fontSize: 15,
                      ),
                      textAlign: TextAlign.left,
                      maxLines: 2,
                      overflow: TextOverflow.ellipsis,
                    ),

                    Switch(
                        value: widget.data['bikeLock'] == 0 ? false : true,
                        onChanged: (value) {
                          setState(() {
                            widget.data['bikeLock'] = (value == false ? 0 : 1);
                          });
                          Map<String, dynamic> json = {"bikeId": widget.ID};
                          // Map<String,dynamic> json = Map.from({'bikeFeed':widget.data['bikeFeed']})  ;
                          json.addAll({'bikeLock': widget.data['bikeLock']});
                          updateBikeInfoById(int.parse(widget.ID), json)
                              .then((value) => print(value.toString()));
                        }),
                  ],
                ),
                // Row(
                //   mainAxisAlignment: MainAxisAlignment.spaceBetween,
                //   children: [
                //     const Text(
                //       "饮水机位置:" + " ",
                //       style: TextStyle(
                //         fontSize: 15,
                //       ),
                //       textAlign: TextAlign.left,
                //       maxLines: 2,
                //       overflow: TextOverflow.ellipsis,
                //     ),
                //     Switch(
                //         value: widget.data['bikeMotorLock'] == 0 ? false : true,
                //         onChanged: (value) {
                //           setState(() {
                //             widget.data['bikeMotorLock'] =
                //                 (value == false ? 0 : 1);
                //           });
                //           Map<String, dynamic> json = {"bikeId": widget.ID};
                //           // Map<String,dynamic> json = Map.from({'bikeFeed':widget.data['bikeFeed']})  ;
                //           json.addAll(
                //               {'bikeMotorLock': widget.data['bikeMotorLock']});
                //           updateBikeInfoById(int.parse(widget.ID), json)
                //               .then((value) => print(value.toString()));
                //         }),
                //   ],
                // ),
                Row(
                  mainAxisAlignment: MainAxisAlignment.spaceBetween,
                  children: [
                    Text(
                      "饮水机水质:" + "   " + widget.data['batteryV2'],
                      style: const TextStyle(
                        fontSize: 15,
                      ),
                      textAlign: TextAlign.left,
                      maxLines: 2,
                      overflow: TextOverflow.ellipsis,
                    ),
                    // BrnSmallMainButton(
                    //   title: "选择查询历史信息时间",
                    //   bgColor: Colors.blue,
                    //   radius: 10,
                    //   onTap: () {
                    //     Navigator.push(context,
                    //         MaterialPageRoute(builder: (BuildContext ctx) {
                    //       return calendar(
                    //           showValue: 'bikeMotor', ID: int.parse(widget.ID));
                    //     }));
                    //   },
                    // )
                  ],
                ),
                Row(
                  mainAxisAlignment: MainAxisAlignment.spaceBetween,
                  children: [
                    Text(
                      "饮水机位置:" + "   " + widget.data['location'],
                      style: const TextStyle(
                        fontSize: 15,
                      ),
                      textAlign: TextAlign.left,
                      maxLines: 2,
                      overflow: TextOverflow.ellipsis,
                    ),
                    // BrnSmallMainButton(
                    //   title: "选择查询历史信息时间",
                    //   bgColor: Colors.blue,
                    //   radius: 10,
                    //   onTap: () {
                    //     Navigator.push(context,
                    //         MaterialPageRoute(builder: (BuildContext ctx) {
                    //       return calendar(
                    //           showValue: 'bikeMotorSpeed',
                    //           ID: int.parse(widget.ID));
                    //     }));
                    //   },
                    // ),
                  ],
                ),
                // Row(
                //   mainAxisAlignment: MainAxisAlignment.spaceBetween,
                //   children: [
                //     const Text(
                //       "左转向灯状态:" + " ",
                //       style: TextStyle(
                //         fontSize: 15,
                //       ),
                //       textAlign: TextAlign.left,
                //       maxLines: 2,
                //       overflow: TextOverflow.ellipsis,
                //     ),
                //     Switch(
                //         value: widget.data['bikeLedLeft'] == 0 ? false : true,
                //         onChanged: (value) {
                //           setState(() {
                //             widget.data['bikeLedLeft'] =
                //                 (value == false ? 0 : 1);
                //           });
                //           Map<String, dynamic> json = {"bikeId": widget.ID};
                //           // Map<String,dynamic> json = Map.from({'bikeFeed':widget.data['bikeFeed']})  ;
                //           json.addAll(
                //               {'bikeLedLeft': widget.data['bikeLedLeft']});
                //           updateBikeInfoById(int.parse(widget.ID), json)
                //               .then((value) => print(value.toString()));
                //         }),
                //   ],
                // ),
                // Row(
                //   mainAxisAlignment: MainAxisAlignment.spaceBetween,
                //   children: [
                //     const Text(
                //       "右转向灯状态:" + " ",
                //       style: TextStyle(
                //         fontSize: 15,
                //       ),
                //       textAlign: TextAlign.left,
                //       maxLines: 2,
                //       overflow: TextOverflow.ellipsis,
                //     ),
                //     Switch(
                //         value: widget.data['bikeLedRight'] == 0 ? false : true,
                //         onChanged: (value) {
                //           setState(() {
                //             widget.data['bikeLedRight'] =
                //                 (value == false ? 0 : 1);
                //           });
                //           Map<String, dynamic> json = {"bikeId": widget.ID};
                //           // Map<String,dynamic> json = Map.from({'bikeFeed':widget.data['bikeFeed']})  ;
                //           json.addAll(
                //               {'bikeLedRight': widget.data['bikeLedRight']});
                //           updateBikeInfoById(int.parse(widget.ID), json)
                //               .then((value) => print(value.toString()));
                //         }),
                //   ],
                // ),
                // Row(
                //   mainAxisAlignment: MainAxisAlignment.spaceBetween,
                //   children: [
                //     const Text(
                //       "照明灯状态:" + " ",
                //       style: TextStyle(
                //         fontSize: 15,
                //       ),
                //       textAlign: TextAlign.left,
                //       maxLines: 2,
                //       overflow: TextOverflow.ellipsis,
                //     ),
                //     Switch(
                //         value: widget.data['bikeLedLight'] == 0 ? false : true,
                //         onChanged: (value) {
                //           setState(() {
                //             widget.data['bikeLedLight'] =
                //                 (value == false ? 0 : 1);
                //           });
                //           Map<String, dynamic> json = {"bikeId": widget.ID};
                //           // Map<String,dynamic> json = Map.from({'bikeFeed':widget.data['bikeFeed']})  ;
                //           json.addAll(
                //               {'bikeLedLight': widget.data['bikeLedLight']});
                //           updateBikeInfoById(int.parse(widget.ID), json)
                //               .then((value) => print(value.toString()));
                //         }),
                //   ],
                // ),
                // Row(
                //   mainAxisAlignment: MainAxisAlignment.spaceBetween,
                //   children: [
                //     Text(
                //       "照明灯阈值:" + "    " + widget.data['bikeLedLightValue'],
                //       style: const TextStyle(
                //         fontSize: 15,
                //       ),
                //       textAlign: TextAlign.left,
                //       maxLines: 2,
                //       overflow: TextOverflow.ellipsis,
                //     )
                //   ],
                // ),
                // Row(
                //   mainAxisAlignment: MainAxisAlignment.spaceBetween,
                //   children: [
                //     const Text(
                //       "喇叭状态:" + " ",
                //       style: TextStyle(
                //         fontSize: 15,
                //       ),
                //       textAlign: TextAlign.left,
                //       maxLines: 2,
                //       overflow: TextOverflow.ellipsis,
                //     ),
                //     Switch(
                //         value: widget.data['bikeFeed'] == 0 ? false : true,
                //         onChanged: (value) {
                //           setState(() {
                //             widget.data['bikeFeed'] = (value == false ? 0 : 1);
                //           });
                //           Map<String, dynamic> json = {"bikeId": widget.ID};
                //           // Map<String,dynamic> json = Map.from({'bikeFeed':widget.data['bikeFeed']})  ;
                //           json.addAll({'bikeFeed': widget.data['bikeFeed']});
                //           updateBikeInfoById(int.parse(widget.ID), json)
                //               .then((value) => print(value.toString()));
                //         }),
                //   ],
                // ),
                Row(
                  mainAxisAlignment: MainAxisAlignment.spaceBetween,
                  children: [
                    const Text(
                      "查学生1:" ,
                      style: TextStyle(
                        fontSize: 15,
                      ),
                      textAlign: TextAlign.left,
                      maxLines: 2,
                      overflow: TextOverflow.ellipsis,
                    ),
                    BrnSmallMainButton(
                      title: "选择学生饮水信息",
                      bgColor: Colors.blue,
                      radius: 10,
                      onTap: () {
                        Navigator.push(context,
                            MaterialPageRoute(builder: (BuildContext ctx) {
                              return ssscalendar(ID: 3144142148);
                            }));
                      },
                    ),
                  ],
                ),
                Row(
                  mainAxisAlignment: MainAxisAlignment.spaceBetween,
                  children: [
                    const Text(
                      "查学生2:" ,
                      style: TextStyle(
                        fontSize: 15,
                      ),
                      textAlign: TextAlign.left,
                      maxLines: 2,
                      overflow: TextOverflow.ellipsis,
                    ),
                    BrnSmallMainButton(
                      title: "选择学生饮水信息",
                      bgColor: Colors.blue,
                      radius: 10,
                      onTap: () {
                        Navigator.push(context,
                            MaterialPageRoute(builder: (BuildContext ctx) {
                              return ssscalendar(ID: 3144142148);
                            }));
                      },
                    ),
                  ],
                ),
                Row(
                  mainAxisAlignment: MainAxisAlignment.spaceBetween,
                  children: [
                    Text(
                      "饮水机饮水总量:" + "   " + widget.data['bikeMotorSpeed'].toString(),
                      style: const TextStyle(
                        fontSize: 15,
                      ),
                      textAlign: TextAlign.left,
                      maxLines: 2,
                      overflow: TextOverflow.ellipsis,
                    ),
                    BrnSmallMainButton(
                      title: "选择查询历史信息时间",
                      bgColor: Colors.blue,
                      radius: 10,
                      onTap: () {
                        Navigator.push(context,
                            MaterialPageRoute(builder: (BuildContext ctx) {
                          return calendar(
                              showValue: 'bikeMotorSpeed', ID: int.parse(widget.ID));
                        }));
                      },
                    ),
                  ],
                ),
                // Row(
                //   mainAxisAlignment: MainAxisAlignment.spaceBetween,
                //   children: [
                //     Text(
                //       "电池电压V2:" + "   " + widget.data['batteryV2'],
                //       style: const TextStyle(
                //         fontSize: 15,
                //       ),
                //       textAlign: TextAlign.left,
                //       maxLines: 2,
                //       overflow: TextOverflow.ellipsis,
                //     ),
                //     BrnSmallMainButton(
                //       title: "选择查询历史信息时间",
                //       bgColor: Colors.blue,
                //       radius: 10,
                //       onTap: () {
                //         Navigator.push(context,
                //             MaterialPageRoute(builder: (BuildContext ctx) {
                //           return calendar(
                //               showValue: 'batteryV2', ID: int.parse(widget.ID));
                //         }));
                //       },
                //     )
                //   ],
                // ),
                // Row(
                //   mainAxisAlignment: MainAxisAlignment.spaceBetween,
                //   children: [
                //     Text(
                //       "电池温度T1:" + "   " + widget.data['batteryT1'],
                //       style: const TextStyle(
                //         fontSize: 15,
                //       ),
                //       textAlign: TextAlign.left,
                //       maxLines: 2,
                //       overflow: TextOverflow.ellipsis,
                //     ),
                //     BrnSmallMainButton(
                //       title: "选择查询历史信息时间",
                //       bgColor: Colors.blue,
                //       radius: 10,
                //       onTap: () {
                //         Navigator.push(context,
                //             MaterialPageRoute(builder: (BuildContext ctx) {
                //           return calendar(
                //               showValue: 'batteryT1', ID: int.parse(widget.ID));
                //         }));
                //       },
                //     )
                //   ],
                // ),
                // Row(
                //   mainAxisAlignment: MainAxisAlignment.spaceBetween,
                //   children: [
                //     Text(
                //       "电池温度T2:" + "   " + widget.data['batteryT2'],
                //       style: const TextStyle(
                //         fontSize: 15,
                //       ),
                //       textAlign: TextAlign.left,
                //       maxLines: 2,
                //       overflow: TextOverflow.ellipsis,
                //     ),
                //     BrnSmallMainButton(
                //       title: "选择查询历史信息时间",
                //       bgColor: Colors.blue,
                //       radius: 10,
                //       onTap: () {
                //         Navigator.push(context,
                //             MaterialPageRoute(builder: (BuildContext ctx) {
                //           return calendar(
                //               showValue: 'batteryT2', ID: int.parse(widget.ID));
                //         }));
                //       },
                //     )
                //   ],
                // ),
                // Row(
                //   mainAxisAlignment: MainAxisAlignment.spaceBetween,
                //   children: [
                //     Text(
                //       "充放电电流:" + "    " + widget.data['batteryI'],
                //       style: const TextStyle(
                //         fontSize: 15,
                //       ),
                //       textAlign: TextAlign.left,
                //       maxLines: 2,
                //       overflow: TextOverflow.ellipsis,
                //     ),
                //     BrnSmallMainButton(
                //       title: "选择查询历史信息时间",
                //       bgColor: Colors.blue,
                //       radius: 10,
                //       onTap: () {
                //         Navigator.push(context,
                //             MaterialPageRoute(builder: (BuildContext ctx) {
                //           return calendar(
                //               showValue: 'batteryI', ID: int.parse(widget.ID));
                //         }));
                //       },
                //     )
                //   ],
                // ),
                // Row(
                //   mainAxisAlignment: MainAxisAlignment.spaceBetween,
                //   children: [
                //     Text(
                //       "电池工作温升:" + "   " + widget.data['batteryT'],
                //       style: const TextStyle(
                //         fontSize: 15,
                //       ),
                //       textAlign: TextAlign.left,
                //       maxLines: 2,
                //       overflow: TextOverflow.ellipsis,
                //     ),
                //
                //     BrnSmallMainButton(
                //       title: "选择查询历史信息时间",
                //       bgColor: Colors.blue,
                //       radius: 10,
                //       onTap: () {
                //         Navigator.push(context,
                //             MaterialPageRoute(builder: (BuildContext ctx) {
                //           return calendar(
                //               showValue: 'batteryT', ID: int.parse(widget.ID));
                //         }));
                //       },
                //     )
                //   ],
                // ),
                Row(
                  mainAxisAlignment: MainAxisAlignment.spaceBetween,
                  children: [
                    Text(
                      "修改日期:" + "   " + widget.data['date'],
                      style: const TextStyle(
                        fontSize: 15,
                      ),
                      textAlign: TextAlign.left,
                      maxLines: 2,
                      overflow: TextOverflow.ellipsis,
                    )
                  ],
                ),
                Row(
                  mainAxisAlignment: MainAxisAlignment.spaceBetween,
                  children: [
                    Text(
                      "修改时间:" + "   " + widget.data['time'],
                      style: const TextStyle(
                        fontSize: 15,
                      ),
                      textAlign: TextAlign.left,
                      maxLines: 2,
                      overflow: TextOverflow.ellipsis,
                    )
                  ],
                )
              ],
            ),
          ),
        ),
      ),
    );
  }

  @override
  void dispose() {
    super.dispose();
    _timer.cancel();
  }
}
