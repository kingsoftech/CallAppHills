package com.flyconcept.callapphills

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface DataListDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDataList(list: DataList)

    @Query("SELECT * FROM LIST_OF_COLORS ORDER BY ID")
    fun getAllDishesList(): Flow<List<DataList>>

    @Delete
    suspend fun deleteDataListDetails(list: DataList)
}