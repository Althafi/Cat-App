package com.example.catapi.data.repository.repository

import com.example.catapi.data.repository.remote.CatsDTO.toModel
import com.example.catapi.data.repository.remote.ICatApi
import com.example.catapi.domain.model.CatModel
import com.example.catapi.domain.repository.CatRepository

class CatRepositoryImp (
    private val api: ICatApi ):CatRepository {

    override suspend fun getAllCats(offset:Int): List<CatModel> {
        return api.getAllCats(offset=offset.toString()).toModel()
    }

    override suspend fun getAllSearchedCats(search: String): List<CatModel> {
        return api.getAllSearchedCats(search=search).toModel()
    }

    override suspend fun getCatById(id: String): List<CatModel> {
        return api.getCatById(id).toModel()
    }
}