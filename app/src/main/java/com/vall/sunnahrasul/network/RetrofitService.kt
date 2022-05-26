package com.vall.sunnahrasul.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitService {

    private val client: OkHttpClient = OkHttpClient.Builder()
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://sunnah-rasul-default-rtdb.asia-southeast1.firebasedatabase.app/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    fun <T> buildService(service: Class<T>): T {
        return retrofit.create(service)
    }

    fun getServiceKategori() = retrofit.create(RetrofitInterface::class.java)
}