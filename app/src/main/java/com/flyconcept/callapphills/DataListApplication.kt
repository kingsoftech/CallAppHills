package com.flyconcept.callapphills

import android.app.Application

class DataListApplication:Application(){
    private val database by lazy { DataListDatabase.getDatabase(this@DataListApplication) }

    // A variable for repository.
    val repository by lazy { DataListRepository(database.DataListDao()) }
}