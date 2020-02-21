package com.project.rickandmorty.services

import com.project.rickandmorty.CharacterModel
import com.project.rickandmorty.CharacterResult
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface CharacterService {
    @GET("character")
    fun getNames(): Call<CharacterResult>

    companion object Factory {
        fun create(): CharacterService {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://rickandmortyapi.com/api/")
                .build()

            return retrofit.create(CharacterService::class.java)
        }
    }
}