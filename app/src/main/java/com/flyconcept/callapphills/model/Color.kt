package com.flyconcept.callapphills.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Color")
data class Color(
    @ColumnInfo
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo
    val color: Color,
    @ColumnInfo
    val colorName:String
)
