package com.kotlin.marvelcomics.enitities

import android.media.Image


data class Resultado(val listHq: ArrayList<Hq>)

data class Hq(val title: String, val description: String, val thumbinail: Image, val images: ArrayList<Image>)