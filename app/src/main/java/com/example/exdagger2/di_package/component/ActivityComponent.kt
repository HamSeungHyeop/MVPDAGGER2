package com.example.exdagger2.di_package.component

import com.example.exdagger2.ui_package.MainActivity
import com.example.exdagger2.di_package.module.ActivityModule
import com.example.exdagger2.di_package.module.ContextModule
import dagger.Component
import javax.inject.Singleton

//BaseActivity에서 ActivityComponent를 빌드하여 각 Activity에 따른 Presenter를 주입.

@Singleton
@Component(modules = [ContextModule::class, ActivityModule::class])
interface ActivityComponent {

    fun inject(mainActivity: MainActivity)
//    fun inject(tt: TTActivity)

}