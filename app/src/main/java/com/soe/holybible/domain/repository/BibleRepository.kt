package com.soe.holybible.domain.repository

import androidx.paging.PagingData
import com.soe.holybible.data.remote.dto.BurmeseBibleDTO
import com.soe.holybible.domain.model.Bible
import com.soe.holybible.domain.model.Book
import com.soe.holybible.domain.model.Language
import kotlinx.coroutines.flow.Flow

interface BibleRepository {

//    suspend fun getBurmeseBibleInfo(): Flow<BurmeseBible>
    suspend fun getBible(): Flow<List<Bible>>
    suspend fun getBibleBooks(bibleId : String) : Flow<List<Book>>
    suspend fun getBibleChapters(bibleId : String, bookId : String) : Flow<List<Bible>>
    suspend fun getBibleSearch(query : String, language: String) : Flow<List<Bible>>

}