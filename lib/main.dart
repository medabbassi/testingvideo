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
          title: const Text('ExoPlayer in Flutter'),
        ),
        body:  const Center(
          child: SizedBox(
            width: 300,
            height: 200,
            child: AndroidView(
              viewType: '<platform-view-type>',
              creationParams: <String, dynamic>{
                'url': 'http://glplus.me:8000/live/23090795719/53564740196/85689407.ts',},
                creationParamsCodec: StandardMessageCodec(),
            ),
          ),
        ),
      ),
    );
  }
}