package com.soe.holybible.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


@SuppressLint("NewApi")
@Composable
fun RootNavGraph(
    bibleNavController: BibleNavController
) {
    NavHost(
        modifier = Modifier,
        navController = bibleNavController.navController,
        startDestination = ScreenRoute.TopLevelScreenRoute.route,
    ){



        composable(route = ScreenRoute.TopLevelScreenRoute.route){
            TopLevelScreenGraph()

        }
    }

}