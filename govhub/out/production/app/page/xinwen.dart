import 'package:flutter/material.dart';
import 'package:myAPP/page/newsList.dart';

class xinwen extends StatefulWidget {
  const xinwen({Key? key}) : super(key: key);

  @override
  State<xinwen> createState() => _xinwenState();
}

class _xinwenState extends State<xinwen> {
  int _currentIndex = 0;

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      theme: ThemeData(
        primarySwatch: Colors.teal,
      ),
      home: DefaultTabController(
        length: 2,
        child: Scaffold(
            appBar: AppBar(
              title: const Text('govhub'),
              centerTitle: true,
            ),
            body: newsList(
              city: 'hengyang',
            ),
            bottomNavigationBar: BottomNavigationBar(
              currentIndex: _currentIndex,
              onTap: (int index) {
                setState(() {
                  _currentIndex = index;

                });
              },
              items: const [
                BottomNavigationBarItem(
                  icon: Icon(Icons.home),
                  label: '政策',
                ),
                BottomNavigationBarItem(
                  icon: Icon(Icons.home),
                  label: '新闻',
                )
              ],
            )),
      ),
    );
  }
}
