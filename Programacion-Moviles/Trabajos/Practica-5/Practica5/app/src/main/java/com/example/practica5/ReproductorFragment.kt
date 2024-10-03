/*
 * Descripción: Fragmento para la reproducción de canciones
 * Autor: Assistant
 * Fecha creación: 3 de octubre del 2024
 * Fecha última modificación: 3 de octubre del 2024
 */

package com.example.practica5

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
    private lateinit var tvDuracion: TextView
    private lateinit var btnPlay: Button
    private lateinit var btnPause: Button
    private lateinit var btnStop: Button
    private var mediaPlayer: MediaPlayer? = null

    companion object {
        private const val ARG_AUDIO = "audio"

        fun newInstance(audio: Audio): ReproductorFragment {
            val fragment = ReproductorFragment()
            val args = Bundle()
            args.putParcelable(ARG_AUDIO, audio)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_reproductor, container, false)

        imageView = view.findViewById(R.id.imageView)
        tvNombreAudio = view.findViewById(R.id.tvNombreAudio)
        tvDuracion = view.findViewById(R.id.tvDuracion)
        btnPlay = view.findViewById(R.id.btnPlay)
        btnPause = view.findViewById(R.id.btnPause)
        btnStop = view.findViewById(R.id.btnStop)

        val audio = arguments?.getParcelable<Audio>(ARG_AUDIO)
        audio?.let {
            imageView.setImageResource(it.imagenResId)
            tvNombreAudio.text = it.nombre
            tvDuracion.text = it.duracion
            mediaPlayer = MediaPlayer.create(requireContext(), it.audioResId)
        }

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