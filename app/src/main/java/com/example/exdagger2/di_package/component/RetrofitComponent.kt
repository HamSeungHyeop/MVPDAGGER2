package com.example.exdagger2.di_package.component

import com.example.exdagger2.di_package.module.NetWorkModule
import com.example.exdagger2.ui_package.login.LoginPresenter
import dagger.Component
import javax.inject.Singleton

//BaseActivity에서 ActivityComponent를 빌드하여 각 Activity에 따른 Presenter를 주입.
@Singleton
@Component(modules = [NetWorkModule::class])
interface RetrofitComponent {

    fun inject(loginPresenter: LoginPresenter)
}