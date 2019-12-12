package com.example.exdagger2.base_package

import androidx.appcompat.app.AppCompatActivity
import com.example.exdagger2.di_package.component.DaggerActivityComponent
import com.example.exdagger2.di_package.module.ActivityModule
import com.example.exdagger2.ui_package.MainActivity

abstract class BaseActivity : AppCompatActivity(){

    init {
        inject()
    }

    private fun inject() {
        when(this) {
            is MainActivity -> {
                DaggerActivityComponent.builder().
                    activityModule(ActivityModule).
                    build().inject(this)
            }

//            is RepoPresenter -> {
//                DaggerNetworkComponent.builder().networkModule(NetworkModule).build().inject(this)
//            }
        }
    }

}