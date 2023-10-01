import SwiftUI
import shared

@main
struct iOSApp: App {

    
	var body: some Scene {
        
        let coinRemoteDataSource = CoinRemoteDataSourceImpl()
        let coinRepository = CoinRepositoryImpl(coinRemoteDataSource: coinRemoteDataSource)
		WindowGroup {
            NavigationView(){
                CoinListScreen(coinRepository: coinRepository)
            }
		}
	}
}
