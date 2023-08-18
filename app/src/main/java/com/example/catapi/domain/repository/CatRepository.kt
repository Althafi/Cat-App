package com.example.catapi.domain.repository

import com.example.catapi.domain.model.CatModel

interface CatRepository {

    suspend fun getAllCats(offset:Int):List<CatModel>
    suspend fun getAllSearchedCats(search:String):List<CatModel>
    suspend fun getCatById(id: String): List<CatModel>


}