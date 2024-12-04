package com.vertonepa.noticias.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vertonepa.noticias.most_popular.presentation.MostPopularScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = MostPopular) {
        composable<MostPopular> {
            MostPopularScreen()
        }
    }
}