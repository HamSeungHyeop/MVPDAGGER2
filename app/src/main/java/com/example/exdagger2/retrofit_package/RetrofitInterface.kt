package com.example.exdagger2.retrofit_package

import com.example.exdagger2.model_package.LoginValueInfo
import com.example.exdagger2.model_package.dmLoginCheck
import io.reactivex.Flowable
import retrofit2.http.Body
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

// Rest API인터페이스
interface RetrofitInterface {

    @FormUrlEncoded
    @POST("api/Test/Login/")
    fun PostLoginValue(@FieldMap key: HashMap<String, String>): Flowable<List<LoginValueInfo>>
//    fun PostLoginValue(@FieldMap LoginCheck: String): Flowable<List<LoginValueInfo>>

}