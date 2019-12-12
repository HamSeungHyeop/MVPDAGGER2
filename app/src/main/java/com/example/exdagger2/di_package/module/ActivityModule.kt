package com.example.exdagger2.di_package.module

import com.example.exdagger2.ui_package.login.LoginPresenter
import dagger.Module
import dagger.Provides

//각 Activity에서 Presenter을 주입할 수 있는 모듈
@Module
object ActivityModule {

    @Provides
    internal fun provideLoginPresenter() : LoginPresenter {
        return LoginPresenter()
    }
}