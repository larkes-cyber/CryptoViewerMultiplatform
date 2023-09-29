package com.example.snicryptomultiplatform.android.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavArgument
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgs
import androidx.navigation.navArgument
import com.example.snicryptomultiplatform.android.presentation.screen.coin_detail.CoinDetailScreen
import com.example.snicryptomultiplatform.android.presentation.screen.coin_list.CoinListScreen
import com.example.snicryptomultiplatform.android.presentation.untils.Screen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            MyApplicationTheme {
                NavHost(navController = navController, startDestination = Screen.CoinListScreen.route ){
                    composable(Screen.CoinListScreen.route){
                        CoinListScreen(navController = navController)
                    }
                    composable(
                        route = Screen.CoinDetailScreen.route + "/{coinId}",
                        arguments = listOf(
                            navArgument("coinId"){
                                type = NavType.StringType
                                defaultValue = ""
                            }
                        )
                    ){entry ->
                        CoinDetailScreen(navController = navController)
                    }
                }
            }
        }
    }
}

