package com.example.catapi.presentation.viewmodels.cat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.catapi.domain.usecase.CatUseCase

class CatViewModelProvider (private val catUseCase: CatUseCase
):
    ViewModelProvider.NewInstanceFactory()  {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(CatViewModel::class.java) ->{
                CatViewModel(catUseCase) as T
            }


            else -> throw IllegalArgumentException("Unknown ViewModel class:" + modelClass.name)
        }
    }
}