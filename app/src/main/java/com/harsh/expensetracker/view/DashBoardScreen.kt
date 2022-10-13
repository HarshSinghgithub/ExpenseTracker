package com.harsh.expensetracker.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.harsh.expensetracker.viewmodels.CalculationViewModel
import com.harsh.expensetracker.viewmodels.GetTransactionViewModel

@Composable
fun DashBoardScreen(
    navController: NavController,
    viewModel1: GetTransactionViewModel,
    viewModel2: CalculationViewModel,
) {
    val state = viewModel1.state.value

    val debitedSum = viewModel2.stateDebit.value.sum
    val creditedSum = viewModel2.stateCredit.value.sum
    val currentIncome = creditedSum - debitedSum

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column {

            Card(modifier = Modifier.fillMaxWidth(), shape = RectangleShape) {
                Text(
                    text = currentIncome.toString(),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(30.dp)
                )
            }

            Spacer(modifier = Modifier.padding(3.dp))

            Row(modifier = Modifier.fillMaxWidth()) {
                Card(modifier = Modifier.fillMaxWidth(0.5f), shape = RectangleShape) {
                    Text(
                        text = creditedSum.toString(),
                        color = Color.Green,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(30.dp)
                    )
                }

                Spacer(modifier = Modifier.padding(3.dp))

                Card(modifier = Modifier.fillMaxWidth(), shape = RectangleShape) {
                    Text(
                        text = debitedSum.toString(),
                        color = Color.Red,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(30.dp)
                    )
                }
            }

            LazyColumn {
                items(state.list) { transaction ->
                    TransactionCard(transaction = transaction, navController = navController)
                }
            }

        }

        FloatingActionButton(
            onClick = { navController.navigate(Screen.AddTransaction.route) },
            modifier = Modifier.align(Alignment.BottomEnd).padding(bottom = 55.dp)
        ) {
            Icon(imageVector = Icons.Default.Add, contentDescription = null)
        }
    }
}




