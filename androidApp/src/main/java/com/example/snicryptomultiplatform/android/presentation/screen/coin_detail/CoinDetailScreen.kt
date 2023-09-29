package com.example.snicryptomultiplatform.android.presentation.screen.coin_detail

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.snicryptomultiplatform.android.presentation.AppTheme
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun CoinDetailScreen(
    navController: NavController,
    viewModel: CoinDetailViewModel = hiltViewModel()
) {

    val coinDetailUIState by viewModel.coinDetailUIState.collectAsState()

    if(coinDetailUIState.isLoading){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(AppTheme.colors.background)
                .padding(top = 40.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularProgressIndicator(color = AppTheme.colors.secondPrimary)
        }
    }
    if(coinDetailUIState.coin != null){
        Column(
            modifier = Modifier
                .background(AppTheme.colors.background)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(top = 30.dp)
                .padding(horizontal = 20.dp)
        ) {

            Box(modifier = Modifier.padding(bottom = 20.dp)) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "",
                    modifier = Modifier
                        .size(20.dp)
                        .clickable {
                           navController.popBackStack()
                         },
                    tint = AppTheme.colors.primary,
                )
            }

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {

                Text(
                    text = "${coinDetailUIState.coin!!.rank}. ${coinDetailUIState.coin!!.name}(${coinDetailUIState.coin!!.symbol})",
                    fontSize = 22.sp,
                    color = AppTheme.colors.primary
                )
                Text(
                    text = if(coinDetailUIState.coin!!.isActive) "active" else "not active",
                    fontSize = 16.sp,
                    color = AppTheme.colors.secondPrimary,
                    fontStyle = FontStyle.Italic
                )
            }
            Text(
                text = coinDetailUIState.coin!!.description,
                fontSize = 16.sp,
                color = AppTheme.colors.primary,
                modifier = Modifier.padding(vertical = 20.dp)
            )
            Text(
                text = "Tags",
                fontSize = 20.sp,
                color = AppTheme.colors.primary
            )
            FlowRow(
                mainAxisSpacing = 10.dp,
                crossAxisSpacing = 10.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp)
            ){
                coinDetailUIState.coin!!.tags.forEach {tag ->
                    Box(
                        modifier = Modifier
                            .border(
                                width = 1.dp,
                                color = AppTheme.colors.secondPrimary,
                                shape = RoundedCornerShape(100.dp)
                            )
                            .padding(10.dp)
                    ) {
                        Text(
                            text = tag,
                            color = AppTheme.colors.secondPrimary,
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.body2
                        )
                    }
                }
            }
            Text(
                text = "Team members",
                fontSize = 20.sp,
                color = AppTheme.colors.primary,
                modifier = Modifier.padding(bottom = 20.dp)
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ){
                coinDetailUIState.coin!!.team.forEach{item ->
                    Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
                        Text(
                            text = item.name!!,
                            fontSize = 18.sp,
                            color = AppTheme.colors.primary
                        )
                        Text(
                            text = item.position!!,
                            fontSize = 16.sp,
                            color = AppTheme.colors.primary,
                            fontStyle = FontStyle.Italic
                        )
                        Divider(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(1.dp)
                                .background(Color.Gray)
                        )
                    }
                }
            }
        }
    }



}