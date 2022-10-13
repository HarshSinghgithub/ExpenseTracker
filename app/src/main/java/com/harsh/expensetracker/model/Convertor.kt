package com.harsh.expensetracker.model

import androidx.room.TypeConverter
import java.util.Date

class Convertor {
    // @TypeConverter
//    fun dateToLong(date: Date) : String?{
//        return date.toString()
//    }
    @TypeConverter
    fun fromTimestamp(value: Long?):
            java.sql.Date {
        return java.sql.Date(value ?: 0)
    }

    @TypeConverter
    fun dateToTimestamp(date: java.sql.Date?)
            : Long {
        return date?.time ?: 0
    }
}