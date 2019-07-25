package com.example.abstractrecyclerviewlib


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class AbstractAdapterRecycleView(
     val data: MutableList<Any>, val layout: Int, var abstractAdapterRecycleViewInterface: AbstractAdapterRecycleViewInterface?=null,
     var addUi: ((View, Any) -> Unit?)? =null):
        RecyclerView.Adapter<AbstractAdapterRecycleView.MyViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(layout,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data=data[position]
        holder.setData(data,position)
        holder.itemView.tag=data
    }



    inner class MyViewHolder(itemView: View):RecyclerView.ViewHolder( itemView){


        fun setData(data: Any, pos : Int){
            abstractAdapterRecycleViewInterface?.assignUI(itemView,data)
            if(addUi!=null) {
                addUi!!(itemView,data)
            }

        }
    }
}

