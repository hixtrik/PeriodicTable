package com.hixtrik.periodictable.ui

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView.HORIZONTAL
import com.google.gson.Gson
import com.hixtrik.periodictable.R
import com.hixtrik.periodictable.adapters.ElementsAdapter
import com.hixtrik.periodictable.databinding.ActivityMainBinding
import com.hixtrik.periodictable.models.Element

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val gson = Gson()
        val elementList: List<Element> =
            gson.fromJson(loadJSONFromAssets(), Array<Element>::class.java).toList()
        binding.apply {
            recyclerView.adapter = ElementsAdapter(elementList)
            recyclerView.layoutManager = GridLayoutManager(baseContext, 9, HORIZONTAL, false)
        }
    }
}

fun Context.loadJSONFromAssets(): String {

    return resources.openRawResource(R.raw.periodic_table).bufferedReader().use {
        it.readText()
    }
}