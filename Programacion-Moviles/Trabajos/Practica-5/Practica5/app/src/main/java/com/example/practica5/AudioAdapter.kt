/*
 * Descripción: Adaptador para el RecyclerView de la lista de canciones
 * Autor: Assistant
 * Fecha creación: 3 de octubre del 2024
 * Fecha última modificación: 3 de octubre del 2024
 */

package com.example.practica5

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AudioAdapter(
    private val audios: List<Audio>,
    private val onItemClick: (Audio) -> Unit
) : RecyclerView.Adapter<AudioAdapter.AudioViewHolder>() {

    class AudioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageViewAudio)
        val textViewNombre: TextView = itemView.findViewById(R.id.textViewNombre)
        val textViewDuracion: TextView = itemView.findViewById(R.id.textViewDuracion)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AudioViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_audio, parent, false)
        return AudioViewHolder(view)
    }

    override fun onBindViewHolder(holder: AudioViewHolder, position: Int) {
        val audio = audios[position]
        holder.imageView.setImageResource(audio.imagenResId)
        holder.textViewNombre.text = audio.nombre
        holder.textViewDuracion.text = audio.duracion
        holder.itemView.setOnClickListener { onItemClick(audio) }
    }

    override fun getItemCount() = audios.size
}

data class Audio(
    val nombre: String,
    val imagenResId: Int,
    val audioResId: Int,
    val duracion: String
)