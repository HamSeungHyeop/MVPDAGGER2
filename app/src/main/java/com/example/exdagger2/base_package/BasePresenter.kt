package com.example.exdagger2.base_package

import com.example.exdagger2.di_package.component.DaggerRetrofitComponent
import com.example.exdagger2.di_package.module.ActivityModule
import com.example.exdagger2.di_package.module.NetWorkModule
import com.example.exdagger2.ui_package.login.LoginPresenter

abstract class BasePresenter<T> {

    init {
        inject()
    }

    open fun onViewCreated(view: T) {

    }

    open fun onViewDestroyed() {

    }

    private fun inject() {
        when(this) {
            is LoginPresenter -> {
                DaggerRetrofitComponent.builder().netWorkModule(NetWorkModule).build().inject(this)
            }

//            is RepoPresenter -> {
//                DaggerNetworkComponent.builder().networkModule(NetworkModule).build().inject(this)
//            }
        }
    }

}