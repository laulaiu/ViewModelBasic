package com.leonardo.myapplication.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.leonardo.myapplication.apirest.ApiService
import com.leonardo.myapplication.databinding.ActivityMainBinding
import com.leonardo.myapplication.ui.viewmodel.UiState
import com.leonardo.myapplication.ui.viewmodel.ViewModelMainActivity
import com.leonardo.myapplication.ui.viewmodel.ViewModelLearn
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel : ViewModelMainActivity
    private val learnViewModel : ViewModelLearn by viewModels()
    private var serviceApi  = ApiService.getCepService

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    var userList: List<String>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                learnViewModel.valor.collect{ uiState ->
                    when (uiState) {
                        is UiState.Success -> showFavoriteNews(uiState.valor)
                        is UiState.Error -> showError(uiState.exception)
                    }
                }
            }
        }

        binding.getcepBtn.setOnClickListener{
            if (userList == null)
                userList = listOf("John", "Jane", "Alice")

            var message = userList?.joinToString(", ")
            message += System.currentTimeMillis()
            learnViewModel.setValor(if (message == null) "" else message)
        }
    }

    private fun showError(exception: Throwable) {
        Toast.makeText(this,  exception.message, Toast.LENGTH_SHORT  ).show()
    }

    private fun showFavoriteNews(valor: String) {
        binding.textTv.text = valor
    }

}