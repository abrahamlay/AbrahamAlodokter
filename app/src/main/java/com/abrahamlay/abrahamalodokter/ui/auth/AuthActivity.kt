package com.abrahamlay.abrahamalodokter.ui.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.abrahamlay.abrahamalodokter.BuildConfig
import com.abrahamlay.abrahamalodokter.R
import com.abrahamlay.abrahamalodokter.ui.base.BaseActivity
import com.abrahamlay.abrahamalodokter.ui.main.MainActivity
import com.abrahamlay.abrahamalodokter.ui.util.Const
import com.abrahamlay.domain.common.ResultState
import com.abrahamlay.domain.entity.Entity
import kotlinx.android.synthetic.main.activity_auth.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class AuthActivity() : BaseActivity<AuthViewModel>() {


    override val resourceLayout: Int? = R.layout.activity_auth
    override val viewModel by viewModel<AuthViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.insert(
            Entity.User(
                0,
                "abrahamlay", "bram123",
                "android.resource://${BuildConfig.APPLICATION_ID}/" + R.drawable.img_arsenal,
                "male",
                "085695985073"
            )
        )
    }

    override fun onInitViews() {

        val isLogin = editor.getBoolean(Const.PARAM_IS_LOGIN)
        if (isLogin) {
            navigateToMainPage()
            return
        }

        btn_login.setOnClickListener {
            val username = et_username.text.toString()
            val password = et_password.text.toString()

            loginAttempt(username, password)
        }
    }

    private fun navigateToMainPage() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    override fun onInitObservers() {
        viewModel.getDetailData.observe(this, Observer {
            isAccountExist(it)
        })
    }

    private fun isAccountExist(it: ResultState<Entity.User>?) {
        when (it) {
            is ResultState.Success -> {
                editor.putBoolean(Const.PARAM_IS_LOGIN, true)
                editor.putString(Const.PARAM_USERNAME, it.data.userName.toString())
                editor.putString(Const.PARAM_PASSWORD, it.data.password.toString())
                navigateToMainPage()
                println("AuthActivity ${it.data.userName}")
            }
            is ResultState.Error -> {
                Toast.makeText(this, it.throwable.message, Toast.LENGTH_SHORT).show()
            }
            is ResultState.Loading -> {
                println("AuthActivity loading")
            }
        }
    }

    private fun loginAttempt(username: String, password: String) {
        if (username != "" && password != "") {
            viewModel.getDetails(username, password)
        } else {
            Toast.makeText(this, "Field Empty", Toast.LENGTH_SHORT).show()
        }
    }
}
