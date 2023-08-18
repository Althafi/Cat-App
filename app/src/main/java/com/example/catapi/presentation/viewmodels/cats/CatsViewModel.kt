package com.example.catapi.presentation.viewmodels.cats

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.catapi.domain.usecase.CatsUseCase
import com.example.catapi.domain.usecase.SearchCatCase
import com.example.catapi.utils.State
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class CatsViewModel (
    private val catsUseCase : CatsUseCase,
    private val searchCatCase : SearchCatCase
):ViewModel() {
    private val breedsValue = MutableStateFlow(CatListState())
    var _breedsValue : StateFlow<CatListState> = breedsValue

    fun getSearchedCats(search:String)=viewModelScope.launch(Dispatchers.IO){
        searchCatCase.invoke(search=search).collect {
            when(it){
                is State.Success ->{
                    breedsValue.value = CatListState(catsList = it.data?: emptyList())
                    Log.d("toCharacter",_breedsValue.value.toString())
                }
                is State.Loading ->{
                    breedsValue.value = CatListState(isLoading = true)
                    Log.d("loading",it.data.toString())
                }
                is State.Error ->{
                    breedsValue.value = CatListState(error = it.message?:"An Unexpected Error")
                    Log.d("Error",it.data.toString())
                }
            }
        }
    }
    fun getAllCatsData(offset:Int)=viewModelScope.launch(Dispatchers.IO){
        catsUseCase(offset).collect {
            when(it){
                is State.Success ->{
                    breedsValue.value = CatListState(catsList = it.data?: emptyList())
                    Log.d("toCharacter",_breedsValue.value.toString())
                }
                is State.Loading ->{
                    breedsValue.value = CatListState(isLoading = true)
                    Log.d("loading",it.data.toString())
                }
                is State.Error ->{
                    breedsValue.value = CatListState(error = it.message?:"An Unexpected Error")
                    Log.d("Error",it.data.toString())
                }
            }
        }
    }

}