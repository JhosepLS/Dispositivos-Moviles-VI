/*
 * Descripción: Fragmento para la selección de canciones mediante un RecyclerView
 * Autor: Assistant
 * Fecha creación: 3 de octubre del 2024
 * Fecha última modificación: 3 de octubre del 2024
 */

package com.example.practica5

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SeleccionAudioFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private var listener: AudioSelectionListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_seleccion_audio, container, false)

        recyclerView = view.findViewById(R.id.recyclerViewAudios)
        recyclerView.layoutManager = LinearLayoutManager(context)

        val audios = listOf(
            Audio("Miedo y Fe - Diazepunk", R.drawable.song1, R.raw.song1, "4:16"),
            Audio("Me tengo que ir - Adolescent's Orquesta", R.drawable.song2, R.raw.song2, "4:43"),
            Audio("Treasure - Bruno Mars", R.drawable.song3, R.raw.song3, "2:59"),
            Audio("Rain - Pay money to my pain", R.drawable.song4, R.raw.song4, "5:13"),
            Audio("Deprogrammer - Pay money to my pain", R.drawable.song5, R.raw.song5, "6:29"),
            Audio("13 Monsters - Pay money to my pain", R.drawable.song5, R.raw.song6, "4:33"),
            Audio("Final Destination - Coldrain", R.drawable.song7, R.raw.song7, "3:42"),
            Audio("Click Click Boom - Saliva", R.drawable.song8, R.raw.song8, "4:14"),
            Audio("Forget About Me - Escape the Fate", R.drawable.song9, R.raw.song9, "3:05"),
            Audio("Can't Stop - Red Hot Chilli Peppers", R.drawable.song10, R.raw.song10, "4:28"),
            Audio("Still Waiting - Sum 41", R.drawable.song11, R.raw.song11, "2:39"),
            Audio("Fullmoon - Sonata Arctica", R.drawable.song12, R.raw.song12, "5:08")
        )

        val adapter = AudioAdapter(audios) { audio ->
            listener?.onAudioSelected(audio)
        }
        recyclerView.adapter = adapter

        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is AudioSelectionListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement AudioSelectionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }
}

interface AudioSelectionListener {
    fun onAudioSelected(audio: Audio)
}