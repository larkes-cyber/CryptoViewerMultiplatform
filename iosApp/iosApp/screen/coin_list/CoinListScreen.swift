//
//  CoinListScreen.swift
//  iosApp
//
//  Created by MacBook on 30.09.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct CoinListScreen: View {
    
    @ObservedObject var viewModel:CoinListViewModel
    private var coinRepository:CoinRepository
    
    init(coinRepository:CoinRepository) {
        self.viewModel = CoinListViewModel(coinRepository:coinRepository)
        self.coinRepository = coinRepository
    }
    
    var body: some View {
        VStack{
            NavigationLink(destination:
                            CoinDetailScreen(
                                isActiveScreen: $viewModel.isSelectedCoin, coinRepository:coinRepository,
                                coinId: viewModel.selectedCoinId ?? ""
                            )
                            , isActive: $viewModel.isSelectedCoin){
                           EmptyView()
                       }.hidden()
                       .navigationBarHidden(true)
            VStack{}.frame(height: 40)
            if(viewModel.coinList == nil){
                CircularProgressView()
            }else{
                List{
                    ForEach(viewModel.coinList ?? [], id:\.self.rank){coin in
                        Button(action: {
                            viewModel.setCoinId(coinId: coin.id)
                        }){
                            HStack{
                                VStack(alignment: .leading){
                                    Text(coin.name)
                                        .foregroundColor(Color(hex:0xFFEEEEEE))
                                        .font(.title3)
                                    Spacer()
                                    Text(coin.symbol)
                                        .foregroundColor(Color(hex:0xFF575B66))
                                        .font(.system(size: 16))
                                }
                                Spacer()
                                Text((coin.isActive) ? "active" : "not active")
                                    .foregroundColor(Color(hex:0xFF40BF6A))
                                    .font(.system(size: 16))
                            }
                        }
                        .frame(height:50)
                        .listRowBackground(Color(hex: 0xFF131316))
                    }
                }
                .listStyle(PlainListStyle())
                .listRowBackground(Color(hex: 0xFF131316))
                .background(Color(hex: 0xFF131316))
            }
        }
        .frame(maxWidth: .infinity, maxHeight: .infinity)
        .background(Color(hex: 0xFF131316))
    }
}
