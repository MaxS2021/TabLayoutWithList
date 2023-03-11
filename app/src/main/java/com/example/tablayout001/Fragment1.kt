package com.example.tablayout001

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class Fragment1 : Fragment() {

    var player = false
    var trek = 0
    private val listMusic = listOf(
        R.raw.fon_music1,
        R.raw.fon_music2,
        R.raw.fon_music3,
    )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_1, container, false)
        val bMusic = view.findViewById<Button>(R.id.bMusic)

        var mediaPlayer = MediaPlayer.create(context, listMusic[trek])

        bMusic.setOnClickListener {
            if (!player) {
                mediaPlayer.start()
                player = true
                trek += 1
                if (trek > listMusic.size - 1) trek = 0
            } else {
                mediaPlayer.stop()
                player = false
                mediaPlayer = MediaPlayer.create(context, listMusic[trek])
            }
        }
        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() = Fragment1()
    }
}