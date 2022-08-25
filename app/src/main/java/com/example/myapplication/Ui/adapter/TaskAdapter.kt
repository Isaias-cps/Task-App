package com.example.myapplication.Ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.ViewParent
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemAdapterBinding
import java.text.FieldPosition

class TaskAdapter() : RecyclerView.Adapter<TaskAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemAdapterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int){

    }

    override fun getItemCount()

    inner  class MyViewHolder(val binding: ItemAdapterBinding) :
            RecyclerView.ViewHolder(binding.root)


}
