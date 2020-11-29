package com.kotlin.marvelcomics.ui.hq

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.kotlin.marvelcomics.R
import com.kotlin.marvelcomics.service.repository
import kotlinx.android.synthetic.main.activity_hq.*

class HqActivity : AppCompatActivity() {

    private val viewModel by viewModels<HqViewModel>{
        object : ViewModelProvider.Factory{
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return HqViewModel(repository) as T
            }
        }
    }

    lateinit var adapterHq: AdapterHq
    lateinit var layoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hq)

        adapterHq = AdapterHq()
        layoutManager = GridLayoutManager(this,3)
        rvHq.adapter = adapterHq
        rvHq.layoutManager = layoutManager
        rvHq.hasFixedSize()

        viewModel.listHq.observe(this){
            adapterHq.addList(it)
        }

        //Atualizando os valores da lista
        viewModel.getHq(18,0)
    }
}