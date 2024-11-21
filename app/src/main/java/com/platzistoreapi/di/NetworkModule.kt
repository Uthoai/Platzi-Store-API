package com.platzistoreapi.di

import com.platzistoreapi.data.network.PlatziSecuredService
import com.platzistoreapi.data.network.PlatziService
import com.platzistoreapi.utils.AuthInterceptor
import com.platzistoreapi.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClint(interceptor: AuthInterceptor): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(interceptor).build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
    }

    @Provides
    @Singleton
    fun providePlatziService(retrofit: Retrofit.Builder): PlatziService {
        return retrofit.build().create(PlatziService::class.java)
    }

    @Provides
    @Singleton
    fun providePlatziSecuredService(
        retrofit: Retrofit.Builder,
        okHttpClient: OkHttpClient
    ): PlatziSecuredService {
        return retrofit.client(okHttpClient).build().create(PlatziSecuredService::class.java)
    }


}