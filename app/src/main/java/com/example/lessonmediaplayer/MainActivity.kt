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
        var currentImage = 0
        var currentText = 0
        val musics = mutableListOf<Int>()
        musics.add(R.raw.we_live)
        musics.add(R.raw.mozart)
        val images = mutableListOf<Int>()
        images.add(R.drawable.smurfcat)
        images.add(R.drawable.mozart)
        val songNames = mutableListOf<String>()
        songNames.add("Smurf Cat")
        songNames.add("Mozart")
        binding.songName.text = songNames[currentText]
        binding.bgImage.setImageResource(images[currentImage])
        var mediaPlayer: MediaPlayer = MediaPlayer.create(this, musics[currentIndex])
        binding.play.setOnClickListener {
            mediaPlayer.start()
        }

        binding.stop.setOnClickListener {
            mediaPlayer.pause()
        }

        binding.next.setOnClickListener {
            if (currentIndex == 2 && currentImage == 2 && currentText == 2) {
                currentIndex = 0
                currentImage = 0
                currentText = 0
            }
            mediaPlayer.release()
            mediaPlayer = MediaPlayer.create(this, musics[currentIndex++])
            binding.bgImage.setImageResource(images[currentImage++])
            binding.songName.text=songNames[currentText++]
            mediaPlayer.start()
        }


        setContentView(binding.root)
    }
}