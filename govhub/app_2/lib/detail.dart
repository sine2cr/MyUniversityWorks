import 'package:bruno/bruno.dart';
import 'package:flutter/material.dart';
import 'package:flutter_inappwebview/flutter_inappwebview.dart';


class detail extends StatefulWidget {
  String url;
  String title;

  detail({Key? key, required this.url, required this.title}) : super(key: key);

  @override
  State<detail> createState() => _detailState();
}

class _detailState extends State<detail> {
  String _url = '';

  @override
  void initState() {
    _url = widget.url;
    print(widget.url);
    print(widget.title);
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: BrnAppBar(
        title: Text(widget.title),
      ),
      body: Container(
          child: InAppWebView(
        initialUrlRequest: URLRequest(url: Uri.parse(_url)),
      )),
    );
  }
}
