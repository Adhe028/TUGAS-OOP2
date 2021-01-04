package com.ade.oop2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ade.oop2.model.Siswa

class SiswaAdapter(
    private val listItems: ArrayList<Siswa>,
    private val listener: SiswaListener
) : RecyclerView.Adapter<SiswaAdapter.SiswaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SiswaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_siswa, parent, false)
        return SiswaViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listItems.size
    }

    override fun onBindViewHolder(holder: SiswaViewHolder, position: Int) {
        val item = listItems[position]
        holder.textViewNama.text = item.nama
        holder.textViewNis.text = item.nis
        holder.itemView.setOnClickListener {
            listener.OnItemClicked(item)
        }
    }

    class SiswaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textViewNama = itemView.findViewById<TextView>(R.id.text_view_nama)
        var textViewNis = itemView.findViewById<TextView>(R.id.text_view_nis)

    }

    interface SiswaListener{
        fun OnItemClicked(siswa: Siswa)
    }
}

