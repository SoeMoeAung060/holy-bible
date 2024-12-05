package com.soe.holybible

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.soe.holybible.navigation.BibleNavController
import com.soe.holybible.navigation.RootNavGraph
import com.soe.holybible.ui.theme.HolyBibleTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HolyBibleTheme {

                val navController = rememberNavController()
                val bibleNavController = BibleNavController(navController)

                RootNavGraph(
                    bibleNavController = bibleNavController
                )
            }
        }
    }
}
