package com.example.snicryptomultiplatform.android.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.snicryptomultiplatform.android.presentation.screen.coin_detail.CoinDetailScreen
import com.example.snicryptomultiplatform.android.presentation.screen.coin_list.CoinListScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            MyApplicationTheme {
                NavHost(navController = navController, startDestination = "/coin_list" ){
                    composable("/coin_list"){
                        CoinListScreen(navController = navController)
                    }
                    composable("/coin_detail"){
                        CoinDetailScreen(navController = navController, coinId = "btc-bitcoin")
                    }
                }
            }
        }
    }
}

