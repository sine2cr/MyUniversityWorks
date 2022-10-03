import 'package:flutter/material.dart';
import 'package:myAPP/domain/city.dart';
import 'package:myAPP/page/cityList.dart';
import 'package:myAPP/page/citySelect.dart';
import 'package:myAPP/page/newsList.dart';
import 'package:myAPP/page/under.dart';
import 'package:myAPP/page/listContext.dart';
import 'package:myAPP/page/xinwen.dart';

import '../api/city.dart';

String currentCity = 'changsha';
int currentIndex = 0;

class MyApp extends StatefulWidget {
  MyApp({Key? key}) : super(key: key);

  // @override
  // State<MyApp> createState() => _MyAppState();
  @override
  State<MyApp> createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  final List _pageList = [];

  @override
  void initState() {
    _pageList.clear();
    _pageList.addAll(
      [
        cityList(
          city: currentCity,
        ),
        citySelect(),
        newsList(city: currentCity)
      ],
    );
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      theme: ThemeData(
        primarySwatch: Colors.teal,
      ),
      home: DefaultTabController(
        length: 3,
        child: Scaffold(
            appBar: AppBar(
              title: const Text('govhub'),
              centerTitle: true,
            ),
            body: _pageList[currentIndex],
            bottomNavigationBar: BottomNavigationBar(
              currentIndex: currentIndex,
              onTap: (int index) {
                if (index == 1) {
                  setState(() {
                    _pageList.clear();
                    _pageList.addAll(
                      [
                        cityList(
                          city: currentCity,
                        ),
                        citySelect(),
                        newsList(city: currentCity)
                      ],
                    );
                  });
                }

                setState(() {
                  print(currentCity);
                  currentIndex = index;
                  print(index);
                });
              },
              items: const [
                BottomNavigationBarItem(
                  icon: Icon(Icons.home),
                  label: '政策',
                ),
                BottomNavigationBarItem(
                  icon: Icon(Icons.home),
                  label: '选择地点',
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
