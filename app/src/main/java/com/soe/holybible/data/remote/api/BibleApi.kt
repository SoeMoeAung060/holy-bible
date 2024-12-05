package com.soe.holybible.data.remote.api

import com.soe.holybible.data.remote.dto.BibleDTO
import com.soe.holybible.data.remote.dto.BookDTO
import com.soe.holybible.util.APIKEY
import com.soe.holybible.util.LANGUAGE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query


interface BibleApi {


    @GET("/v1/bibles")
    suspend fun getBibles(
        @Header("api-key") apiKey: String = APIKEY
    ):BibleDTO

    @GET("/v1/bibles/{bibleId}/books")
    suspend fun getBiblesBook(
        @Path("bibleId") biblesId : String,
        @Header("api-key") apiKey: String =  APIKEY,
    ):BookDTO


    @GET("/v1/bibles/{bibleId}/books/{bookId}/chapters")
    suspend fun getBiblesChapters(
        @Path("bibleId") biblesId : String,
        @Path("bookId") bookId : String,
        @Header("api-key") apiKey: String =  APIKEY,
        @Query("language") language: String = LANGUAGE
    ):BibleDTO

    @GET("/v1/bibles/{bibleId}/search")
    suspend fun getBibleSearch(
        @Query("query") query : String,
        @Header("api-key") apiKey: String =  APIKEY,
        @Query("language") language: String = LANGUAGE
    ):BibleDTO
}