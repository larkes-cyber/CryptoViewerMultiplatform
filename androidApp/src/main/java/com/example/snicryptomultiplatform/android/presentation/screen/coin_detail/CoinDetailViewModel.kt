package com.example.snicryptomultiplatform.android.presentation.screen.coin_detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.snicryptomultiplatform.android.presentation.screen.coin_list.CoinListUIState
import com.example.snicryptomultiplatform.domain.repository.CoinRepository
import com.example.snicryptomultiplatform.until.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val coinRepository: CoinRepository
):ViewModel(){

    private val _coinDetailUIState = MutableStateFlow(CoinDetailUIState())
    val coinDetailUIState:StateFlow<CoinDetailUIState> = _coinDetailUIState


    init {
        observeCoinDetail()
    }

    private fun observeCoinDetail(){
        viewModelScope.launch {
            _coinDetailUIState.value = CoinDetailUIState(isLoading = true)
            when(val coin = coinRepository.getCoinById(savedStateHandle.get<String>("coinId")!!)){
                is Resource.Success -> _coinDetailUIState.value = CoinDetailUIState(coin = coin.data!!)
                is Resource.Error -> _coinDetailUIState.value = CoinDetailUIState(error = coin.message!!)
            }
        }
    }


}