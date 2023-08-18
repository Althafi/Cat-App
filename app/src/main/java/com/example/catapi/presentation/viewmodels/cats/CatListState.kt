package com.example.catapi.presentation.viewmodels.cats

import com.example.catapi.domain.model.CatModel

data class CatListState(
    val isLoading : Boolean = false,
    val catsList : List<CatModel> = emptyList(),
    val error : String = ""
)
