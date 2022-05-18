package com.flyconcept.callapphills.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.flyconcept.callapphills.DataList
import com.flyconcept.callapphills.databinding.ItemListBinding

class ListItemAdapterClass(private  val context: Context, private val list: ArrayList<DataList>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    fun updateCountries(newList:List<DataList>){
        list.clear()
            list.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemListBinding = ItemListBinding.inflate(LayoutInflater.from(context), parent, false)
        return MyViewHolder(itemListBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val model = list[position]
        if(holder is MyViewHolder){
           holder.btnName.text =  model.listName
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
    inner class MyViewHolder(binding: ItemListBinding):RecyclerView.ViewHolder(binding.root){
        val btnName = binding.button2
    }
}