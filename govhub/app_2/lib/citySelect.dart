import 'package:app_2/main.dart';
import 'package:app_2/zhengce.dart';
import 'package:bruno/bruno.dart';
import 'package:flutter/material.dart';

import 'MyApp.dart';

class citySelect extends StatefulWidget {
  citySelect({Key? key}) : super(key: key);

  @override
  State<citySelect> createState() => _citySelectState();
}

class _citySelectState extends State<citySelect> {
  List<BrnSelectCityModel> myCityList = [
    BrnSelectCityModel(name: '长沙市', cityCode: 'changsha'),
    BrnSelectCityModel(name: '常德市', cityCode: 'changde'),
    BrnSelectCityModel(name: '郴州市', cityCode: 'chenzhou'),
    BrnSelectCityModel(name: '衡阳市', cityCode: 'hengyang'),
    BrnSelectCityModel(name: '怀化市', cityCode: 'huaihua'),
    BrnSelectCityModel(name: '娄底市', cityCode: 'loudi'),
    BrnSelectCityModel(name: '邵阳市', cityCode: 'shaoyang'),
    BrnSelectCityModel(name: '湘西土家族自治区', cityCode: 'tujiazu'),
    BrnSelectCityModel(name: '湘潭市', cityCode: 'xiangtan'),
    BrnSelectCityModel(name: '益阳市', cityCode: 'yiyang'),
    BrnSelectCityModel(name: '永州市', cityCode: 'yongzhou'),
    BrnSelectCityModel(name: '岳阳市', cityCode: 'yueyang'),
    BrnSelectCityModel(name: '张家界市', cityCode: 'zhangjiajie'),
    BrnSelectCityModel(name: '株洲市', cityCode: 'zhuzhou'),
  ];

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        debugShowCheckedModeBanner: false,
        home: BrnSingleSelectCityPage(
      appBarTitle: '选择城市',
      hotCityList: [],
      showSearchBar: true,
      cityList: myCityList,
      onValueChanged: (e) {
        setState(() {
          // setCurrentCity(e.cityCode);
          //路由跳转回首页
          Navigator.pop(context,e);
        });
      },
    ));
  }
}
