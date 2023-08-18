package com.example.catapi.data.repository.remote

import com.example.catapi.data.repository.remote.CatsDTO.CatsDTOItem
import com.example.catapi.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ICatApi {

    @GET("/v1/breeds")
    suspend fun getAllCats(
        @Query("api_key")apikey:String=Constants.API_KEY,
        @Query("ts")ts:String=Constants.timeStamp,
        @Query("hash")hash:String=Constants.hash(),
        @Query("offset")offset:String
    ): List<CatsDTOItem>

    @GET("/v1/breeds")
    suspend fun getAllSearchedCats(
        @Query("api_key")apikey:String=Constants.API_KEY,
        @Query("ts")ts:String=Constants.timeStamp,
        @Query("hash")hash:String=Constants.hash(),
        @Query("nameStartsWith")search:String
    ): List<CatsDTOItem>

    @GET("/v1/breeds/{id}")
    suspend fun getCatById(
        @Path("id")id:String,
        @Query("ts")ts:String= Constants.timeStamp,
        @Query("api_key")apikey:String=Constants.API_KEY,
        @Query("hash")hash:String=Constants.hash(),
    ): List<CatsDTOItem>



}