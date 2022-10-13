package com.harsh.expensetracker.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.harsh.expensetracker.model.Transaction
import com.harsh.expensetracker.viewmodels.DeleteViewModel

@Composable
fun DetailScreen(transaction: Transaction, navController: NavController, viewModel: DeleteViewModel) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column {
            Row {
                Text(
                    text = "Title :",
                    style = MaterialTheme.typography.subtitle2,
                    modifier = Modifier.padding(5.dp)
                )
                Spacer(modifier = Modifier.padding(5.dp))
                Text(text = transaction.title, style = MaterialTheme.typography.h6)
            }

            Row {
                Text(
                    text = "Amount :",
                    style = MaterialTheme.typography.subtitle2,
                    modifier = Modifier.padding(5.dp)
                )
                Spacer(modifier = Modifier.padding(5.dp))
                Text(text = transaction.amount.toString(), style = MaterialTheme.typography.h6)
            }

            Row {
                Text(
                    text = "Transaction type :",
                    style = MaterialTheme.typography.subtitle2,
                    modifier = Modifier.padding(5.dp)
                )
                Spacer(modifier = Modifier.padding(5.dp))
                Text(text = transaction.type, style = MaterialTheme.typography.h6)
            }

            Row {
                Text(
                    text = "Tag :",
                    style = MaterialTheme.typography.subtitle2,
                    modifier = Modifier.padding(5.dp)
                )
                Spacer(modifier = Modifier.padding(5.dp))
                Text(text = transaction.tag, style = MaterialTheme.typography.h6)
            }

            Row {
                Text(
                    text = "When :",
                    style = MaterialTheme.typography.subtitle2,
                    modifier = Modifier.padding(5.dp)
                )
                Spacer(modifier = Modifier.padding(5.dp))
                Text(text = transaction.date, style = MaterialTheme.typography.h6)
            }
        }

        FloatingActionButton(onClick = {
            navController.currentBackStackEntry?.savedStateHandle?.set("transaction", transaction)
            navController.navigate(Screen.Edit.route)
        },
        modifier = Modifier.align(Alignment.BottomEnd).
        padding(bottom = 55.dp)) {
            Icon(imageVector = Icons.Default.Edit, contentDescription = null)
        }

        FloatingActionButton(onClick = {
            viewModel.deleteTransaction(transaction)
            navController.navigate(Screen.DashBoard.route)
        },
        modifier = Modifier.align(Alignment.BottomStart).
        padding(bottom = 55.dp)) {
            Icon(imageVector = Icons.Default.Delete, contentDescription = null)
        }
    }
}