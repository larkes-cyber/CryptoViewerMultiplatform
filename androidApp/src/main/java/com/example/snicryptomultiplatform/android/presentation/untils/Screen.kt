package com.example.snicryptomultiplatform.android.presentation.untils

sealed class Screen(val route:String) {

    object CoinListScreen:Screen("coin_list_screen")
    object CoinDetailScreen:Screen("coin_detail_screen")

    fun withArgs(vararg agrs:String):String{
        return buildString {
            append(route)
            agrs.forEach {
                append("/$it")
            }
        }
    }

}