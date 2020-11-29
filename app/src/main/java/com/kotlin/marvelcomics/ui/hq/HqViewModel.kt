package com.kotlin.marvelcomics.ui.hq

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kotlin.marvelcomics.enitities.Hq
import com.kotlin.marvelcomics.service.Repository
import com.kotlin.marvelcomics.service.repository
import kotlinx.coroutines.launch

class HqViewModel(repository: Repository): ViewModel() {

    val listResults = MutableLiveData<ArrayList<Hq>>()
    val spiderMan: Int = 1009610

    fun getHq(limit: Int, offset: Int) {
        viewModelScope.launch {
            Log.i(
                "TAG", repository.getResults(
                    spiderMan,
                    limit,
                    offset,
                    "1",
                    "6eb7e8896ec5850c52515a8a23ee97f0",
                    "45ea9b6b50632eff053db727d483b249"
                ).toString()
            )
        }
    }
}