package com.example.snicryptomultiplatform.android.presentation.screen.coin_detail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun CoinDetailScreen(
    navController: NavController,
    coinId: String,
    viewModel: CoinDetailViewModel = hiltViewModel()
) {

    val coinDetailUIState by viewModel.coinDetailUIState.collectAsState()




}