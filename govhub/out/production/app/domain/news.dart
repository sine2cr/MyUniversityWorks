class news {
  final String title;
  final String url;
  final String time;

  news({required this.title, required this.url, required this.time});

  factory news.fromJson(Map<String, dynamic> json) {
    return news(
      title: json['title'],
      url: json['url'],
      time: json['time'],
    );
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['title'] = this.title;
    data['url'] = this.url;
    data['time'] = this.time;
    return data;
  }
}
