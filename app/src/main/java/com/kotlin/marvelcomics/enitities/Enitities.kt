package com.kotlin.marvelcomics.enitities

import java.util.*
import kotlin.collections.ArrayList


data class Res(val data: Data)

data class Data(val results: ArrayList<Hq>)

data class Hq(val title: String, val description: String, val pageCount: Int, val date: ArrayList<ComicDate>, val prices: ArrayList<ComicPrice>, val thumbnail: Images, val images: ArrayList<Images>)

data class ComicDate(val type: String, val date: Date)

data class ComicPrice(val type: String, val price: Float)

data class Images(val path: String, val extension: String)