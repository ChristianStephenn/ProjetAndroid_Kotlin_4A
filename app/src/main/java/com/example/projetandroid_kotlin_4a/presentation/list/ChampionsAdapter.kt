package com.example.projetandroid_kotlin_4a.presentation.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projetandroid_kotlin_4a.R
import com.example.projetandroid_kotlin_4a.domain.entity.Champion
import kotlinx.android.synthetic.main.champion_row.view.*

class ChampionsAdapter(private val champions: MutableList<Champion>) : RecyclerView.Adapter<ChampionsAdapter.ViewHolder>() {


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val name: TextView = itemView.firstLine
        val classOrOrigin: TextView = itemView.secondLine
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.champion_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = champions.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val champ = champions[position]
        holder.name.text = champ.name
        holder.classOrOrigin.text = champ.classOrOrigin
    }
}
