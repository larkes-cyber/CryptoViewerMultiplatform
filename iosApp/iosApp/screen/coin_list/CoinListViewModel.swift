//
//  CoinListViewModel.swift
//  iosApp
//
//  Created by MacBook on 30.09.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import shared


extension CoinListScreen{
    @MainActor class CoinListViewModel:ObservableObject{
        
        private var coinRepository:CoinRepository
        @Published var coinList:[Coin]? = nil
        @Published var selectedCoinId:String? = nil
        @Published var isSelectedCoin:Bool = false
        
        init(coinRepository: CoinRepository) {
            self.coinRepository = coinRepository
            coinRepository.getCoins(completionHandler: { (coins,err) in
                self.coinList = coins?.data as! [Coin]
            })
        }
        
        func setCoinId(coinId:String){
            self.selectedCoinId = coinId
            self.isSelectedCoin = true
        }
        
    }
}
