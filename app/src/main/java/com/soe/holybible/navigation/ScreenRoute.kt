package com.soe.holybible.navigation

sealed class ScreenRoute(val route : String) {

    data object TopLevelScreenRoute : ScreenRoute("top_level_screen_route")

    data object HomeScreen : ScreenRoute("home_screen")
    data object BookScreen : ScreenRoute("book_screen/{bibleId}") {
        fun createRoute(bibleId: String) = "book_screen/$bibleId"
    }
    data object ChapterScreen : ScreenRoute("chapter_screen")
    data object SearchScreen : ScreenRoute("search_screen")

}