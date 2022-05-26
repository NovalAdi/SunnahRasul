package com.vall.sunnahrasul.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vall.sunnahrasul.databinding.ItemDataRecyclerBinding
import com.vall.sunnahrasul.model.DataItem

class ItemPuasaSholatAdapter : RecyclerView.Adapter<ItemPuasaSholatAdapter.ViewHolder>(){

    private val dataItem = arrayListOf<DataItem>()

    @SuppressLint("NotifyDataSetChanged")
    fun addDataItem(getData: List<DataItem>) {
        dataItem.clear()
        dataItem.addAll(getData)
        notifyDataSetChanged()
    }

    class ViewHolder(var binding: ItemDataRecyclerBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(item: DataItem) {
            itemView.run {
                binding.tvJudul.text = item.judul
                binding.tvDesk.text = item.deskripsi
                binding.tvArtiHadits.text = item.artiHadits
                binding.tvHadits.text = item.hadits
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val listData = ItemDataRecyclerBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(listData)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listItem = dataItem[position]
        holder.bind(listItem)
    }

    override fun getItemCount() = dataItem.size
}