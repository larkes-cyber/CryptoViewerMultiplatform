package com.example.snicryptomultiplatform.android.presentation.screen.coin_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.snicryptomultiplatform.domain.repository.CoinRepository
import com.example.snicryptomultiplatform.until.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val coinRepository: CoinRepository
):ViewModel() {

    private val _coinListUIState = MutableStateFlow(CoinListUIState())
    val coinListUIState:StateFlow<CoinListUIState> = _coinListUIState

    init {
        observeCoins()
    }

    private fun observeCoins(){
        viewModelScope.launch {
            _coinListUIState.value = CoinListUIState(isLoading = true)
            when(val coins = coinRepository.getCoins()){
                is Resource.Success -> _coinListUIState.value = CoinListUIState(coinList = coins.data!!)
                is Resource.Error -> _coinListUIState.value = CoinListUIState(error = coins.message!!)
            }
        }
    }


}