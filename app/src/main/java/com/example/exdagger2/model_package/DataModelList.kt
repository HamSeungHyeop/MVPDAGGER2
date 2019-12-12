package com.example.exdagger2.model_package

data class LoginValueInfo(
    var id: String?,
    var pwd: String?,
    var name: String?,
    var age: String?,
    var number: String?,
    var message: String?
)

data class dmLoginCheck(

    val id: String,
    val pwd:String

)