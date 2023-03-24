import 'package:flutter/material.dart';

import '../network/bike.dart';

import '../page/sscalendar.dart';
import 'detail.dart';

class sbikeList extends StatefulWidget {
  List data = [];
  Map r = {};

  sbikeList({Key? key, required this.data}) : super(key: key);

  @override
  State<sbikeList> createState() => _sbikeListState();
}

class _sbikeListState extends State<sbikeList> {
  @override
  Widget build(BuildContext context) {
    return ListView.builder(
        itemCount: widget.data.length,
        itemBuilder: (BuildContext ctx, int i) {
          var temp = widget.data[i];
          return GestureDetector(
            onTapDown: (q) {},
            onTap: () {
              Navigator.push(context,
                  MaterialPageRoute(builder: (BuildContext ctx) {
                    return ssscalendar(
                      ID: widget.data[i],

                    );
                  }));
            },
            child: Container(
              margin: const EdgeInsets.all(10),
              padding: const EdgeInsets.all(10),
              decoration: BoxDecoration(
                border: Border.all(color: Colors.blue, width: 2.0),
                borderRadius: const BorderRadius.all(
                  //  Radius.circular(150),    //圆形
                  Radius.circular(10),
                ),
              ),
              child: Column(
                children: [
                  Text(
                    "学生ID:" + " " + widget.data[i]['bikeId'],
                    style: const TextStyle(
                      fontSize: 15,
                    ),
                    textAlign: TextAlign.left,
                    maxLines: 2,
                    overflow: TextOverflow.ellipsis,
                  ),
                  Text(
                    "时间:" + " " + widget.data[i]['time'],
                    style: const TextStyle(
                      fontSize: 15,
                    ),
                    textAlign: TextAlign.left,
                    maxLines: 2,
                    overflow: TextOverflow.ellipsis,
                  ),
                  Text(
                    "地点:" + " " + widget.data[i]['location'],
                    style: const TextStyle(
                      fontSize: 15,
                    ),
                    textAlign: TextAlign.left,
                    maxLines: 2,
                    overflow: TextOverflow.ellipsis,
                  ),
                ],
              ),
            ),
          );
        });
  }
}
