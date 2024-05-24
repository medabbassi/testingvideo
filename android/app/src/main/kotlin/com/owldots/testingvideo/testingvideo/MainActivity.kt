package com.owldots.testingvideo.testingvideo

import android.content.Context
import android.net.Uri
import android.view.View
import androidx.annotation.NonNull
import androidx.media3.common.MediaItem

import androidx.media3.datasource.DefaultDataSource
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.source.MediaSource
import androidx.media3.exoplayer.source.ProgressiveMediaSource
import androidx.media3.ui.PlayerView
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.StandardMessageCodec
import io.flutter.plugin.platform.PlatformView
import io.flutter.plugin.platform.PlatformViewFactory

class MainActivity : FlutterActivity() {
    private val CHANNEL = "com.owldots.testingvideo/testingvideo"

    override fun configureFlutterEngine(@NonNull flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        flutterEngine.platformViewsController.registry.registerViewFactory("<platform-view-type>", ExoPlayerViewFactory())
    }
}

class ExoPlayerViewFactory : PlatformViewFactory(StandardMessageCodec.INSTANCE) {
    override fun create(context: Context, viewId: Int, args: Any?): PlatformView {
        return ExoPlayerView(context, viewId, args)
    }
}

class ExoPlayerView(context: Context, viewId: Int, args: Any?) : PlatformView {
    private val exoPlayer: ExoPlayer = ExoPlayer.Builder(context).build()
    private val playerView: PlayerView = PlayerView(context).apply {
        player = exoPlayer
    }

    init {
        val mediaItem = MediaItem.fromUri(Uri.parse("http://glplus.me:8000/live/23090795719/53564740196/85689407.ts"))
        val dataSourceFactory = DefaultDataSource.Factory(context,)
        val videoSource: MediaSource = ProgressiveMediaSource.Factory(dataSourceFactory).createMediaSource(mediaItem)

        exoPlayer.setMediaSource(videoSource)
        exoPlayer.prepare()
        exoPlayer.playWhenReady = true
    }

    override fun getView(): View {
        return playerView
    }

    override fun dispose() {
        exoPlayer.release()
    }
}
