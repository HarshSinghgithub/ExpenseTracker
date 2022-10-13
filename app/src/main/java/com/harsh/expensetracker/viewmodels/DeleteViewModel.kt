package com.harsh.expensetracker.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.harsh.expensetracker.model.Transaction
import com.harsh.expensetracker.model.TransactionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DeleteViewModel @Inject constructor(
    private val transRepo : TransactionRepository
) : ViewModel() {

    fun deleteTransaction(transaction: Transaction){
        viewModelScope.launch {
            transRepo.deleteTransaction(transaction)
        }
    }
}