package com.kotlin.marvelcomics.ui.hq

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.GridLayoutManager
import com.kotlin.marvelcomics.R
import com.kotlin.marvelcomics.service.repository
import com.kotlin.marvelcomics.ui.description.DescriptionActivity
import kotlinx.android.synthetic.main.activity_hq.*

class HqActivity : AppCompatActivity(), AdapterHq.OnClickHqListener {

    val adapterHq = AdapterHq(this)

    private val viewModel by viewModels<HqViewModel>{
        object : ViewModelProvider.Factory{
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return HqViewModel(repository) as T
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hq)

        val layoutManager = GridLayoutManager(this,3)
        rvHq.adapter = adapterHq
        rvHq.layoutManager = layoutManager
        rvHq.hasFixedSize()

        viewModel.listHq.observe(this){
            adapterHq.addList(it)
        }

        //Atualizando os valores da lista
        viewModel.getHq(18,0)
    }

    override fun onClickHq(position: Int) {
        val hq = viewModel.listHq.value?.get(position)
        Toast.makeText(this,"$position", Toast.LENGTH_LONG).show()
        //intent.putExtra("imgPrato", prato.img)
        //intent.putExtra("nomePrato", prato.nome)
        //intent.putExtra("descricaoPrato", prato.descricao)
        //startActivity(Intent(this, DescriptionActivity::class.java))
    }
}