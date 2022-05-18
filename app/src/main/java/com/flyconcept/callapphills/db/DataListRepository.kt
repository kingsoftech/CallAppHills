package com.flyconcept.callapphills.db

import androidx.annotation.WorkerThread
import com.flyconcept.callapphills.DataList
import kotlinx.coroutines.flow.Flow

class DataListRepository(private val dataListDao: DataListDao) {

    @WorkerThread
    suspend fun insertDataListDetails(dataList: DataList) {
        dataListDao.insertDataList(dataList)
    }

    val allDataList: Flow<List<DataList>> =dataListDao.getAllDishesList()
    fun filteredListM( value:String):Flow<List<DataList>> =dataListDao.getColorList(value)
    @WorkerThread
    suspend fun removeList(dataList: DataList){
        dataListDao.deleteDataListDetails(dataList)
    }

}