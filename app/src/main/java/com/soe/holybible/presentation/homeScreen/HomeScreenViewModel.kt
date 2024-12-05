package com.soe.holybible.presentation.homeScreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.soe.holybible.domain.model.Bible
import com.soe.holybible.domain.usecase.BibleUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val useCases: BibleUseCases
) : ViewModel() {

    private val _bible = MutableStateFlow<List<Bible>>(emptyList())
    val bible: StateFlow<List<Bible>> = _bible


//    private val _bibleBooks = MutableStateFlow<List<Bible>>(emptyList())
//    val bibleBooks: MutableStateFlow<List<Bible>> = _bibleBooks
//
//    private val _bibleChapters = MutableStateFlow<List<Bible>>(emptyList())
//    val bibleChapters: MutableStateFlow<List<Bible>> = _bibleChapters
//
//    private val _bibleSearch = MutableStateFlow<List<Bible>>(emptyList())
//    val bibleSearch: MutableStateFlow<List<Bible>> = _bibleSearch


    init {
        fetchBible()
//        fetchBurmeseBible()
    }

    fun fetchBible() {
        viewModelScope.launch {
            useCases.getBibles()
                .catch { e ->
                    // Handle error
                    println("Error fetching Bibles: ${e.message}")
                }.collect {
                    _bible.value = it
                    Log.d("Bible", "${it.size}")
                }
        }
    }


//    fun fetchBurmeseBible() {
//        viewModelScope.launch {
//            useCases.getBurmeseBible()
//                .catch {
//                    println("Error fetching Burmese Bible: ${it.message}")
//                }.collect{
//                    _burmeseBible.value = it
//                }
//        }
//    }
}