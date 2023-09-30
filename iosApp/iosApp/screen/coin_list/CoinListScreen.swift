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
    
    init(coinRepository:CoinRepository) {
        self.viewModel = CoinListViewModel(coinRepository:coinRepository)
    }
    
    var body: some View {
        VStack{
            VStack{}.frame(height: 40)
            if(viewModel.coinList == nil){
                ZStack {
                    Circle()
                        .stroke(
                            Color(hex: 0xFF40BF6A).opacity(0.5),
                            lineWidth: 30
                        )
                    Circle()
                        .trim(from: 0, to: 0.25)
                        .stroke(
                            Color(hex: 0xFF40BF6A),
                            lineWidth: 30
                        )
                }
            }else{
                List{
                    ForEach(viewModel.coinList ?? [], id:\.self.rank){coin in
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
                        .frame(height:50)
                        .listRowBackground(Color(hex: 0xFF131316))
                    }
                }
                .listStyle(PlainListStyle())
                .listRowBackground(Color(hex: 0xFF131316))
                .background(Color(hex: 0xFF131316))
            }
        }
        .background(Color(hex: 0xFF131316))
        .frame(width: UIScreen.main.bounds.width,height: UIScreen.main.bounds.height)
    }
}
