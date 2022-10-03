import 'package:flutter/material.dart';

class underWidget extends StatefulWidget {
  const underWidget({Key? key}) : super(key: key);

  @override
  State<underWidget> createState() => _underWidgetState();
}

class _underWidgetState extends State<underWidget> {
  final _BottomNavigationColor = Colors.blue;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        bottomNavigationBar: BottomNavigationBar(items: [
      BottomNavigationBarItem(
        icon: Icon(
          Icons.home,
          color: _BottomNavigationColor,
        ),
        label: '政策',

      ),
      BottomNavigationBarItem(
        icon: Icon(
          Icons.home,
          color: _BottomNavigationColor,
        ),
        label: '新闻',
      ),
    ]));
  }
}
