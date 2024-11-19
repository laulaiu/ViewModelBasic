package com.leonardo.myapplication.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ViewModelLearn : ViewModel() {

    private var _valor = MutableStateFlow(UiState.Success(String()))
    val valor: StateFlow<UiState> = _valor

    fun getValor(): UiState {
        return valor.value
    }

    fun setValor(valor: String) {
        this._valor.value = UiState.Success(valor)
    }
}

sealed class UiState {
    data class Success(val valor : String) : UiState()   
    data class Error(val exception: Throwable): UiState()
}