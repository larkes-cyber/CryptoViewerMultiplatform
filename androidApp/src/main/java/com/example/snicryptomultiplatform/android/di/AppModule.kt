package com.example.snicryptomultiplatform.android.di

import com.example.snicryptomultiplatform.data.repository.CoinRepositoryImpl
import com.example.snicryptomultiplatform.data.source.CoinRemoteDataSource
import com.example.snicryptomultiplatform.data.source.CoinRemoteDataSourceImpl
import com.example.snicryptomultiplatform.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCoinRemoteDataSource():CoinRemoteDataSource = CoinRemoteDataSourceImpl()

    @Provides
    fun provideCoinRepository(
        coinRemoteDataSource: CoinRemoteDataSource
    ):CoinRepository{
        return CoinRepositoryImpl(
            coinRemoteDataSource = coinRemoteDataSource
        )
    }

}