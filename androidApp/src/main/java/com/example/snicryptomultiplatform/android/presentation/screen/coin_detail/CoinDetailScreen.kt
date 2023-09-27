package com.example.snicryptomultiplatform.android.presentation.screen.coin_detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.snicryptomultiplatform.android.presentation.AppTheme

@Composable
fun CoinDetailScreen(
    navController: NavController,
    coinId: String,
    viewModel: CoinDetailViewModel = hiltViewModel()
) {

    val coinDetailUIState by viewModel.coinDetailUIState.collectAsState()

    if(coinDetailUIState.isLoading){
        Column(modifier = Modifier.padding(top = 40.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            CircularProgressIndicator()
        }
    }
    if(coinDetailUIState.coin != null){
        Column() {
            Row(
                modifier = Modifier.padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "${coinDetailUIState.coin!!.rank}. ${coinDetailUIState.coin!!.name}(${coinDetailUIState.coin!!.symbol})",
                    fontSize = 22.sp,
                    color = AppTheme.colors.primary
                )
                Text(
                    text = if(coinDetailUIState.coin!!.isActive) "active" else "not active",
                    fontSize = 16.sp,
                    color = AppTheme.colors.secondPrimary
                )
            }
        }
    }



}