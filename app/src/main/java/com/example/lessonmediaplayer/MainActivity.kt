package com.example.lessonmediaplayer

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.lessonmediaplayer.databinding.ActivityMainBinding
import kotlin.properties.Delegates


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        var currentIndex = 0
        val musics = mutableListOf<Int>()
        musics.add(R.raw.we_live)
        musics.add(R.raw.mozart)
        var mediaPlayer: MediaPlayer = MediaPlayer.create(this, musics[currentIndex])
        binding.play.setOnClickListener {
            mediaPlayer.start()
        }

        binding.stop.setOnClickListener {
            mediaPlayer.pause()
        }

        binding.next.setOnClickListener {
            if (currentIndex == 2) {
                currentIndex = 0
            }
            mediaPlayer.release()
            mediaPlayer = MediaPlayer.create(this, musics[currentIndex++])
            mediaPlayer.start()
        }

//        binding.next.setOnClickListener {
//            mediaPlayer.pause()
//            MediaPlayer.create(applicationContext, R.raw.mozart)
//            mediaPlayer.start()
//        }
        setContentView(binding.root)
    }
}