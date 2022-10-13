package com.harsh.expensetracker.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "Transactions")
@Parcelize
data class Transaction(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Transaction_ID")
    val ID : Int,
    @ColumnInfo(name = "Title")
    val title : String,
    @ColumnInfo(name = "Amount")
    val amount : Int,
    @ColumnInfo(name = "Type")
    val type : String,
    @ColumnInfo(name = "Date")
    val date : String,
    @ColumnInfo(name = "Tag", defaultValue = "Income")
    val tag : String
) : Parcelable
