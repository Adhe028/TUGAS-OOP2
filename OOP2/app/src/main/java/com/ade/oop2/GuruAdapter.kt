package com.ade.oop2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ade.oop2.model.Guru
import com.ade.oop2.model.Siswa

class GuruAdapter(
    private val listItems: ArrayList<Guru>,
    private val listener: GuruListener
) : RecyclerView.Adapter<GuruAdapter.GuruViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuruViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_guru, parent, false)
        return GuruViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listItems.size
    }

    override fun onBindViewHolder(holder: GuruViewHolder, position: Int) {
        val item = listItems[position]
        holder.textViewNama.text = item.nama
        holder.textViewNip.text = item.nip
        holder.itemView.setOnClickListener {
            listener.OnItemClicked(item)
        }
    }

    class GuruViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textViewNama = itemView.findViewById<TextView>(R.id.text_view_nama)
        var textViewNip = itemView.findViewById<TextView>(R.id.text_view_nip)

    }

    interface GuruListener{
        fun OnItemClicked(guru: Guru)
    }
}