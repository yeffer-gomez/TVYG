package com.example.tvyg

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Toast
import androidx.annotation.OptIn
import androidx.appcompat.app.AppCompatActivity
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.common.util.UnstableApi
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.AspectRatioFrameLayout
import com.example.tvyg.databinding.ActivityActivitymediaplayerBinding
import com.google.android.material.snackbar.Snackbar

class ActivityMediaPlayer : AppCompatActivity() {
    private lateinit var binding: ActivityActivitymediaplayerBinding
    private lateinit var player: ExoPlayer
    private lateinit var url: String
    private val handler = Handler(Looper.getMainLooper())
    private var retryCount = 0
    private val maxRetries = 5

    @OptIn(UnstableApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)

        super.onCreate(savedInstanceState)

        // Mantener la pantalla activa
        window.addFlags(android.view.WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        binding = ActivityActivitymediaplayerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        url = intent.getStringExtra("url") ?: run {
            showError("URL no proporcionada")
            return
        }

        initializePlayer()
    }

    @OptIn(UnstableApi::class)
    private fun initializePlayer() {
        player = ExoPlayer.Builder(this).build()
        binding.video.player = player
        binding.video.resizeMode = AspectRatioFrameLayout.RESIZE_MODE_FILL

        val mediaItem = MediaItem.fromUri(url)
        player.setMediaItem(mediaItem)



        player.addListener(object : Player.Listener {
            override fun onPlayerError(error: androidx.media3.common.PlaybackException) {
                handlePlaybackError(error)
            }

            override fun onPlaybackStateChanged(state: Int) {
                when (state) {
                    Player.STATE_READY -> {
                        Toast.makeText(this@ActivityMediaPlayer, "Reproducción iniciada", Toast.LENGTH_SHORT).show()
                        retryCount = 0 // Reset retry count on successful playback
                    }
                    Player.STATE_ENDED -> {
                        // Stream ended, try to restart
                        restartPlayback()
                    }
                    Player.STATE_BUFFERING -> {
                        // Optionally show a loading indicator
                    }
                }
            }
        })

        player.prepare()
        player.play()
    }

    private fun handlePlaybackError(error: androidx.media3.common.PlaybackException) {
        if (retryCount < maxRetries) {
            retryCount++
            showError("Intentando reconectar... Intento $retryCount de $maxRetries")
            handler.postDelayed({ restartPlayback() }, 5000) // Wait 5 seconds before retrying
        } else {
            showError("Canal fuera de servicio: ${error.message}")
        }
    }

    private fun restartPlayback() {
        player.stop()
        player.clearMediaItems()
        val mediaItem = MediaItem.fromUri(url)
        player.setMediaItem(mediaItem)
        player.prepare()
        player.play()
    }

    private fun showError(message: String) {
        Snackbar.make(binding.root, message, Snackbar.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacksAndMessages(null)
        player.release()
    }
}