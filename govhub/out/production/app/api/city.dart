
import 'package:dio/dio.dart';
import 'package:myAPP/domain/city.dart';

Future<List<city>> getAllCity(String inputCity) async {
  var dio = Dio(BaseOptions(
    baseUrl: 'http://114.116.3.191/citys',
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


    List<city> result = (response.data as List<dynamic>)
        .map((e) => city.fromJson((e as Map<String, dynamic>)))
        .toList();

    return result;

}

Future<List<city>> getCityByDate(String inputCity ,String inputTime) async {
  var dio = Dio(BaseOptions(
    baseUrl: 'http://114.116.3.191/citys',
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


  List<city> result = (response.data as List<dynamic>)
      .map((e) => city.fromJson((e as Map<String, dynamic>)))
      .toList();

  return result;
}

Future<List<city>> getCityByTimes(String inputCity ,String inputStartTime,String inputEndTime) async {
  var dio = Dio(BaseOptions(
    baseUrl: 'http://114.116.3.191/citys',
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

  List<city> result = (response.data as List<dynamic>)
      .map((e) => city.fromJson((e as Map<String, dynamic>)))
      .toList();
  print(result.length);
  return result;
}
