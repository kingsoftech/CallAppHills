package com.flyconcept.callapphills

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.flyconcept.callapphills.model.Color
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@Entity(tableName = "list_of_colors")
data class DataList(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo
    val listName: String = "",
    @ColumnInfo
    val song: String = "",
    @ColumnInfo
    val colorList: ArrayList<Color>
)

class ColorListArrayTypeConverter{

    @TypeConverter
    fun fromGroupTaskMemberList(value: ArrayList<Color>): String {
        val gson = Gson()
        val type = object : TypeToken<ArrayList<Color>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toGroupTaskMemberList(value: String): ArrayList<Color> {
        val gson = Gson()
        val type = object : TypeToken<ArrayList<Color>>() {}.type
        return gson.fromJson(value, type)
    }
//    @TypeConverter
//    fun fromString(value: String?): ArrayList<String>{
//        val listType = object :TypeToken<ArrayList<String>>(){
//        }.type
//            return  Gson().fromJson(value, listType)
//        }
//
//
//    @TypeConverter
//    fun fromArrayList(list:ArrayList<String>):String{
//    return Gson().toJson(list)
//    }
}
