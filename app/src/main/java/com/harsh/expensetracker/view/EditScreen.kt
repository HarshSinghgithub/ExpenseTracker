package com.harsh.expensetracker.view

import android.app.DatePickerDialog
import android.widget.DatePicker
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.harsh.expensetracker.model.Transaction
import com.harsh.expensetracker.viewmodels.EditViewModel
import java.util.*

@Composable
fun EditScreen(viewModel: EditViewModel, navController: NavController) {

    val transaction =
        navController.previousBackStackEntry?.savedStateHandle?.get<Transaction>("transaction")

    if (transaction != null) {

        Column(modifier = Modifier.fillMaxWidth()) {
            val context = LocalContext.current
            var title by remember { mutableStateOf(transaction.title) }
            var amount by remember { mutableStateOf(transaction.amount.toString()) }
            var time by remember { mutableStateOf((transaction.date)) }
            var type by remember { mutableStateOf(transaction.type) }
            var tag by remember { mutableStateOf(transaction.tag) }
            val typeList = listOf("Credit", "Debit")
            val tagList = listOf("Personal", "Travel", "Bills", "Foods and drinks", "Income")

            OutlinedTextField(
                value = title,
                onValueChange = { newTitle -> title = newTitle },
                label = {
                    Text(text = "Title")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text
                )
            )

            OutlinedTextField(
                value = amount,
                onValueChange = { newAmount -> amount = newAmount },
                label = {
                    Text(text = "Amount")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                )
            )

            OutlinedTextField(
                value = time,
                onValueChange = { newTime -> time = newTime },
                label = {
                    Text(text = "When")
                },
                trailingIcon = {
                    IconButton(onClick = {
                        val calendar = Calendar.getInstance()

                        val mYear = calendar.get(Calendar.YEAR)
                        val mMonth = calendar.get(Calendar.MONTH)
                        val mDay = calendar.get(Calendar.DAY_OF_MONTH)
                        calendar.time = Date()

                        val datePickerDialog =
                            DatePickerDialog(context, { _: DatePicker, Year, Month, Day ->
                                time = "$Day/$Month/$Year"
                            }, mYear, mMonth, mDay)

                        datePickerDialog.show()
                    }) {
                        Icon(imageVector = Icons.Default.CalendarMonth, contentDescription = null)
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                )
            )

            type = dropDown(typeList)
            tag = dropDown(tagList)

            Button(
                onClick = {
                    if (title != "" && amount != "" && time != "" && type != "" && tag != "") {
                        val transaction1 =
                            Transaction(
                                transaction.ID,
                                title,
                                amount.toInt(),
                                date = time,
                                type = type,
                                tag = tag
                            )
                        viewModel.editTransaction(transaction1)
                        navController.navigate(Screen.DashBoard.route)
                    } else {
                        Toast.makeText(context, "Fill all details", Toast.LENGTH_LONG).show()
                    }
                },
                modifier = Modifier.padding(start = 100.dp, top = 10.dp)
            ) {
                Text(text = "Edit Transaction")
            }
        }
    }
}
