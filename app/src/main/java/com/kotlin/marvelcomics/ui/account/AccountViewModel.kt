package com.kotlin.marvelcomics.ui.account

import androidx.lifecycle.ViewModel
import com.kotlin.marvelcomics.enitities.Account

class AccountViewModel: ViewModel() {
    fun createAccount(name: String, email: String, password: String){
        val user = Account(name, email,password)
    }
}