package com.soe.holybible.navigation

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.soe.holybible.presentation.bookScreen.BookScreen
import com.soe.holybible.presentation.homeScreen.HomeScreen
import java.net.URLDecoder
import java.net.URLEncoder


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TopLevelScreenGraph(
    modifier: Modifier = Modifier
) {

    val navController = rememberNavController()
    val bibleNavController = BibleNavController(navController)
    val backStackState = navController.currentBackStackEntryAsState()


    Scaffold(
    ) { paddingValues ->

        NavHost(
            modifier = modifier.padding(
                bottom = paddingValues.calculateBottomPadding()
            ),
            startDestination = ScreenRoute.HomeScreen.route,
            navController = bibleNavController.navController
        ) {

            composable(ScreenRoute.HomeScreen.route) {
                HomeScreen(
                    navigateToBookScreen = { bible ->
                        val route = bible.id?.let { it1 -> ScreenRoute.BookScreen.createRoute(it1) }
                        if (route != null) {
                            bibleNavController.navigate(route)
                        }
                    }
                )
            }

            composable(
                route = ScreenRoute.BookScreen.route,
                arguments = listOf(
                    navArgument("bibleId") {
                        type = NavType.StringType
                    }
                )
            ) {backStackEntry ->
                val bibleId = backStackEntry.arguments?.getString("bibleId")
                if (bibleId != null) {
                    BookScreen(
                        bibleId = bibleId,
                        popup = { bibleNavController.popUp() }
                    )
                }
            }

        }
    }

}
