package com.leonardo.myapplication.repository

import com.leonardo.myapplication.apirest.ApiService
import com.leonardo.myapplication.apirest.Models.DataCep
import com.leonardo.myapplication.apirest.interfaces.ICep
import retrofit2.Call

class RepsCep(private val apiService: ICep){

    fun getCep(cep : String ) = apiService.getInfoCep(cep)

}