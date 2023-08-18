package com.example.catapi.presentation.viewmodels.cats

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.catapi.domain.usecase.CatsUseCase
import com.example.catapi.domain.usecase.SearchCatCase

class CatsViewModelProvider (private val catsUseCase: CatsUseCase,
private val searchCatCase: SearchCatCase):
    ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(CatsViewModel::class.java) ->{
                CatsViewModel(catsUseCase, searchCatCase) as T
            }


            else -> throw IllegalArgumentException("Unknown ViewModel class:" + modelClass.name)
        }
    }
}