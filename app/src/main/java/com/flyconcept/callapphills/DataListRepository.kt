package com.flyconcept.callapphills

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class DataListRepository(private val dataListDao: DataListDao) {

    @WorkerThread
    suspend fun insertDataListDetails(dataList: DataList) {
        dataListDao.insertDataList(dataList)
    }

    val allDataList: Flow<List<DataList>> =dataListDao.getAllDishesList()

    @WorkerThread
    suspend fun removeList(dataList: DataList){
        dataListDao.deleteDataListDetails(dataList)
    }
}