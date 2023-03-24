import 'package:flutter/material.dart';

import '../network/bike.dart';
import 'detail.dart';

class bikeList extends StatefulWidget {
  List data = [];
  Map r = {};

  bikeList({Key? key, required this.data}) : super(key: key);

  @override
  State<bikeList> createState() => _bikeListState();
}

class _bikeListState extends State<bikeList> {
  @override
  Widget build(BuildContext context) {
    return ListView.builder(
        itemCount: widget.data.length,
        itemBuilder: (BuildContext ctx, int i) {
          var temp = widget.data[i];
          return GestureDetector(
            onTapDown: (q) {},
            onTap: () {
              getBikeInfoById(int.parse(widget.data[i]['bikeId']))
                  .then((value) {
                widget.r.addAll(value);
                print(value.values);
                Navigator.push(context,
                    MaterialPageRoute(builder: (BuildContext ctx) {
                  return detail(
                    ID: widget.data[i]['bikeId'],
                    data: widget.r,
                  );
                }));
              });
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
                    "饮水机ID:" + " " + widget.data[i]['bikeId'],
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
