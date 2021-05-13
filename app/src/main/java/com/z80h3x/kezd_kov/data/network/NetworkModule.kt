package com.z80h3x.kezd_kov.data.network

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.z80h3x.kezd_kov.data.network.apis.DnD5eAPI
import com.z80h3x.kezd_kov.data.network.apis.IMockCharacterAPI
import com.z80h3x.kezd_kov.data.network.apis.MockCharacterApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    companion object {
        private const val SERVER_URL = "https://www.dnd5eapi.co/"
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
                .addNetworkInterceptor { chain ->
                    Thread.sleep(3000)
                    chain.proceed(chain.request())
                }
                .addNetworkInterceptor(StethoInterceptor())
                .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .baseUrl(SERVER_URL)
                .client(okHttpClient)
                .addConverterFactory(
                        GsonConverterFactory.create(
                                GsonBuilder()
                                        .setLenient()
                                        .create()
                        )
                )
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()
    }

    @Provides
    @Singleton
    fun provideDnd5eApi(retrofit: Retrofit): DnD5eAPI =
        retrofit.create(DnD5eAPI::class.java)

    @Provides
    @Singleton
    fun provideMockCharacterApi(): IMockCharacterAPI {
        return MockCharacterApi()
    }
}