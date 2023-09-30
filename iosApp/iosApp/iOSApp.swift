import SwiftUI
import shared

@main
struct iOSApp: App {
	var body: some Scene {
		WindowGroup {
            let coinRemoteDataSource = CoinRemoteDataSourceImpl()
            let coinRepository = CoinRepositoryImpl(coinRemoteDataSource: coinRemoteDataSource)
            CoinListScreen(coinRepository: coinRepository)
		}
	}
}
