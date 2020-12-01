package com.kotlin.marvelcomics.ui.description

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import com.kotlin.marvelcomics.R
import com.kotlin.marvelcomics.enitities.Hq
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_description.*

class DescriptionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description)
        val hq = intent.getSerializableExtra("hq") as Hq

        try{
            Log.i("DescriptionActivity",hq.toString())
        }catch (e:Exception){
            Log.i("DescriptionActivity",e.toString())
        }

        Picasso.get().load("${hq.thumbnail.path}.${hq.thumbnail.extension}").fit().into(ivHqImage)
        Picasso.get().load("${hq.images[0].path}.${hq.images[0].extension}").fit().into(imDescriptionLista)
        tvDescriptionTitle.text = hq.title
//        tvDescriptionDescription.text = hq.description
//        tvDescriptionPublished.text = hq.date[0].toString()
//        tvDescriptionPrice.text = hq.prices[0].toString()
//        tvDescriptionPage.text = hq.pageCount.toString()

            btDescriptionBack.setOnClickListener {
                finish()
            }
    }

}