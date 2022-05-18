package com.flyconcept.callapphills.db

import androidx.annotation.WorkerThread
import com.flyconcept.callapphills.model.Color
import kotlinx.coroutines.flow.Flow

class ColorRepository(private val colorDao:ColorDao) {

    @WorkerThread
    suspend fun insertDataListDetails(color: Color) {
        colorDao.insertColor(color)
    }

    val allColors: Flow<List<Color>> =colorDao.colorList()
}