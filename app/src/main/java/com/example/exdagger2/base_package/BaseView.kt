package com.example.exdagger2.base_package

import android.content.Context
import androidx.annotation.StringRes


// 공통적으로 사용될 메소드 (ERROR 메시지 또는 Context)
interface BaseView {
    fun getContext(): Context

    fun showError(error: String)

    fun showError(@StringRes errorResId : Int) {
        this.showError(getContext().getString(errorResId))
    }
}