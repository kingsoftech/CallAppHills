package com.flyconcept.callapphills.view

import android.os.Bundle
import android.util.Log

import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.flyconcept.callapphills.*
import com.flyconcept.callapphills.applications.DataListApplication

import com.flyconcept.callapphills.databinding.ActivityMainBinding
import com.flyconcept.callapphills.model.Color
import com.flyconcept.callapphills.view.adapter.ListItemAdapterClass

class MainActivity : AppCompatActivity() {
    private var isAppOn = false
    private val dataList = ArrayList<DataList>()
    private var activityMainBinding: ActivityMainBinding? = null
    private var dataListAdapter = ListItemAdapterClass(this, arrayListOf())
    private val mainActivityViewModel: MainActivityViewModel by viewModels{
        MainActivityViewModelFactory((application as DataListApplication).repository)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding?.root)
        val button = activityMainBinding!!.button
        val rvBinding = activityMainBinding!!.recyclerView
        rvBinding.apply {
            layoutManager =LinearLayoutManager(context)
            adapter = dataListAdapter
        }

        val colorList1 = ArrayList<Color>()
        val color1 = Color("Green")
        colorList1.add(color1)
        val colorList2 = ArrayList<Color>()
        val color2 = Color("Yellow")
        colorList2.add(color2)
        val colorList3 = ArrayList<Color>()
        val color3 = Color("Blue")
        colorList3.add(color3)

        val data1 = DataList(1, "ListA", "Play me", colorList1)
        dataList.add(data1)
        mainActivityViewModel.insert(data1)
        val data2 = DataList(2, "List2", "Play me 1", colorList2)
        dataList.add(data2)
        mainActivityViewModel.insert(data2)
        val data3 = DataList(3, "List3", "Play me 1",colorList3)
        mainActivityViewModel.insert(data3)

        val allList = mainActivityViewModel.allList
        mainActivityViewModel.getFilteredList("green").observe(this){allList->
            allList.let {
                if(it.isNotEmpty()){
                    Log.d(localClassName, allList.toString())
                    dataListAdapter.updateCountries(it)
                }
            }

        }

        buttonPressedChecker(button)
        button.setOnClickListener {
            buttonPressedChecker(button)
        }
    }

    private fun buttonPressedChecker(button: Button) {
        if (isAppOn == false) {
            button.background = ContextCompat.getDrawable(this, R.drawable.wrong_option_border_bg)
            button.text = getString(R.string.disable)
            isAppOn = true

        } else {
            button.background = ContextCompat.getDrawable(this, R.drawable.correct_option_border_bg)
            button.text = getString(R.string.enabled)
            isAppOn = false

        }
    }
}