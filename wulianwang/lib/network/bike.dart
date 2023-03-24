import 'dart:io';

import 'package:dio/dio.dart';
import 'package:flutter/material.dart';

var q = Dio(BaseOptions(
  baseUrl: 'http://192.168.1.77:8081/bike',
  connectTimeout: 5000,
  receiveTimeout: 100000,
  // 5s
  contentType: Headers.jsonContentType,
  // Transform the response data to a String encoded with UTF8.
  // The default value is [ResponseType.JSON].
  responseType: ResponseType.json,
));

Future<List> getBikeInfo() async {
  List result;
  Response response = await q.get("/bikeinfo/list");
  if (response.data == null) return [];
  result = response.data["page"]["list"] as List;
  return result;
}

Future<Map> getBikeInfoById(int id) async {
  while (id < 100000000000 || id > 9999999999999) {
    id = 100000000001;
  }
  Map<String, dynamic> result;

  Response response = await q.get("/bikeinfo/info/$id");
  if (response.data == null) return {};


  result = response.data["bikeInfo"];
  return result;
}

Future<List> getBikeInfoByDate(String time,int id) async {
  List result = [];
  Response response = await q.get("/bikeinfohistory/list/$time?bikeId=$id");
  if (response.data == null) return [];

  result = response.data["list"] as List;
  return result;
}

Future<List> getssss(String time,int id) async {
  List result = [];
  Response response = await q.get("/bikeinfohistory/listByDateAndRfid//$time?bikeId=$id");
  if (response.data == null) return [];

  result = response.data["list"] as List;
  return result;
}

Future<bool> updateBikeInfoById(int id, Map<String, dynamic> json) async {
  while (id < 100000000000 || id > 9999999999999) {
    id = 100000000001;
  }

  Response response = await q.post("/bikeinfo/update", data: json);

  if (response.data["code"] == 200) {
    return true;
  }
  return false;
}

