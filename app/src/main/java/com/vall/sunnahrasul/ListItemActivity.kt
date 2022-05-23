package com.vall.sunnahrasul

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.vall.sunnahrasul.adapter.ItemAdapter
import com.vall.sunnahrasul.databinding.ActivityListItemBinding
import com.vall.sunnahrasul.databinding.ItemKategoriRecyclerBinding
import com.vall.sunnahrasul.model.KategoriItem
import com.vall.sunnahrasul.network.RetrofitService

class ListItemActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListItemBinding

    companion object {
        const val EXTRA_DATA = "p"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListItemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }

        val data = intent.getParcelableExtra<KategoriItem>(EXTRA_DATA)

        binding.tvTitle.text = data?.title

        binding.rvItem.apply {
            adapter = data?.data?.let { ItemAdapter(it) }
            layoutManager = LinearLayoutManager(this@ListItemActivity)
            setHasFixedSize(true)
        }
    }
}