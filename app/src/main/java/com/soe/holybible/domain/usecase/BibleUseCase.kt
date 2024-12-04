package com.soe.holybible.domain.usecase

import com.soe.holybible.domain.repository.BibleRepository

data class BibleUseCases(
//    val getBurmeseBible: GetBurmeseBible,
    val getBibles: GetBibles,
    val getBibleBooks: GetBibleBooks,
    val getBibleChapters: GetBibleChapters,
    val getBibleSearch: GetBibleSearch
)

//class GetBurmeseBible(
//    private val repository: BibleRepository
//){
//    suspend operator fun invoke() = repository.getBurmeseBibleInfo()
//}
class GetBibles(
    private val repository: BibleRepository
){
    suspend operator fun invoke() = repository.getBible()
}

class GetBibleBooks(
    private val repository: BibleRepository
){
    suspend operator fun invoke(bibleId : String, language: String) = repository.getBibleBooks(bibleId, language)
}

class GetBibleChapters(
    private val repository: BibleRepository
){
    suspend operator fun invoke(bibleId : String, bookId : String, language: String) = repository.getBibleChapters(bibleId, bookId, language)
}

class GetBibleSearch(
    private val repository: BibleRepository
){
    suspend operator fun invoke(query : String, language: String) = repository.getBibleSearch(query, language)

}