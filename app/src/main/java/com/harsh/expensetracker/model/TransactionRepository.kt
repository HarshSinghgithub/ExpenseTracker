package com.harsh.expensetracker.model

import kotlinx.coroutines.flow.Flow

class TransactionRepository(private val transactionDAO: TransactionDAO) {
    fun getAllTransactions(): kotlinx.coroutines.flow.Flow<List<Transaction>> {
        return transactionDAO.showAllTransactions()
    }

    fun getCreditsTransaction(): kotlinx.coroutines.flow.Flow<List<Transaction>> {
        return transactionDAO.showCredits()
    }

    fun getDebitsTransaction(): kotlinx.coroutines.flow.Flow<List<Transaction>> {
        return transactionDAO.showDebits()
    }

    fun sumOfCredits(): Flow<Int> {
        return transactionDAO.sumOfCredits()
    }

    fun sumOfDebits(): Flow<Int> {
        return transactionDAO.sumOfDebits()
    }

    suspend fun insertTransaction(transaction: Transaction) {
        return transactionDAO.addTransaction(transaction)
    }

    suspend fun updateTransaction(transaction: Transaction){
        return transactionDAO.updateTransaction(transaction)
    }

    suspend fun deleteTransaction(transaction: Transaction) {
        return transactionDAO.deleteTransaction(transaction)
    }
}