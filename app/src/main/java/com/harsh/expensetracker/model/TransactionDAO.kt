package com.harsh.expensetracker.model

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TransactionDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTransaction(transaction: Transaction)

    @Query("Select * From Transactions order by `Transaction_ID` DESC")
    fun showAllTransactions(): Flow<List<Transaction>>

    @Query("Select * From Transactions Where type like 'Credit'")
    fun showCredits(): Flow<List<Transaction>>

    @Query("Select * From Transactions Where type like 'Debit'")
    fun showDebits(): Flow<List<Transaction>>

    @Query("Select Sum(Amount) From Transactions Where type like 'Credit'")
    fun sumOfCredits() : Flow<Int>

    @Query("Select Sum(Amount) From Transactions Where type like 'Debit'")
    fun sumOfDebits() : Flow<Int>

    @Update
    suspend fun updateTransaction(transaction: Transaction)

    @Delete
    suspend fun deleteTransaction(transaction: Transaction)
}

