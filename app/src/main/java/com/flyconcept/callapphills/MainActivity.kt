package com.flyconcept.callapphills

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.flyconcept.callapphills.R.color
import com.flyconcept.callapphills.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var isAppOn = false
    val dataList = ArrayList<DataList>()
    var activityMainBinding: ActivityMainBinding? = null
    var dataListAdapter = ListItemAdapterClass(this, arrayListOf())
    lateinit var viewModel:MainActivityViewModel
    private val mainActivityViewModel: MainActivityViewModel by viewModels {
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

        val color1 = arrayListOf<String>("Pink", "red", "purple")
        val color2 = arrayListOf<String>("Green", "Blue", "yellow")
        val data1 = DataList(1, "ListA", "Play me", color1)
        dataList.add(data1)

        val data2 = DataList(2, "List2", "Play me 1", color2)
        dataList.add(data2)
        dataListAdapter.updateCountries(dataList)
        buttonPressedChecker(button)
        button.setOnClickListener {
            buttonPressedChecker(button)
        }
    }

    private fun buttonPressedChecker(button: Button) {
        if (isAppOn == false) {
            button.background = ContextCompat.getDrawable(this, R.drawable.wrong_option_border_bg)
            button.text = "Disable"
            isAppOn = true

        } else {
            button.background = ContextCompat.getDrawable(this, R.drawable.correct_option_border_bg)
            button.text = "Enabled"
            isAppOn = false

        }
    }
}