package com.kotlin.marvelcomics.ui.description

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import com.kotlin.marvelcomics.R
import com.kotlin.marvelcomics.enitities.Hq
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_description.*
import java.text.DateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class DescriptionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description)
        val hq = intent.getSerializableExtra("hq") as Hq

        Picasso.get().load("${hq.thumbnail.path}.${hq.thumbnail.extension}").fit().into(ivHqImage)
        tvDescriptionTitle.text = hq.title
        if (hq.description != null)
            tvDescriptionDescription.text = hq.description
        //if (hq.dates[0].date != null)
        //    tvDescriptionPublished.text = dateFormat.parse(hq.dates[0].date).toString()
        if (hq.prices[0].price != null)
            tvDescriptionPrice.text = hq.prices[0].price.toString()
        if (hq.pageCount != null)
            tvDescriptionPage.text = hq.pageCount.toString()

        btDescriptionBack.setOnClickListener {
            finish()
        }
    }

}