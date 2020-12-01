package com.kotlin.marvelcomics.enitities

import java.io.Serializable
import java.util.*
import kotlin.collections.ArrayList


data class Res(val data: Data)

data class Data(val results: ArrayList<Hq>)

data class Hq(val title: String,
              val description: String,
              val pageCount: Int,
              val dates: ArrayList<ComicDate>,
              val prices: ArrayList<ComicPrice>,
              val thumbnail: Images): Serializable

data class ComicDate(val date: String): Serializable

data class ComicPrice(val price: Float): Serializable

data class Images(val path: String, val extension: String): Serializable