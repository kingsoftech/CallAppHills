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
        val data1 = DataList(1, "ListA", "Play me")
        dataList.add(data1)
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