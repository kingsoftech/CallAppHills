package com.flyconcept.callapphills.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.flyconcept.callapphills.DataList
import com.flyconcept.callapphills.model.Color
import kotlinx.coroutines.flow.Flow

@Dao
interface ColorDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertColor(color: Color)

    @Query("SELECT * FROM color ORDER BY ID")
    fun colorList(): Flow<List<Color>>

}