package com.harsh.expensetracker.viewmodels

import com.harsh.expensetracker.model.Transaction

data class TransactionState(
    val list: List<Transaction> = emptyList()
)
