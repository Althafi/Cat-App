package com.example.catapi.domain.usecase

import com.example.catapi.domain.model.CatModel
import com.example.catapi.domain.repository.CatRepository
import com.example.catapi.utils.State
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class SearchCatCase constructor(
    private val repository : CatRepository
) {
    operator fun invoke(search:String): Flow<State<List<CatModel>>> = flow {
        try {
            emit(State.Loading<List<CatModel>>())
            val list = repository.getAllSearchedCats(search)
            emit(State.Success<List<CatModel>>(list))
        }
        catch (e: HttpException){
            emit(State.Error<List<CatModel>>(e.printStackTrace().toString()))
        }
        catch (e: IOException){
            emit(State.Error<List<CatModel>>(e.printStackTrace().toString()))
        }
    }
}