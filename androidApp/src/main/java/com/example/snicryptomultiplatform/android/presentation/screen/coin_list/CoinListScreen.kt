package com.example.snicryptomultiplatform.android.presentation.screen.coin_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.snicryptomultiplatform.android.presentation.AppTheme

@Composable
fun CoinListScreen(
    viewModel: CoinListViewModel = hiltViewModel(),
    navController: NavController
) {

    val coinListUIState by viewModel.coinListUIState.collectAsState()


    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(AppTheme.colors.background)
            .padding(horizontal = 20.dp)
    ){

        item {
            Spacer(modifier = Modifier.height(40.dp))
        }

        item {
            if(coinListUIState.error.isNotEmpty()){
                Text(
                    text = coinListUIState.error,
                    style = MaterialTheme.typography.caption.copy(color = Color.Red, fontSize = 14.sp)
                )
            }
        }

        item {
            if(coinListUIState.isLoading){
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ){
                    CircularProgressIndicator()
                }
            }
        }

        itemsIndexed(coinListUIState.coinList){index, item ->
            Button(
                onClick = {
                    navController.navigate("/coin_detail")
                },
                contentPadding = PaddingValues(0.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                elevation = ButtonDefaults.elevation(0.dp)
            ) {
                Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                    Column() {
                        Text(
                            text = item.name,
                            fontSize = 18.sp,
                            color = AppTheme.colors.primary,
                            modifier = Modifier.padding(bottom = 5.dp)
                        )
                        Text(
                            text = item.symbol,
                            fontSize = 15.sp,
                            color = AppTheme.colors.thirdPrimary
                        )
                    }
                    Text(
                        text =if(item.isActive) "active" else "not active",
                        fontSize = 16.sp,
                        color = AppTheme.colors.secondPrimary
                    )
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
        }

    }


}