import 'package:app_2/citySelect.dart';
import 'package:bruno/bruno.dart';
import 'package:flutter/material.dart';

import 'MyApp.dart';
import 'main.dart';

class MyBottomTabBar extends StatefulWidget {
  MyBottomTabBar({Key? key}) : super(key: key);

  @override
  State<MyBottomTabBar> createState() => _MyBottomTabBarState();
}

class _MyBottomTabBarState extends State<MyBottomTabBar> {
  @override
  Widget build(BuildContext context) {
    return BrnBottomTabBar(
        fixedColor: Colors.blue,
        onTap: (index) {
          Navigator.push(context,
              MaterialPageRoute(builder: (BuildContext ctx) {
            return citySelect();
          })).then((value) {
            setState(() {
              //todo bug

              // print(value.cityCode);
              // setCurrentCity(value.cityCode);
            });
          });
          setState(() {});
        },
        badgeColor: Colors.red,
        items: const [
          BrnBottomTabBarItem(
              icon: Icon(Icons.home),
              title: Text('选择城市'),
              selectedTextStyle: TextStyle(color: Colors.red)),
        ]);
  }
}

//
// class MyBottomTabBar extends StatelessWidget {
//   const MyBottomTabBar({Key? key}) : super(key: key);
//
//   @override
//   Widget build(BuildContext context) {
//     return BrnBottomTabBar(
//         fixedColor: Colors.blue,
//         onTap: (index) {
//           Navigator.push(context,
//               MaterialPageRoute(builder: (BuildContext ctx) {
//                 return citySelect();
//               })).then((value) {
//               print(value.cityCode);
//               setCurrentCity(value.cityCode);
//           });
//
//         },
//         badgeColor: Colors.red,
//         items: const [
//           BrnBottomTabBarItem(
//               icon: Icon(Icons.home),
//               title: Text('选择城市'),
//               selectedTextStyle: TextStyle(color: Colors.red)),
//         ]);
//   }
// }
