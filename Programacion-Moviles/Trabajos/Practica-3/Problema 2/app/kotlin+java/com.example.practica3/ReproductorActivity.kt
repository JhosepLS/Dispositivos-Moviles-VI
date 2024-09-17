/*
 * Descripción: Actividad principal para la reproduccion de canciones
 * Autor: Jhosep
 * Fecha creación: 16 de septiembre del 2024
 * Fecha última modificación: 17 de septiembre del 2024
 */

package com.example.practica3

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ReproductorActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView
    private lateinit var tvNombreAudio: TextView
    private lateinit var btnPlay: Button
    private lateinit var btnPause: Button
    private lateinit var btnStop: Button
    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reproductor)

        imageView = findViewById(R.id.imageView)
        tvNombreAudio = findViewById(R.id.tvNombreAudio)
        btnPlay = findViewById(R.id.btnPlay)
        btnPause = findViewById(R.id.btnPause)
        btnStop = findViewById(R.id.btnStop)

        val audioSeleccionado = intent.getIntExtra("audioSeleccionado", 0)
        val nombreAudio = intent.getStringExtra("nombreAudio") ?: "Canción desconocida"

        tvNombreAudio.text = nombreAudio

        val audioResources = arrayOf(R.raw.song1, R.raw.song2, R.raw.song3, R.raw.song4)
        mediaPlayer = MediaPlayer.create(this, audioResources[audioSeleccionado])

        btnPlay.setOnClickListener { mediaPlayer?.start() }
        btnPause.setOnClickListener { mediaPlayer?.pause() }
        btnStop.setOnClickListener {
            mediaPlayer?.stop()
            mediaPlayer?.prepare()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
        mediaPlayer = null
    }
}