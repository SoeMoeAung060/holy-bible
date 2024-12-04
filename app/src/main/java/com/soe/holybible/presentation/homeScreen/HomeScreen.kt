package com.soe.holybible.presentation.homeScreen

import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun BibleListScreen(
    viewModel: HomeScreenViewModel = hiltViewModel()
) {
    val bibles by viewModel.bible.collectAsState()
    Log.d("Bible", "${bibles.size}")

    val burmeseBible by viewModel.burmeseBible.collectAsState()


    LazyColumn {
        items(bibles.size) { bible ->
            val bible = bibles[bible]
            Text(text = bible.language.name)
        }

//        item {
//            burmeseBible?.let {
//                Text(text = it.name)
//            }
//        }
    }


}
