package com.adenikinju.bookapplication.di

import com.adenikinju.bookapplication.data.network.ApiInterface
import com.adenikinju.bookapplication.data.repository.Repository
import com.adenikinju.bookapplication.data.repository.RepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.NetworkInterface
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object Module {

    @Provides
    @Singleton
    fun providesOkhttpClient(): OkHttpClient =
        OkHttpClient.Builder()
        .addInterceptor(
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
        )
        .build()

    @Provides
    @Singleton
    fun providesApiService(retrofit: Retrofit): ApiInterface {
        return retrofit.create(ApiInterface::class.java)
    }

    @Provides
    @Singleton
    fun providesRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://gutendex.com")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }
}

@Module
@InstallIn(SingletonComponent::class)
abstract class AbstractModule {
    @Binds
    @Singleton
    abstract fun providesRepository(
        repositoryImpl: RepositoryImpl
    ): Repository

}


