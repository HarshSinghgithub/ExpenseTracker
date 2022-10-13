package com.harsh.expensetracker.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.harsh.expensetracker.model.Transaction
import com.harsh.expensetracker.model.TransactionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditViewModel @Inject constructor(
    private val transRepo : TransactionRepository
) : ViewModel() {

    fun editTransaction(transaction: Transaction){
        viewModelScope.launch{
            transRepo.updateTransaction(transaction)
        }
    }
}