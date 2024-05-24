import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text('ExoPlayer in Flutter'),
        ),
        body: const Center(
          child: SizedBox(
            width: 300,
            height: 200,
            child: AndroidView(
              viewType: '<platform-view-type>',
            ),
          ),
        ),
      ),
    );
  }
}