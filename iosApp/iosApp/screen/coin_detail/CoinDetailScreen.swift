//
//  CoinDetailScreen.swift
//  iosApp
//
//  Created by MacBook on 30.09.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct CoinDetailScreen: View {
    
    @Binding var isActiveScreen:Bool
    @StateObject var viewModel:CoinDetailViewModel = CoinDetailViewModel()
    var coinRepository:CoinRepository
    var coinId:String
    
    
    var body: some View {
        ZStack{
            NavigationLink(
                destination: CoinListScreen(coinRepository: coinRepository),
                isActive: $viewModel.hasBeenDone){
                EmptyView()
            }.hidden()
            .navigationBarHidden(true)
            if(viewModel.coinInfo == nil){
                CircularProgressView()
            }else{
                let rank = viewModel.coinInfo?.rank ?? 1
                let name = viewModel.coinInfo?.name ?? ""
                let symbol = viewModel.coinInfo?.symbol ?? ""
                VStack(alignment: .leading) {
                    HStack{
                        Button(action: {
                            isActiveScreen = false
                        }){
                            Image(systemName: "chevron.left")
                                .foregroundColor(Color(hex: 0xFF40BF6A))
                                .imageScale(.large)
                        }
                        .padding(.top, 32)
                        Spacer()
                    }
                    HStack{
                        Text("\(rank). \(name)(\(symbol))")
                            .font(.system(size: 24, weight: .bold))
                            .foregroundColor(Color(hex: 0xFFEEEEEE))
                        Spacer()
                        Text(((viewModel.coinInfo?.isActive) != nil) ? "active" : "not active")
                            .font(.system(size: 16, weight: .medium))
                            .foregroundColor(Color(hex: 0xFF40BF6A))
                    }
                    .padding(.top, 25)
                    Text(viewModel.coinInfo?.description_ ?? "")
                        .font(.system(size: 16, weight: .medium))
                        .foregroundColor(Color(hex: 0xFFEEEEEE))
                        .padding(.top, 10)
                    Text("Tags")
                        .font(.system(size: 24, weight: .bold))
                        .foregroundColor(Color(hex: 0xFFEEEEEE))
                        .padding(.top, 10)
                    ScrollView(.horizontal){
                        HStack {
                            ForEach(viewModel.coinInfo?.tags ?? [], id: \.self){item in
                                ColoredTextBlock(text: item, borderColor: Color(hex: 0xFF40BF6A), backgroundColor: Color(hex: 0xFF40BF6A))
                            }
                        }
                    }
                    .padding(.top, 10)
                    Text("Team members")
                        .font(.system(size: 24, weight: .bold))
                        .foregroundColor(Color(hex: 0xFFEEEEEE))
                        .padding(.top, 10)
                    List{
                        ForEach(viewModel.coinInfo?.team ?? [], id:\.self){item in
                            VStack(alignment: .leading){
                                Text(item.name ?? "")
                                    .font(.system(size: 16, weight: .medium))
                                    .foregroundColor(Color(hex: 0xFFEEEEEE))
                                Text(item.position ?? "")
                                    .font(.system(size: 14, weight: .medium))
                                    .foregroundColor(Color(hex: 0xFFEEEEEE))
                                    .padding(.top, 5)
                            }
                            .listRowBackground(Color(hex: 0xFF131316))
                        }
                    }
                    .listStyle(PlainListStyle())
                    .background(Color(hex: 0xFF131316))
                    Spacer()
                }
                .padding(.horizontal, 20)
            }
        }
        .frame(maxWidth: .infinity, maxHeight: .infinity)
        .background(Color(hex:0xFF131316))
        .onAppear{
            viewModel.setRepository(coinRep: coinRepository, id: coinId)
            viewModel.getCoinInfo()
        }
    }
}


struct ColoredTextBlock: View {
    var text: String
    var borderColor: Color
    var backgroundColor: Color
    
    var body: some View {
        ZStack {
            Rectangle()
                .fill(Color(hex: 0xFF40BF6A, alpha: 0.0))
                .cornerRadius(10) // Rounded corners for the background

            Text(text)
                .font(.system(size: 14, weight: .medium))
                .foregroundColor(Color(hex: 0xFF40BF6A)) // Text color
                .background(Color.clear) // Make sure text background is clear
                .padding()

        }
        .overlay(
            RoundedRectangle(cornerRadius: 10)
                .stroke(borderColor, lineWidth: 2) // Border color and width
        )
        .frame(maxHeight: 40)
        .padding(.vertical, 10)
    }
}

