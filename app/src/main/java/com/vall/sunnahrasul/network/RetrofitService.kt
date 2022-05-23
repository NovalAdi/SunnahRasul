package com.vall.sunnahrasul.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {

    private val client: OkHttpClient = OkHttpClient.Builder()
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://sunnah-rasul-default-rtdb.asia-southeast1.firebasedatabase.app/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    fun getServiceKategori() = retrofit.create(RetrofitInterface::class.java)
}