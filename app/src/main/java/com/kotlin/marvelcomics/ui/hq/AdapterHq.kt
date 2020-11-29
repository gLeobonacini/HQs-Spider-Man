package com.kotlin.marvelcomics.ui.hq

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kotlin.marvelcomics.R
import com.kotlin.marvelcomics.enitities.Hq
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_hq.view.*

class AdapterHq: RecyclerView.Adapter<AdapterHq.HqViewHolder>() {
    var listHq = ArrayList<Hq>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HqViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_hq, parent,false)
        return HqViewHolder(view)
    }

    override fun getItemCount() = listHq.size

    override fun onBindViewHolder(holder: HqViewHolder, position: Int) {
        var hq = listHq[position]
        holder.tvHq.text = "#${position}"
        Picasso.get().load("${hq.thumbnail.path}.${hq.thumbnail.extension}").fit().into(holder.imHq)
        Log.i("TAG","${hq.thumbnail.path}.${hq.thumbnail.extension}")
    }

    fun addList(list: ArrayList<Hq>){
        listHq.addAll(list)
        notifyDataSetChanged()
    }

    class HqViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val imHq: ImageView = view.ivHqImage
        val tvHq: TextView = view.tvHqNumber
    }
}