package com.kotlin.marvelcomics.ui.login

import android.content.Intent
import androidx.lifecycle.ViewModel
import com.kotlin.marvelcomics.enitities.User
import com.kotlin.marvelcomics.ui.hq.HqActivity

class LoginViewModel: ViewModel() {
    fun verificarUsuario(email: String, password: String, remember: Boolean){
        val user = User(email,password,remember)
    }
}