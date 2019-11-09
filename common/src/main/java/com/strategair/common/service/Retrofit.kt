package com.strategair.common.service

import com.strategair.common.service.Service.gson
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object Retrofit {

    private const val END_POINT = "https://strategair.com/api/v1"

    val client = OkHttpClient.Builder()
        .connectTimeout(10, TimeUnit.SECONDS)
        .readTimeout(10, TimeUnit.SECONDS)
        .writeTimeout(10, TimeUnit.SECONDS)
        .build()

    val retrofit = Retrofit.Builder()
        .client(client)
        .baseUrl(END_POINT)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
}