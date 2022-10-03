import 'package:bruno/bruno.dart';
import 'package:flutter/material.dart';
import 'package:app_2/xinwen.dart';
import 'package:app_2/zhengce.dart';
import 'BrnBottomTabBar.dart';
import 'citySelect.dart';

class MyApp extends StatefulWidget {
  MyApp({Key? key}) : super(key: key);

  @override
  State<MyApp> createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  int _currentIndex = 0;

  late String _currentCity ;

  @override
  void initState() {
    //默认显示长沙
    _currentCity = "changsha";
  }
//判断显示政务还是报刊
  Widget showContext(e) {
    if (_currentIndex == 0) {
      return zhengce(city: _currentCity);
    } else if (_currentIndex == 1) {
      return xinwen(city: _currentCity);
    }
    return zhengce(city: _currentCity);
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      //app上导航栏
      appBar: BrnAppBar(

        brightness: Brightness.dark,
        automaticallyImplyLeading: false,
        backgroundColor: Colors.blue,
        title: Row(
          mainAxisSize: MainAxisSize.min,
          crossAxisAlignment: CrossAxisAlignment.start,
          children: <Widget>[
            //点击事件
            GestureDetector(
              onTap: () {
                _currentIndex = 0;
                setState(() {});
              },
              child: const Text(
                '政策',
              ),
            ),
            const SizedBox(
              width: 24,
            ),
            GestureDetector(
              onTap: () {
                _currentIndex = 1;
                setState(() {});
              },
              child: const Text(
                '新闻',
              ),
            )
          ],
        ),
      ),
      //app主体部分
      body: showContext(_currentCity),
      //app导航栏
      bottomNavigationBar: BrnBottomTabBar(
          fixedColor: Colors.blue,
          onTap: (index) {
            Navigator.push(context,
                MaterialPageRoute(builder: (BuildContext ctx) {
              return citySelect();
            })).then((value) {
              setState(() {
                // print(value.cityCode);
                // setCurrentCity(value.cityCode);
                _currentCity = value.cityCode;
                if(_currentIndex==0){
                  _currentIndex = 1;
                }else{
                  _currentIndex = 0;
                }

              });
            });
            // setState(() {});
          },
          badgeColor: Colors.red,
          items: const [
            BrnBottomTabBarItem(
                icon: Icon(Icons.home),
                title: Text('选择城市'),
                selectedTextStyle: TextStyle(color: Colors.red)),
          ]),
    );
  }
}
