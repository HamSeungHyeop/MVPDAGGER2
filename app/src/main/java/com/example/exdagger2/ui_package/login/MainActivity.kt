package com.example.exdagger2.ui_package

import android.content.Context
import android.os.Bundle
import android.widget.Toast

import com.example.exdagger2.ui_package.login.LoginPresenter
import com.example.exdagger2.base_package.BaseActivity
import com.example.exdagger2.R
import com.example.exdagger2.model_package.dmLoginCheck
import com.example.exdagger2.ui_package.login.LoginView
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


// BaseActivity Login View 상속
class MainActivity : BaseActivity(), LoginView {

    @Inject
    lateinit var loginPresenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loginPresenter.onViewCreated(this)
    }

    override fun initButton() {
        btnLogin.setOnClickListener {

            if (edtId.text.toString().isNullOrEmpty() || edtPwd.text.toString().isNullOrEmpty()) {
                Toast.makeText(this, getString(R.string.logininfo_null), Toast.LENGTH_SHORT).show()

            } else {
                var dmLoginCheck = dmLoginCheck(id = edtId.text.toString(), pwd = edtPwd.text.toString())
                loginPresenter.LoginCheck(dmLoginCheck)
            }
        }
    }

    override fun ReturnMessage(_bCode: String, _sMessage: String) {
        when (_bCode) {
            "LOGIN_OK" -> {
                Toast.makeText(this, "OK", Toast.LENGTH_LONG).show()
            }
            "LOGIN_FILED" -> {
                Toast.makeText(this, _sMessage, Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun getContext(): Context {
        return this
    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}
