package com.example.guilleapp.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.guilleapp.R

class AdapterCountry(var list: ArrayList<Country>) : RecyclerView.Adapter<AdapterCountry.ViewHolder>() {

    interface Response {
        fun itemPressed(item: Country)
    }

    var responseListener: Response? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.content_item, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(list[position])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var item: Country? = null

        init {
            view.setOnClickListener {
                if (item != null) {
                    responseListener?.itemPressed(item!!)
                }
            }
        }

        fun bindItems(data: Country) {
            val title: TextView = itemView.findViewById(R.id.txtName)
            val count: TextView = itemView.findViewById(R.id.txtPoblation)
            val flag: ImageView = itemView.findViewById(R.id.flag)

            title.text = data.name
            count.text = data.poblation.toString()
            Glide.with(itemView.context).load(data.flag).into(flag)

            item = data
        }
    }
}
