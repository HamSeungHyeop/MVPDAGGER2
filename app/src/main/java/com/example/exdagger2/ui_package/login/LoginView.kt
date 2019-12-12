package com.example.exdagger2.ui_package.login

import com.example.exdagger2.model_package.LoginValueInfo
import com.example.exdagger2.base_package.BaseView

interface LoginView: BaseView {
    fun initButton() //버튼클릭 이벤트를 정의

    fun ReturnMessage(_bCode: String, _sMessage: String)

}