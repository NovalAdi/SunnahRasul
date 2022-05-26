package com.vall.sunnahrasul.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vall.sunnahrasul.databinding.ItemDataRecyclerBinding
import com.vall.sunnahrasul.model.DataItem
import com.vall.sunnahrasul.model.KategoriItem

class ItemAdapter(private val dataItem : List<DataItem>): RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    class ViewHolder(var binding: ItemDataRecyclerBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val listData = ItemDataRecyclerBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(listData)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listItem = dataItem[position]
        holder.binding.tvJudul.text = listItem.judul
        holder.binding.tvHadits.text = listItem.hadits
        holder.binding.tvArtiHadits.text = listItem.artiHadits
        holder.binding.tvDesk.text = listItem.deskripsi
    }

    override fun getItemCount() = dataItem.size
}