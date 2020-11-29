package com.kotlin.marvelcomics.service

import com.kotlin.marvelcomics.enitities.Resultado
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface Repository{

    @GET("comics")
    suspend fun getResults(
        @Query("character")p1: Int,
        @Query("limit")p2: Int,
        @Query("offset")p3: Int,
        @Query("ts") p4: String,
        @Query("apikey")p5: String,
        @Query("hash")p6: String
    ): Resultado

}

val urlApiMarvel = "https://gateway.marvel.com/v1/public/character/1009610/comics"

val retrofit = Retrofit.Builder()
    .baseUrl(urlApiMarvel)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val repository: Repository = retrofit.create(Repository::class.java)