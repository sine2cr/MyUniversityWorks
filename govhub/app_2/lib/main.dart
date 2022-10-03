import 'dart:io';

import 'package:app_2/xinwen.dart';
import 'package:app_2/zhengce.dart';
import 'package:bruno/bruno.dart';
import 'package:flutter/material.dart';
import 'package:flutter_inappwebview/flutter_inappwebview.dart';

import 'BrnBottomTabBar.dart';
import 'MyApp.dart';
import 'citySelect.dart';

Future<void> main() async {
  WidgetsFlutterBinding.ensureInitialized();
  if (Platform.isAndroid) {
    await AndroidInAppWebViewController.setWebContentsDebuggingEnabled(true);

    var swAvailable = await AndroidWebViewFeature.isFeatureSupported(
        AndroidWebViewFeature.SERVICE_WORKER_BASIC_USAGE);
    var swInterceptAvailable = await AndroidWebViewFeature.isFeatureSupported(
        AndroidWebViewFeature.SERVICE_WORKER_SHOULD_INTERCEPT_REQUEST);

    if (swAvailable && swInterceptAvailable) {
      AndroidServiceWorkerController serviceWorkerController =
          AndroidServiceWorkerController.instance();

      serviceWorkerController.serviceWorkerClient = AndroidServiceWorkerClient(
        shouldInterceptRequest: (request) async {
          print(request);
          return null;
        },
      );
    }
  }
  runApp(MaterialApp(
    home: MyApp(),
    debugShowCheckedModeBanner: false,
  ));
}

//
// String currentCity = 'changsha';
//
// void setCurrentCity(setCity) {
//   currentCity = setCity;
// }
//
// class MyApp extends StatefulWidget {
//   MyApp({Key? key}) : super(key: key);
//
//   @override
//   State<MyApp> createState() => _MyAppState();
// }
//
// class _MyAppState extends State<MyApp> {
//   int _currentIndex = 0;
//
//   String _currentCity = 'changsha';
//
//   @override
//   void initState() {
//     _currentCity = currentCity;
//   }
//
//   Widget showContext(e) {
//     setState(() {
//       _currentCity = e;
//     });
//     if (_currentIndex == 0) {
//       return zhengce(city: _currentCity);
//     } else if (_currentIndex == 1) {
//       return xinwen(city: _currentCity);
//     }
//     return zhengce(city: _currentCity);
//   }
//
//   @override
//   Widget build(BuildContext context) {
//     return MaterialApp(
//         home: Scaffold(
//       appBar: BrnAppBar(
//         brightness: Brightness.dark,
//         automaticallyImplyLeading: false,
//         backgroundColor: Colors.blue,
//         title: Row(
//           mainAxisSize: MainAxisSize.min,
//           crossAxisAlignment: CrossAxisAlignment.start,
//           children: <Widget>[
//             GestureDetector(
//               onTap: () {
//                 _currentIndex = 0;
//                 setState(() {});
//               },
//               child: const Text(
//                 '政策',
//               ),
//             ),
//             const SizedBox(
//               width: 24,
//             ),
//             GestureDetector(
//               onTap: () {
//                 _currentIndex = 1;
//                 setState(() {});
//               },
//               child: const Text(
//                 '新闻',
//               ),
//             )
//           ],
//         ),
//       ),
//       body: showContext(currentCity),
//       bottomNavigationBar: MyBottomTabBar(),
//     ));
//   }
// }
