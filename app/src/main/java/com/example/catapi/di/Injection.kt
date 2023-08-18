package com.example.catapi.di

import com.example.catapi.data.repository.remote.ICatApi
import com.example.catapi.data.repository.repository.CatRepositoryImp
import com.example.catapi.domain.repository.CatRepository
import com.example.catapi.domain.usecase.CatUseCase
import com.example.catapi.domain.usecase.CatsUseCase
import com.example.catapi.domain.usecase.SearchCatCase
import com.example.catapi.presentation.viewmodels.cat.CatViewModelProvider
import com.example.catapi.presentation.viewmodels.cats.CatsViewModelProvider
import com.example.catapi.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object Injection {

    fun provideCatViewModel(): CatViewModelProvider {
        return CatViewModelProvider(
            provideCatUseCase()
        )

    }
    
    fun provideCatsViewModel(): CatsViewModelProvider{
        return CatsViewModelProvider(
            provideCatsUseCase(),
            SearchCatCase()

        )


    }

    private fun SearchCatCase(): SearchCatCase {
        return SearchCatCase(provideCatsRepository())
    }


    private fun provideCatUseCase(): CatUseCase {
        return CatUseCase(provideCatRepository())
    }
    
    private fun provideCatsUseCase(): CatsUseCase{
        return CatsUseCase(provideCatsRepository())
        
    }


    fun provideCatRepository():CatRepository{
        return CatRepositoryImp(provideCatapi())
    }

    fun provideCatsRepository():CatRepository{
        return CatRepositoryImp(provideCatapi())
    }

    private fun provideCatapi(): ICatApi {
        val loggingInterceptor =
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
        return Retrofit.Builder()
            .baseUrl(Constants.THE_CAT_API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(ICatApi::class.java)


    }
}
