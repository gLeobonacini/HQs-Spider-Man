package com.kotlin.marvelcomics.ui.description

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.kotlin.marvelcomics.R
import com.kotlin.marvelcomics.enitities.Hq
import com.kotlin.marvelcomics.ui.hqAmp.HqAmpActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_description.*
import java.text.SimpleDateFormat
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

        if (hq.dates[0].date != null){
            val date: Date = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").parse(hq.dates[0].date)
            val dateFormat = SimpleDateFormat("MMMM dd, yyyy", Locale.US)
            val stringDate = dateFormat.format(date)
            tvDescriptionPublished.text = stringDate
        }
        if (hq.prices[0].price != null)
            tvDescriptionPrice.text = hq.prices[0].price.toString()
        if (hq.pageCount != null)
            tvDescriptionPage.text = hq.pageCount.toString()

        btDescriptionBack.setOnClickListener {
            finish()
        }
        ivHqImage.setOnClickListener {
            val intent = Intent(this, HqAmpActivity::class.java)
            intent.putExtra("hq", hq)
            startActivity(intent)
        }
    }

}