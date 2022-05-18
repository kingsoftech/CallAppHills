package com.flyconcept.callapphills.applications

import android.app.Application
import com.flyconcept.callapphills.db.ColorDatabase
import com.flyconcept.callapphills.db.ColorRepository
import com.flyconcept.callapphills.db.DataListDatabase
import com.flyconcept.callapphills.db.DataListRepository

class DataListApplication:Application(){
    private val database by lazy { DataListDatabase.getDatabase(this@DataListApplication) }
    private val database1 by lazy{ColorDatabase.getDatabase(this@DataListApplication)}
    // A variable for repository.
    val repository by lazy { DataListRepository(database.DataListDao()) }

    val repository1 by lazy{ ColorRepository(database1.colorDao())}
}