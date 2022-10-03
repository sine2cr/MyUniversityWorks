
import 'package:dio/dio.dart';

import '../domain/news.dart';

Future<List<news>> getAllNews(String inputCity) async {
  var dio = Dio(BaseOptions(
    baseUrl: 'http://114.116.3.191/news',
    connectTimeout: 5000,
    receiveTimeout: 100000,
    // 5s
    headers: {
      'city': inputCity,
    },
    contentType: Headers.jsonContentType,
    // Transform the response data to a String encoded with UTF8.
    // The default value is [ResponseType.JSON].
    responseType: ResponseType.json,
  ));
  Response response;
  response = await dio.post('/getAll');

  print(response.data);
  print('==========   ');
  if (response.statusCode == 200) {
    List<news> result = (response.data as List<dynamic>)
        .map((e) => news.fromJson((e as Map<String, dynamic>)))
        .toList();
    print(result.length);
    return result;
  } else {
    return [];
  }
}

Future<List<news>> getNewsByDate(String inputCity ,String inputTime) async {
  var dio = Dio(BaseOptions(
    baseUrl: 'http://114.116.3.191/news',
    connectTimeout: 5000,
    receiveTimeout: 100000,
    // 5s
    headers: {
      'city': inputCity,
      'time':inputTime
    },
    contentType: Headers.jsonContentType,
    // Transform the response data to a String encoded with UTF8.
    // The default value is [ResponseType.JSON].
    responseType: ResponseType.json,
  ));
  Response response;
  response = await dio.post('/getByDate');

  print(response.data);
  print('==========   ');
  // List<city> result = json.decode(response.data);
  List<news> result = (response.data as List<dynamic>)
      .map((e) => news.fromJson((e as Map<String, dynamic>)))
      .toList();
  print(result.length);
  return result;
}

Future<List<news>> getNewsByTimes(String inputCity ,String inputStartTime,String inputEndTime) async {
  var dio = Dio(BaseOptions(
    baseUrl: 'http://114.116.3.191/news',
    connectTimeout: 5000,
    receiveTimeout: 100000,
    // 5s
    headers: {
      'city': inputCity,
      'startTime':inputStartTime,
      'endTime':inputEndTime,
    },
    contentType: Headers.jsonContentType,
    // Transform the response data to a String encoded with UTF8.
    // The default value is [ResponseType.JSON].
    responseType: ResponseType.json,
  ));
  Response response;
  response = await dio.post('/getByTimeQuantum');

  print(response.data);
  print('==========   ');
  List<news> result = (response.data as List<dynamic>)
      .map((e) => news.fromJson((e as Map<String, dynamic>)))
      .toList();
  print(result.length);
  return result;
}
