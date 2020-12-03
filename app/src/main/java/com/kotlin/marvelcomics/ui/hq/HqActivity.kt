package com.kotlin.marvelcomics.ui.hq

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
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
        var error = viewModel.getHq(18,0)
        if (error != null){
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Problema no servidor")
            builder.setIcon(R.drawable.ic_info)
            builder.setMessage(error)
            val dialog: AlertDialog = builder.create()
            dialog.show()
        }
    }

    override fun onClickHq(position: Int) {
        val hq = viewModel.listHq.value?.get(position)
        Log.i("HqActivity",hq.toString())
        val intent = Intent(this, DescriptionActivity::class.java)
        intent.putExtra("hq", hq)
        startActivity(intent)
    }
}