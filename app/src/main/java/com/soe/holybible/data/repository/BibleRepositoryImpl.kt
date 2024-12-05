package com.soe.holybible.data.repository

import com.soe.holybible.data.remote.api.BibleApi
import com.soe.holybible.domain.model.Bible
import com.soe.holybible.domain.model.Book
import com.soe.holybible.domain.repository.BibleRepository
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class BibleRepositoryImpl @Inject constructor(
    private val bibleApi: BibleApi
) : BibleRepository {

    override suspend fun getBible(): Flow<List<Bible>> {
        return try {
            val response = bibleApi.getBibles()
            flowOf(response.data)
        }catch (e: Exception){
            throw e
        }
    }

    override suspend fun getBibleBooks(bibleId: String): Flow<List<Book>> {
        return try {
            val response = bibleApi.getBiblesBook(biblesId = bibleId )
            flowOf(response.data)
        }catch (e: Exception){
            throw e
        }
    }

    override suspend fun getBibleChapters(bibleId: String, bookId: String): Flow<List<Bible>> {
        return try {
            val response = bibleApi.getBiblesChapters(biblesId = bibleId, bookId = bookId)
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