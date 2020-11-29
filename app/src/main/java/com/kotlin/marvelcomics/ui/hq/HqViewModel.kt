package com.kotlin.marvelcomics.ui.hq

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kotlin.marvelcomics.enitities.Hq
import com.kotlin.marvelcomics.service.Repository
import com.kotlin.marvelcomics.service.repository
import kotlinx.coroutines.launch
import java.math.BigInteger
import java.security.MessageDigest

class HqViewModel(repository: Repository): ViewModel() {

    val listHq = MutableLiveData<ArrayList<Hq>>()
    val spiderMan: Int = 1009610
    val apiPublicKey = "6eb7e8896ec5850c52515a8a23ee97f0"
    val apiPrivateKey = "0dd0c16fedb8a02985977eafca66b49f5e6a526f"

    fun getHq(limit: Int, offset: Int) {
        val ts = timeStamp()
        viewModelScope.launch {
            try {
                val resultado = repository.getResults(
                        spiderMan,
                        limit,
                        offset,
                        ts,
                        apiPublicKey,
                        "${ts}${apiPrivateKey}${apiPublicKey}".md5()
                )
                listHq.value = resultado.data.results
            }catch (e: Exception){
                Log.e("getHq",e.toString())
            }
        }
    }

    fun timeStamp(): String{
        val tsLong = System.currentTimeMillis()/1000
        Log.i("TimeStamp",tsLong.toString())
        return tsLong.toString()
    }

    fun String.md5(): String {
        val md = MessageDigest.getInstance("MD5")
        Log.i("MD5",BigInteger(1, md.digest(toByteArray())).toString(16).padStart(32, '0'))
        return BigInteger(1, md.digest(toByteArray())).toString(16).padStart(32, '0')
    }
}