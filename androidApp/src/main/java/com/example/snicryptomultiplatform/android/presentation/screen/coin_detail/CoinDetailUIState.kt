package com.example.snicryptomultiplatform.android.presentation.screen.coin_detail

import com.example.snicryptomultiplatform.domain.model.CoinDetail

data class CoinDetailUIState(
    val isLoading:Boolean = false,
    val coin:CoinDetail? = null,
    val error:String = ""
)