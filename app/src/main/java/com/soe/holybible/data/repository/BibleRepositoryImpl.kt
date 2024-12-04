package com.soe.holybible.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.soe.holybible.data.mapper.toBurmeseBible
import com.soe.holybible.data.remote.api.BibleApi
import com.soe.holybible.domain.model.Bible
import com.soe.holybible.domain.model.BurmeseBible
import com.soe.holybible.domain.repository.BibleRepository
import com.soe.holybible.util.APIKEY
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class BibleRepositoryImpl @Inject constructor(
    private val bibleApi: BibleApi
) : BibleRepository {
//    override suspend fun getBurmeseBibleInfo(): Flow<BurmeseBible> {
//        return try {
//            val response = bibleApi.getBurmeseBibleInfo().toBurmeseBible()
//            flowOf(response)
//        }catch (e: Exception){
//            throw e
//        }
//    }

    override suspend fun getBible(): Flow<List<Bible>> {
        return try {
            val response = bibleApi.getBibles()
            flowOf(response.data)
        }catch (e: Exception){
            throw e
        }
    }

    override suspend fun getBibleBooks(bibleId: String, language: String): Flow<List<Bible>> {
        return try {
            val response = bibleApi.getBiblesBook(biblesId = bibleId, language = language )
            flowOf(response.data)
        }catch (e: Exception){
            throw e
        }
    }

    override suspend fun getBibleChapters(bibleId: String, bookId: String, language: String): Flow<List<Bible>> {
        return try {
            val response = bibleApi.getBiblesChapters(biblesId = bibleId, bookId = bookId, language = language )
            flowOf(response.data)
        }catch (e: Exception){
            throw e
        }
    }

    override suspend fun getBibleSearch(query: String, language: String): Flow<List<Bible>> {
        return try {
            val response = bibleApi.getBibleSearch(query = query, language = language )
            flowOf(response.data)
        }catch (e: Exception){
            throw e
        }
    }


}