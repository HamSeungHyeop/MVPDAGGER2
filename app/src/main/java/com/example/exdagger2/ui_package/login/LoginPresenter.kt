package com.example.exdagger2.ui_package.login

import com.example.exdagger2.R
import com.example.exdagger2.base_package.BasePresenter
import com.example.exdagger2.di_package.module.ContextModule.provideContext
import com.example.exdagger2.di_package.module.NetWorkModule.CreateRetrofit
import com.example.exdagger2.model_package.dmLoginCheck
import com.example.exdagger2.retrofit_package.RetrofitInterface
import com.google.gson.Gson
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import java.lang.Exception
import javax.inject.Inject

class LoginPresenter : BasePresenter<LoginView>(){

    @Inject
    lateinit var apiService: RetrofitInterface

    private var loginView: LoginView? = null

    val compositeDisposable : CompositeDisposable by lazy { CompositeDisposable() }


    override fun onViewCreated(view: LoginView) {
        super.onViewCreated(view)
        loginView = view;
        loginView?.initButton()

    }

    fun LoginCheck(userinfo: dmLoginCheck){

        try {
//            val JsonLoginCheck = Gson().toJson(userinfo)

            val map = HashMap<String, String>()
            map.put("ID", userinfo.id)
            map.put("PWD", userinfo.pwd)

            CreateRetrofit().PostLoginValue(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onBackpressureBuffer()
                .subscribeBy(
                    onNext = {
                        if (!it[0].id.isNullOrEmpty() && userinfo.pwd.equals(it[0].pwd)) {
                            loginView?.ReturnMessage("LOGIN_OK", provideContext(loginView!!).getString(R.string.loginfailed))
                        } else {
                            loginView?.ReturnMessage("LOGIN_FILED", it[0].message.toString())
                        }
                    },
                    onError = {
                        loginView?.showError(it.message.toString())
                    }
                ).apply {
                    compositeDisposable.add(this)
                }
        }catch (e:Exception){
            loginView?.ReturnMessage("LOGIN_FILED", e.message.toString())
        }


    }



    // 의존성 해제
    override fun onViewDestroyed() {
        super.onViewDestroyed()
        loginView = null
        compositeDisposable.clear()
    }

}