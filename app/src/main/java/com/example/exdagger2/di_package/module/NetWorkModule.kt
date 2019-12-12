package com.example.exdagger2.di_package.module

import com.example.exdagger2.retrofit_package.RetrofitInterface
import com.example.exdagger2.ui_package.BASE_URL
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
object NetWorkModule {

    // Retrofit 모듈
    @Provides
    internal fun CreateRetrofit(): RetrofitInterface {
        val okhttp = OkHttpClient.Builder().connectTimeout(1000.toLong(), TimeUnit.SECONDS).readTimeout(1000.toLong(), TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okhttp)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(RetrofitInterface::class.java)

        return service

    }
}