package com.kotlin.marvelcomics.ui.account

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.kotlin.marvelcomics.R
import com.kotlin.marvelcomics.ui.hq.HqActivity
import kotlinx.android.synthetic.main.activity_account.*

class AccountActivity : AppCompatActivity() {

    private val viewModel: AccountViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

        tbRegister.setNavigationOnClickListener {
            finish()
        }

        btSave.setOnClickListener {
            viewModel.createAccount(cadastroName.text.toString(),cadastroEmail.text.toString(),cadastroPassword.text.toString())
            startActivity(Intent(this, HqActivity::class.java))
        }
    }
}