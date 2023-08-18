package com.example.catapi.domain.model

data class CatModel(
    val name: String,
    val temperament: String,
    val description: String,
    val life_span: String,
    val origin : String,
    val imageUrl: String?,
    val id: String,
)


