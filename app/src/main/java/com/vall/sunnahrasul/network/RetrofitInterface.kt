package com.vall.sunnahrasul.network

import com.vall.sunnahrasul.model.DataItem
import com.vall.sunnahrasul.model.KategoriItem
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitInterface {
    @GET("Kategori.json")
    fun getDataKategori() : Call<List<KategoriItem>>

    @GET("puasa_sholat/0/data.json")
    fun getDataPuasa() : Call<List<DataItem>>

    @GET("puasa_sholat/1/data.json")
    fun getDataSholat() : Call<List<DataItem>>
}