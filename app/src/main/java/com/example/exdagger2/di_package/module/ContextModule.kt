package com.example.exdagger2.di_package.module

import android.app.Application
import android.content.Context
import com.example.exdagger2.base_package.BaseView
import dagger.Module
import dagger.Provides

@Module
object ContextModule {
    // 앱의 Context를 가져올 수 있는 모듈
    @Provides
    fun provideContext(baseView: BaseView) : Context {
        return baseView.getContext()
    }

    @Provides
    fun provideApplication(context: Context) : Application {
        return context.applicationContext as Application
    }
}