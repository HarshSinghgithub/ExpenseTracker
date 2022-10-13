package com.harsh.expensetracker.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.harsh.expensetracker.model.TransactionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class GetTransactionViewModel @Inject constructor(
    private val transactionRepo: TransactionRepository
) : ViewModel() {
    private val _state = mutableStateOf(TransactionState())
    val state = _state

    private val _state1 = mutableStateOf(TransactionState())
    val state1 = _state1

    private val _state2 = mutableStateOf(TransactionState())
    val state2 = _state2

    init {
        getAllTransactions()
        getCreditedTransaction()
        getDebitedTransaction()
    }

    private fun getAllTransactions() {
        transactionRepo.getAllTransactions().onEach {
            _state.value = TransactionState(it)
        }.launchIn(viewModelScope)
    }

    private fun getCreditedTransaction(){
        transactionRepo.getCreditsTransaction().onEach {
            _state1.value = TransactionState(list = it)
        }.launchIn(viewModelScope)
    }

    private fun getDebitedTransaction(){
        transactionRepo.getDebitsTransaction().onEach {
            _state2.value = TransactionState(list = it)
        }.launchIn(viewModelScope)
    }
}

