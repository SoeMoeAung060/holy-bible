package com.soe.holybible.presentation.bookScreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.soe.holybible.domain.model.Book
import com.soe.holybible.domain.usecase.BibleUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookViewModel @Inject constructor(
    private val useCases: BibleUseCases
) : ViewModel() {


    private val _oldTestamentBooks = MutableStateFlow<List<Book>>(emptyList())
    val oldTestamentBooks = _oldTestamentBooks.asStateFlow()

    private val _newTestamentBooks = MutableStateFlow<List<Book>>(emptyList())
    val newTestamentBooks = _newTestamentBooks.asStateFlow()



    fun fetchBibleBooks(bibleId: String) {
        viewModelScope.launch {
            // Collect books and separate them
            useCases.getBibleBooks(bibleId = bibleId).collect { books ->
                val (old, new) = separateBooksByTestament(books)
                _oldTestamentBooks.value = old
                _newTestamentBooks.value = new
            }
        }
    }

    private fun separateBooksByTestament(books: List<Book>): Pair<List<Book>, List<Book>> {
        val oldTestamentBooks = books.filter { it.id in OLD_TESTAMENT_IDS }
        val newTestamentBooks = books.filter { it.id in NEW_TESTAMENT_IDS }

        // Log to verify the separation
        Log.d("BookViewModel", "Separated Old Testament: $oldTestamentBooks")
        Log.d("BookViewModel", "Separated New Testament: $newTestamentBooks")

        return Pair(oldTestamentBooks, newTestamentBooks)
    }


    companion object{

        val OLD_TESTAMENT_IDS = listOf(
            "GEN", "EXO", "LEV", "NUM", "DEU", "JOS", "JDG", "RUT", "1SA", "2SA", "1KI", "2KI",
            "1CH", "2CH", "EZR", "NEH", "EST", "JOB", "PSA", "PRO", "ECC", "SNG", "ISA", "JER",
            "LAM", "EZK", "DAN", "HOS", "JOL", "AMO", "OBA", "JON", "MIC", "NAM", "HAB", "ZEP",
            "HAG", "ZEC", "MAL"
        )

        val NEW_TESTAMENT_IDS = listOf(
            "MAT", "MRK", "LUK", "JHN", "ACT", "ROM", "1CO", "2CO", "GAL", "EPH", "PHP", "COL",
            "1TH", "2TH", "1TI", "2TI", "TIT", "PHM", "HEB", "JAS", "1PE", "2PE", "1JN", "2JN",
            "3JN", "JUD", "REV"
        )

    }


}