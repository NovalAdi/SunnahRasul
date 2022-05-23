package com.vall.sunnahrasul.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.vall.sunnahrasul.ListItemActivity
import com.vall.sunnahrasul.databinding.ItemKategoriRecyclerBinding
import com.vall.sunnahrasul.model.DataItem
import com.vall.sunnahrasul.model.KategoriItem

class KategoriAdapter: RecyclerView.Adapter<KategoriAdapter.ViewHolder>() {

    private val dataKategoriItem: ArrayList<KategoriItem> = arrayListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun addDataKategori(getData: List<KategoriItem>) {
        dataKategoriItem.clear()
        dataKategoriItem.addAll(getData)
        notifyDataSetChanged()
    }

    class ViewHolder(var binding: ItemKategoriRecyclerBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val listkategori =
            ItemKategoriRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(listkategori)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listKategori = dataKategoriItem[position]
        holder.binding.ivKategori.load(listKategori.gambar)
        holder.binding.tvKategori.text = listKategori.title

        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, ListItemActivity::class.java)
            intent.putExtra(ListItemActivity.EXTRA_DATA, listKategori)
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount() = dataKategoriItem.size

}