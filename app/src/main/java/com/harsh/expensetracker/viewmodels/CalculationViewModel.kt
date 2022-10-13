package com.harsh.expensetracker.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.harsh.expensetracker.model.TransactionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CalculationViewModel @Inject constructor(
    private val transRepo: TransactionRepository,
) : ViewModel() {
    private val _stateCredit = mutableStateOf(CalculationState())
    val stateCredit = _stateCredit

    private val _stateDebit = mutableStateOf(CalculationState())
    val stateDebit = _stateDebit

    init {
        getCreditsSum()
        getDebitedSum()
    }

    private fun getCreditsSum() {
        transRepo.sumOfCredits().onEach {
            _stateCredit.value = CalculationState(it)
        }.launchIn(viewModelScope)
    }

    private fun getDebitedSum(){
        transRepo.sumOfDebits().onEach{
            _stateDebit.value = CalculationState(it)
        }.launchIn(viewModelScope)
    }
}