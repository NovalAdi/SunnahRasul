package com.vall.sunnahrasul.network

import com.vall.sunnahrasul.model.DataItem
import com.vall.sunnahrasul.model.KategoriItem
import com.vall.sunnahrasul.model.ResponseSunnah
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitInterface {
    @GET("Kategori.json")
    fun getDataKategori() : Call<List<KategoriItem>>
}