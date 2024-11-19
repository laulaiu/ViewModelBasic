package com.leonardo.myapplication.apirest.interfaces

import retrofit2.Call
import com.leonardo.myapplication.apirest.Models.DataCep
import retrofit2.http.GET
import retrofit2.http.Path

interface  ICep {
    @GET("ws/{cep}/json/")
    fun getInfoCep(@Path("cep") cep: String) : Call<DataCep>

}