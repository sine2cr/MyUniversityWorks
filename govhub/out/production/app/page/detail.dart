import 'package:flutter/material.dart';
import 'package:webview_flutter/webview_flutter.dart';

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
      appBar: AppBar(
        title: Text(widget.title),
        centerTitle: true,
      ),
      body: Container(
        child: WebView(
          initialUrl: widget.url,
          javascriptMode: JavascriptMode.unrestricted,
        ),
      ),
    );
  }
}
