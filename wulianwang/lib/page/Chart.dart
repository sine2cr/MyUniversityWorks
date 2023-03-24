import 'package:flutter/material.dart';
import 'package:bruno/bruno.dart';

class chart extends StatefulWidget {
  List<AxisItem> Xlist;
  List<AxisItem> Ylist;
  List<BrnProgressBarItem> charDataList;

  chart(
      {Key? key,
      required this.Xlist,
      required this.Ylist,
      required this.charDataList})
      : super(key: key);

  @override
  State<chart> createState() => _chartState();
}

class _chartState extends State<chart> {
  @override
  void initState() {}

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: BrnAppBar(
        brightness: Brightness.dark,
        automaticallyImplyLeading: false,
        backgroundColor: Colors.blue,
        title: "湖南科技学院一队",
      ),
      body: BrnProgressBarChart(
        //x 轴文本
        xAxis: ChartAxis(axisItemList: widget.Xlist),
        //数据
        barBundleList: [BrnProgressBarBundle(barList: widget.charDataList)],
        //y轴文本
        yAxis: ChartAxis(axisItemList: widget.Ylist),
        //barGroupSpace: 138,
        barGroupSpace: 38,
      ),
    );
  }
}
