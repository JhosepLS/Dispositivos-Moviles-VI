/*
 * Descripción: Fragmento para la reproducción de canciones
 * Autor: Jhosep
 * Fecha creación: 23 de septiembre del 2024
 * Fecha última modificación: 23 de septiembre del 2024
 */

package com.example.problema2

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class ReproductorFragment : Fragment() {

    private lateinit var imageView: ImageView
    private lateinit var tvNombreAudio: TextView
    private lateinit var btnPlay: Button
    private lateinit var btnPause: Button
    private lateinit var btnStop: Button
    private var mediaPlayer: MediaPlayer? = null

    companion object {
        private const val ARG_AUDIO_POSITION = "audio_position"
        private const val ARG_AUDIO_NOMBRE = "audio_nombre"

        fun newInstance(position: Int, nombre: String): ReproductorFragment {
            val fragment = ReproductorFragment()
            val args = Bundle()
            args.putInt(ARG_AUDIO_POSITION, position)
            args.putString(ARG_AUDIO_NOMBRE, nombre)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_reproductor, container, false)

        imageView = view.findViewById(R.id.imageView)
        tvNombreAudio = view.findViewById(R.id.tvNombreAudio)
        btnPlay = view.findViewById(R.id.btnPlay)
        btnPause = view.findViewById(R.id.btnPause)
        btnStop = view.findViewById(R.id.btnStop)

        val audioPosition = arguments?.getInt(ARG_AUDIO_POSITION, 0) ?: 0
        val audioNombre = arguments?.getString(ARG_AUDIO_NOMBRE) ?: "Canción desconocida"

        tvNombreAudio.text = audioNombre

        val audioResources = arrayOf(R.raw.song1, R.raw.song2, R.raw.song3, R.raw.song4)
        mediaPlayer = MediaPlayer.create(requireContext(), audioResources[audioPosition])

        btnPlay.setOnClickListener { mediaPlayer?.start() }
        btnPause.setOnClickListener { mediaPlayer?.pause() }
        btnStop.setOnClickListener {
            mediaPlayer?.stop()
            mediaPlayer?.prepare()
        }

        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
        mediaPlayer = null
    }
}