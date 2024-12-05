package com.soe.holybible.presentation.homeScreen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.soe.holybible.R
import com.soe.holybible.domain.model.Bible

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeScreenViewModel = hiltViewModel(),
    navigateToBookScreen: (Bible) -> Unit
) {
    val bibles by viewModel.bible.collectAsState()
    Log.d("Bible", "${bibles.size}")

    // Mutable list to hold Bible names
    val bibleNames = remember { mutableListOf<String>() }

    // Define the list of languages you want to display
    val targetCountries = listOf(
        "Myanmar", "China", "Thai"
    )

    // Filter the bibles based on the target languages
    val filteredBibles = bibles.filter { bible ->
        bible.countries.any{ country ->
            targetCountries.contains(country.name)

        }
    }

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
                title = { Text(text = stringResource(R.string.bibles)) }
            )
        }
    ) {paddingValue ->
        LazyColumn(
            modifier = Modifier.padding(paddingValue)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.Start,
            userScrollEnabled = true,
        ) {
            items(filteredBibles.size) {
                val bible = filteredBibles[it]
                // Add Bible name to the mutable list
                bibleNames.add(bible.language.name)
                // Print the list of Bible names to Logcat
                Log.d("BibleNamesList", "Bible Names: $bibleNames")
                Text(
                    modifier = Modifier.padding(16.dp)
                        .fillMaxWidth()
                        .clickable { navigateToBookScreen(bible) },
                    text = bible.language.name
                )
            }
        }
    }
}
