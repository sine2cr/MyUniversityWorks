import 'package:flutter/material.dart';
import 'package:wulianwang/network/bike.dart';
import 'package:dio/dio.dart';

import 'package:bruno/bruno.dart';
import 'package:wulianwang/widget/list.dart';

class myApp extends StatefulWidget {
  const myApp({Key? key}) : super(key: key);

  @override
  State<myApp> createState() => _myAppState();
}

class _myAppState extends State<myApp> {
  List data = [];

  @override
  void initState() {
    getBikeInfo().then((value) {
      data = value;
    });
    // getBikeInfoById(100000000001).then((value) => print("===============$value"));
    // getBikeInfoByDate("2022-10-0510:59:41").then((value) => print("===========$value"));
    // Map<String, dynamic> json={"bikeId":"100000000001"};
    // updateBikeInfoById(100000000001, json).then((value) => print("===================================$value"));
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      localizationsDelegates:[BrnLocalizationDelegate.delegate],
      home: Scaffold(
        appBar: BrnAppBar(
          brightness: Brightness.dark,
          automaticallyImplyLeading: false,
          backgroundColor: Colors.blue,
          title: "湖南科技学院一队",
        ),
        body: bikeList(data: data),
      ),
    );
  }
}
