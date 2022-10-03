

import 'package:flutter/material.dart';

class listContext extends StatelessWidget {
  List<dynamic> list = [];

  listContext({Key? key, required this.list}) : super(key: key);

  List<Widget> _getData() {
    List<Widget> data = [];
    for (int i = 0; i < list.length; i++) {
      data.add(ListTile(
        title: Text(list[i].title),
      ));
    }
    return data;
  }

  @override
  Widget build(BuildContext context) {
    return Container(
      child: ListView(
        children: _getData(),
      ),
    );
  }
}
