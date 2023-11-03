package com.example.layoutappstore

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.HORIZONTAL
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import kotlin.random.Random

class Adapter_App(val appStore: MutableList<Pair<String, MutableList<String>>>) :
    RecyclerView.Adapter<Adapter_App.App_ViewHolder>() {

    inner class App_ViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val topic = itemview.findViewById<TextView>(R.id.topic)
        val recycler_hori = itemview.findViewById<RecyclerView>(R.id.rec_hori)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): App_ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_hori, parent, false)
        return App_ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return appStore.size
    }

    override fun onBindViewHolder(holder: App_ViewHolder, position: Int) {
        holder.topic.text = appStore.get(position).first
        val innerAdapter = InnerAdapter(appStore.get(position).second,position)
        val layoutManager = LinearLayoutManager(holder.itemView.context, HORIZONTAL,false)
        holder.recycler_hori.layoutManager = layoutManager
        holder.recycler_hori.adapter = innerAdapter
    }

    class InnerAdapter(val data: MutableList<String>,val posV: Int) :
        RecyclerView.Adapter<InnerAdapter.InnerViewHolder>() {
        inner class InnerViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
            val imgApp = itemview.findViewById<ImageView>(R.id.icon_app)
            val nameApp = itemview.findViewById<TextView>(R.id.nameApp)
            val rate = itemview.findViewById<TextView>(R.id.rate)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InnerViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false);
            return InnerViewHolder(view)
        }

        override fun getItemCount(): Int {
            return data.size
        }

        override fun onBindViewHolder(holder: InnerViewHolder, position: Int) {
            holder.nameApp.text = data.get(position)
            val resourceName = "img" +(position+1+posV*5)
            val resourceId = holder.itemView.resources.getIdentifier(resourceName,"drawable",holder.itemView.context.packageName)
            if(resourceId != 0 ) {
                holder.imgApp.setImageResource(resourceId)
            }else{
                Toast.makeText(holder.itemView.context,"Có 2 chục tấm hoi",Toast.LENGTH_SHORT).show()
            }
            val random = Random(System.currentTimeMillis())
            holder.rate.text = (random.nextInt(30,50)/10.0).toString()
        }
    }
}