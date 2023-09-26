package com.example.snicryptomultiplatform.android.presentation.screen.coin_list

import com.example.snicryptomultiplatform.domain.model.Coin

data class CoinListUIState(
    val isLoading:Boolean = false,
    val coinList:List<Coin> = listOf(),
    val error:String = ""
)