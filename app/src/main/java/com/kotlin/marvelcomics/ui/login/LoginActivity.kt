package com.kotlin.marvelcomics.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import com.kotlin.marvelcomics.R
import com.kotlin.marvelcomics.ui.account.AccountActivity
import com.kotlin.marvelcomics.ui.hq.HqActivity
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.view.*

class LoginActivity : AppCompatActivity() {

    var remember: Boolean = false
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginRemember.setOnClickListener {
            remember = !remember
            if(!remember){
                it.setBackgroundResource(R.drawable.round_no_selection)
                it.ivRemember.setImageDrawable(null)
            }
            else {
                it.setBackgroundResource(R.drawable.round_selection)
                it.ivRemember.setBackgroundResource(R.drawable.ic_check)
            }
        }

        btLogin.setOnClickListener{
            startActivity(Intent(this, HqActivity::class.java))
            viewModel.verificarUsuario(userEmail.text.toString(),userPassword.text.toString(),remember)
        }

        tvCreate.setOnClickListener{
            startActivity(Intent(this, AccountActivity::class.java))
        }
    }
}