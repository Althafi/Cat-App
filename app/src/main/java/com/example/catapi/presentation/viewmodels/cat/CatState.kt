package com.example.catapi.presentation.viewmodels.cat

import com.example.catapi.domain.model.CatModel

data class CatState(
    val isLoading : Boolean = false,
    val catDetails : List<CatModel> = emptyList(),
    val error : String = ""
)
