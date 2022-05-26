package com.vall.sunnahrasul

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.vall.sunnahrasul.adapter.KategoriAdapter
import com.vall.sunnahrasul.databinding.ActivityMainBinding
import com.vall.sunnahrasul.model.KategoriItem
import com.vall.sunnahrasul.network.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    val adapters = KategoriAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnToPuasaSholat.setOnClickListener {
            startActivity(Intent(this, PuasaSholatActivity::class.java))
        }

        binding.recyclerviewKategori.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = adapters
        }

        val call = RetrofitService.getServiceKategori().getDataKategori()
        call.enqueue(object : Callback<List<KategoriItem>> {
            override fun onResponse(
                call: Call<List<KategoriItem>>,
                response: Response<List<KategoriItem>>
            ) {
                val listKategori = response.body()!!
                listKategori.let { it.let { it1 -> adapters.addDataKategori(it1) } }
            }

            override fun onFailure(call: Call<List<KategoriItem>>, t: Throwable) {}
        })
    }
}