package com.harsh.expensetracker.view

import android.app.DatePickerDialog
import android.util.Log
import android.widget.DatePicker
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.harsh.expensetracker.model.Transaction
import com.harsh.expensetracker.viewmodels.InsertTransactionViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.*
import javax.inject.Inject

@Composable
fun AddTransaction(navController: NavController, viewModel: InsertTransactionViewModel) {
    Column(modifier = Modifier.fillMaxWidth()) {
        val context = LocalContext.current
        var title by remember { mutableStateOf("") }
        var amount by remember { mutableStateOf("") }
        var time by remember { mutableStateOf(("")) }
        var type by remember { mutableStateOf("") }
        var tag by remember { mutableStateOf("") }
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
                    val transaction =
                        Transaction(0, title, amount.toInt(), date = time, type = type, tag = tag)
                    viewModel.addTransaction(transaction)
                    Toast.makeText(context, "Transaction Added", Toast.LENGTH_LONG).show()
                    navController.navigate(Screen.DashBoard.route)
                } else {
                    Toast.makeText(context, "Fill all details", Toast.LENGTH_LONG).show()
                }
            },
            modifier = Modifier.padding(start = 100.dp, top = 10.dp)
        ) {
            Text(text = "Add Transaction")
        }
    }
}

@Composable
fun dropDown(options: List<String>): String {
    var type by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }

    Column {
        OutlinedTextField(
            value = type,
            onValueChange = { type = it },
            trailingIcon = {
                IconButton(onClick = {
                    expanded = !expanded
                }) {
                    Icon(
                        imageVector = if (!expanded) Icons.Default.ArrowDropDown else Icons.Default.ArrowDropUp,
                        contentDescription = "null"
                    )
                }
            },
            label = { Text(text = "Type") },
            modifier = Modifier.fillMaxWidth()
        )

        if (expanded) {
            DropdownMenu(
                expanded = true,
                onDismissRequest = { expanded = !expanded },
                modifier = Modifier.fillMaxWidth()
            ) {
                options.forEach {
                    DropdownMenuItem(
                        onClick =
                        {
                            type = it
                            expanded = false
                        }, modifier = Modifier.align(Alignment.End)
                    ) {
                        Text(text = it)
                    }
                }
            }
        }
    }
    return type
}