package com.flyconcept.callapphills

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "list_of_colors")
data class DataList(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo
    val listName: String = "",
    @ColumnInfo
    val song: String = "",
    @ColumnInfo
    val colorList: ArrayList<Color> = ArrayList()
)
