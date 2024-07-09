package com.example.walpapperapi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class WalpapperAdapter(val mainActivity: MainActivity,val hits:List<HitsItem?>?) : RecyclerView.Adapter<WalpapperAdapter.WalpapperViewHolder>() {


    class WalpapperViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WalpapperViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.wall_item,parent,false)
        return WalpapperViewHolder(view)
    }

    override fun getItemCount(): Int {
        return hits!!.size
    }

    override fun onBindViewHolder(holder: WalpapperViewHolder, position: Int) {

        Glide.with(mainActivity).load(hits!![position]!!.webformatURL).placeholder(R.drawable.img_2).into(holder.itemView.findViewById(R.id.wallItem))    }
}