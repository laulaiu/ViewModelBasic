
package com.leonardo.myapplication.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.leonardo.myapplication.apirest.Models.DataCep
import com.leonardo.myapplication.repository.RepsCep
import com.leonardo.myapplication.ui.viewmodel.models.InfoCep
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//https://www.worldcoinindex.com/apiservice/ticker?key=9InJgtfGmwswKCCy1gvhZImeUAlpnb0GUd0&label=ethbtc-ltcbtc&fiat=btc
class ViewModelMainActivity(private val apiService: RepsCep) : ViewModel() {

    private val _uiState = MutableStateFlow(InfoCep())
    val cep : StateFlow<InfoCep> = _uiState.asStateFlow()

    private val _error = MutableStateFlow(String())
    val errorCep : StateFlow<String> = _error.asStateFlow()

    fun getCep(cep : String){
        viewModelScope.launch {
            var resultApi = apiService.getCep(cep)
            resultApi.enqueue(object :  Callback<DataCep> {
                override fun onResponse(p0: Call<DataCep>, p1: Response<DataCep>) {
                    var code = p1.code()
                    if(p1.isSuccessful && code.equals("200") ){
                        var body = p1.body()
                        var message = p1.message()
                        var raw = p1.raw()
                    }
                }

                override fun onFailure(p0: Call<DataCep>, p1: Throwable) {
                    _error.value = ""
                }
            })


        }
    }

}