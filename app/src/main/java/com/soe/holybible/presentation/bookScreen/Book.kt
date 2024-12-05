package com.soe.holybible.presentation.bookScreen

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.soe.holybible.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookScreen(
    modifier: Modifier = Modifier,
    bibleId: String,
    popup:() -> Unit,
    viewModel: BookViewModel = hiltViewModel()
) {
    LaunchedEffect(bibleId) {
        viewModel.fetchBibleBooks(bibleId)
    }

    val oldTestamentBooks by viewModel.oldTestamentBooks.collectAsState()
    val newTestamentBooks by viewModel.newTestamentBooks.collectAsState()

    Log.d("BookScreen", "Old Testament Books: $oldTestamentBooks")
    Log.d("BookScreen", "New Testament Books: $newTestamentBooks")

    Scaffold(
        modifier = modifier.fillMaxWidth(),



        topBar = {
            TopAppBar(
                modifier = Modifier.fillMaxWidth(),
                colors = TopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    scrolledContainerColor = MaterialTheme.colorScheme.background,
                    navigationIconContentColor = MaterialTheme.colorScheme.onBackground,
                    actionIconContentColor = MaterialTheme.colorScheme.onBackground,
                    titleContentColor = MaterialTheme.colorScheme.onBackground,
                ),
                title = { Text(text = stringResource(R.string.book)) },
                navigationIcon = {
                    IconButton(
                        onClick = popup
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.back),
                            contentDescription = "back"
                        )
                    }
                },
            )
        }
    ) { paddingValue ->
        LazyColumn(
            modifier = modifier
                .fillMaxWidth()
                .padding(paddingValue),
        ) {
            if (oldTestamentBooks.isNotEmpty()) {
                item {
                    Text(stringResource(R.string.old_testament))
                }
                items(oldTestamentBooks.size) {
                    val oldTestamentBook = oldTestamentBooks[it]
                    BookContent(bookName = oldTestamentBook.name)
                }
            }

            if (newTestamentBooks.isNotEmpty()) {
                item {
                    Text(
                        stringResource(R.string.new_testament))
                }
                items(newTestamentBooks.size) {
                    val newTestamentBook = newTestamentBooks[it]
                    BookContent(bookName = newTestamentBook.name)
                }
            }

        }
    }
}

@Composable
fun BookContent(
    modifier: Modifier = Modifier,
    bookName: String
) {
    Box(
        modifier = modifier
            .fillMaxWidth()  // Make the Box take the full width
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.CenterStart) // Align text to the start of the Box
        ) {
            Text(
                text = bookName,
                style = MaterialTheme.typography.bodyLarge, // Apply body text style for better readability
                color = MaterialTheme.colorScheme.onBackground // Ensure the text color is readable
            )
        }
    }
}
