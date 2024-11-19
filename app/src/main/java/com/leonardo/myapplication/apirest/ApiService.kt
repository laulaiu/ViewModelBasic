package com.leonardo.myapplication.apirest

import com.leonardo.myapplication.apirest.interfaces.ICep
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiService {

    companion object {
        private val BASE_URL = "https://viacep.com.br/"
        private val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        private val cepService: ICep by lazy {
            retrofit.create(ICep::class.java)
        }

        val getCepService: ICep
            get() = cepService

    }
}