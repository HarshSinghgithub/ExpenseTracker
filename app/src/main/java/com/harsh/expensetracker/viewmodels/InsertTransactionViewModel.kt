package com.harsh.expensetracker.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.harsh.expensetracker.model.Transaction
import com.harsh.expensetracker.model.TransactionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InsertTransactionViewModel @Inject constructor(
    private val transactionRepo: TransactionRepository
) : ViewModel() {

    fun addTransaction(transaction: Transaction) {
        viewModelScope.launch(Dispatchers.IO) {
            transactionRepo.insertTransaction(transaction)
        }
    }
}