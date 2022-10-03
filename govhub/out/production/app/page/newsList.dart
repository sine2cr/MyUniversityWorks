import 'package:dio/dio.dart';
import 'package:flutter/material.dart';

import 'detail.dart';

class newsList extends StatefulWidget {
  String city;

  newsList({Key? key, required this.city}) : super(key: key);

  @override
  State<newsList> createState() => _newsListState();
}

class _newsListState extends State<newsList> {
  var result = [];

  _getNews() async {
    var dio = Dio(BaseOptions(
      baseUrl: 'http://114.116.3.191/news',
      connectTimeout: 5000,
      receiveTimeout: 100000,
      // 5s
      headers: {
        'city': widget.city,
      },
      contentType: Headers.jsonContentType,
      // Transform the response data to a String encoded with UTF8.
      // The default value is [ResponseType.JSON].
      responseType: ResponseType.json,
    ));
    Response response;
    response = await dio.post('/getAll');

    setState(() {
      result = response.data;
      print(result);
      print(result[0]['title']);
    });
  }

  @override
  void initState() {
    _getNews();
  }

  @override
  Widget build(BuildContext context) {
    return ListView.builder(
        itemCount: result.length,
        itemBuilder: (BuildContext ctx, int i) {
          var temp = result[i];
          return GestureDetector(
            onTap: () {
              Navigator.push(context,
                  MaterialPageRoute(builder: (BuildContext ctx) {
                return detail(
                  url: temp['url'],
                  title: temp['title'],
                );
              }));
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
                    result[i]['title'],
                    style: const TextStyle(
                      fontSize: 15,
                    ),
                    textAlign: TextAlign.left,
                    maxLines: 2,
                    overflow: TextOverflow.ellipsis,
                  ),
                  Text(
                    '时间:  ' + result[i]['time'],
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
