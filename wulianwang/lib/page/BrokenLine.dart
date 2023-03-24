import 'package:flutter/cupertino.dart';
import 'package:bruno/bruno.dart';
import 'package:flutter/material.dart';

class BrokenLine extends StatefulWidget {
  List<BrnPointsLine> line;

  BrokenLine({Key? key,
    required this.line,
    }) : super(key: key);

  @override
  State<BrokenLine> createState() => _BrokenLineState();
}
// double _getMinValueForDemo1(List<DBDataNodeModel> brokenData) {
//   double minValue = double.tryParse(brokenData[0]?.value) ?? 0;
//   for (DBDataNodeModel point in brokenData) {
//     minValue = min(double.tryParse(point.value) ?? 0, minValue);
//   }
//   return minValue;
// }
//
// double _getMaxValueForDemo1(List<DBDataNodeModel> brokenData) {
//   double maxValue = double.tryParse(brokenData[0]?.value) ?? 0;
//   for (DBDataNodeModel point in brokenData) {
//     maxValue = max(double.tryParse(point.value) ?? 0, maxValue);
//   }
//   return maxValue;
// }

// List<BrnDialItem> _getXDialValuesForDemo1(List<DBDataNodeModel> brokenData) {
//   List<BrnDialItem> _xDialValue = [];
//   for (int index = 0; index < brokenData.length; index++) {
//     _xDialValue.add(BrnDialItem(
//       dialText: brokenData[index].name,
//       dialTextStyle: TextStyle(fontSize: 12.0, color: Color(0xFF999999)),
//       value: index.toDouble(),
//     ));
//   }
//   return _xDialValue;
// }
class _BrokenLineState extends State<BrokenLine> {
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
          body: Container(
            child: Column(
              children: <Widget>[
                const SizedBox(
                  height: 20,
                ),
                BrnBrokenLine(
                  size: Size(MediaQuery.of(context).size.width * 1 - 100 * 1,
                      MediaQuery.of(context).size.height / 5 * 1.6 - 20 * 1),

                  lines: widget.line,
                  xDialMin: 0,
                  xDialMax: 100,
                  yDialMax: 100,
                  yDialMin: 0,
                  isHintLineSolid: false,
                  isShowYDialText: true,
                )
              ],
              crossAxisAlignment: CrossAxisAlignment.start,
            ),
          ),
      ),
    );
  }
}
