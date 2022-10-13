package com.harsh.expensetracker.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.harsh.expensetracker.model.Transaction

@Composable
fun TransactionCard(navController: NavController, transaction: Transaction) {
    Card(
        elevation = 10.dp, shape = RectangleShape, modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
            .clickable {
                navController.currentBackStackEntry?.savedStateHandle?.set("transaction",
                    transaction
                )
                navController.navigate(route = Screen.Detail.route)
            }
    ) {

        val textColor = TransactionItem.getTextColor(transaction.type)
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {

            Column {
                Text(text = transaction.title, style = MaterialTheme.typography.h5)
                Text(text = transaction.tag, style = MaterialTheme.typography.subtitle2)
            }

            Column {
                Text(
                    text = transaction.amount.toString(),
                    color = textColor,
                    style = MaterialTheme.typography.h6
                )
                Text(text = transaction.date, style = MaterialTheme.typography.subtitle2)
            }
        }
    }
}

