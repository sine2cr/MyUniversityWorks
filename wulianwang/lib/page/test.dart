
import 'package:bruno/bruno.dart';
import 'package:flutter/material.dart';

class test extends StatefulWidget {
  const test({Key? key}) : super(key: key);

  @override
  State<test> createState() => _testState();
}

class _testState extends State<test> {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(home: Scaffold(body: Container(


      child: Column(children: [
      BrnInputText(
        onTextChange: (e){},
        onSubmit: (e){},
        textString: " 输入数值",

      )
    ],),)),);
  }
}
