package com.kotlin.marvelcomics.ui.hqAmp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kotlin.marvelcomics.R
import com.kotlin.marvelcomics.enitities.Hq
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_description.*
import kotlinx.android.synthetic.main.activity_hq_amp.*
import kotlinx.android.synthetic.main.activity_hq_amp.ivHqImage

class HqAmpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hq_amp)

        val hq = intent.getSerializableExtra("hq") as Hq

        Picasso.get().load("${hq.thumbnail.path}.${hq.thumbnail.extension}").fit().into(ivHqImage)

        btHqAmpClose.setOnClickListener {
            finish()
            finish()
        }
    }
}