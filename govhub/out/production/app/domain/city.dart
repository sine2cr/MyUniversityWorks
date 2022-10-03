class city {
  final String title;
  final String url;
  final String time;

  city({required this.title, required this.url, required this.time});

  factory city.fromJson(Map<String, dynamic> json) {
    return city(
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
