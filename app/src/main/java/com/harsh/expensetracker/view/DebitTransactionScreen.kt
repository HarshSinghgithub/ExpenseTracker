package com.harsh.expensetracker.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.harsh.expensetracker.viewmodels.GetTransactionViewModel

@Composable
fun DebitTransactionScreen(viewModel: GetTransactionViewModel, navController: NavController) {
    val state = viewModel.state2.value
    val list = state.list

    Column {
        Text(text = "All Expenses")

        LazyColumn {
            items(list) { transaction ->
                TransactionCard(transaction = transaction, navController = navController)
            }
        }
    }
}