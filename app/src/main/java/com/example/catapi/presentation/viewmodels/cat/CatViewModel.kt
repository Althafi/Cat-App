package com.example.catapi.presentation.viewmodels.cat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.catapi.domain.usecase.CatUseCase
import com.example.catapi.utils.State
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CatViewModel (
    private val catUseCase: CatUseCase
) : ViewModel(){
    private val characterValue = MutableStateFlow(CatState())
    val _catValue : StateFlow<CatState> = characterValue

    fun getCatByIdValue(id:String)=viewModelScope.launch{
        catUseCase(id).collect {
            when(it){
                is State.Success-> {
                    characterValue.value = CatState(
                        catDetails = it.data?: emptyList()
                    )
                }
                is State.Loading->{
                    characterValue.value = CatState(isLoading = true)
                }
                is State.Error->{
                    characterValue.value = CatState(error = it.message?:"An Unexpected Error")
                }
            }
        }
    }
}