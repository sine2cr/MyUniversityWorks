import 'package:bruno/bruno.dart';
import 'package:flutter/material.dart';

selectCityWidget(BuildContext context) {
  return BrnMultiDataPicker(
    context: context,
    delegate: Brn1RowDelegate(),
    title: '选择城市',
    confirmClick: (list) {
      BrnToast.show(list.toString(), context);
    },
  ).show();
}

class Brn1RowDelegate implements BrnMultiDataPickerDelegate {
  int firstSelectedIndex = 0;
  int secondSelectedIndex = 0;
  int thirdSelectedIndex = 0;

  List<Map<String, String>> list = [
    {'长沙市': 'changsha'},
    {'常德市': 'changde'},
    {'郴州市': 'chenzhou'},
    {'衡阳市': 'hengyang'},
    {'怀化市': 'huaihua'},
    {'娄底市': 'loudi'},
    {'邵阳市': 'shaoyang'},
    {'湘西土家族自治区': 'tujiazu'},
    {'湘潭市': 'xiangtan'},
    {'益阳市': 'yiyang'},
    {'永州市': 'yongzhou'},
    {'岳阳市': 'yueyang'},
    {'张家界市': 'zhangjiajie'},
    {'株洲市': 'zhuzhou'},
  ];

  @override
  int initSelectedRowForComponent(int component) {
    return 0;
  }

  @override
  int numberOfComponent() {
    return 5;
  }

  @override
  int numberOfRowsInComponent(int component) {
    if (0 == component) {
      return list.length;
    } else {
      Map<String, String> secondMap = list[firstSelectedIndex];
      return secondMap.values.first.length;
    }
  }

  @override
  double? rowHeightForComponent(int component) {
    return null;
  }

  @override
  void selectRowInComponent(int component, int row) {
    print(component);
  }

  @override
  String titleForRowInComponent(int component, int index) {
    return list[component].keys.first;
  }
}
