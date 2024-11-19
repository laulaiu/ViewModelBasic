package com.leonardo.myapplication.ui

// No need to copy over
sealed interface UiStateInterface {
    data class Success(val photos: String) : UiStateInterface
    object Error : UiStateInterface
    object Loading : UiStateInterface
}