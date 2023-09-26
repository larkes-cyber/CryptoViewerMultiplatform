package com.example.snicryptomultiplatform.android.presentation.screen.coin_list

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun CoinListScreen(
    viewModel: CoinListViewModel = hiltViewModel()
) {

    val coinListUIState by viewModel.coinListUIState.collectAsState()


    LazyColumn(modifier = Modifier.fillMaxSize()){

        item {
            if(coinListUIState.error.isNotEmpty()){
                Text(
                    text = coinListUIState.error,
                    style = MaterialTheme.typography.caption.copy(color = Color.Red, fontSize = 14.sp)
                )
            }
        }

        itemsIndexed(coinListUIState.coinList){index, item ->
            Text(text = item.toString())
        }

    }


}