package com.harsh.expensetracker.model

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Transaction::class],
    version = 2,
    exportSchema = true,
    autoMigrations = [
        AutoMigration(from = 1, to = 2)
    ]
)

abstract class TransactionDB : RoomDatabase() {
    abstract val transactionDAO: TransactionDAO
}