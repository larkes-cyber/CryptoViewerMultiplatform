//
//  CoinDetailViewModel.swift
//  iosApp
//
//  Created by MacBook on 30.09.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import shared

extension CoinDetailScreen{
    
    @MainActor class CoinDetailViewModel:ObservableObject{
        
        @Published var coinInfo:CoinDetail? = nil
        private var coinRepository:CoinRepository? = nil
        private var coinId:String? = nil
        @Published var hasBeenDone = false
        
        func getCoinInfo(){
            coinRepository?.getCoinById(coinId: coinId ?? "", completionHandler:{ (coin, err) in
                self.coinInfo = coin?.data
                }
            )
        }
        
        func setRepository(coinRep:CoinRepository, id:String){
            coinRepository = coinRep
            coinId = id
        }
        
        func onDone(){
            hasBeenDone = true
        }
        
    }
    
}
