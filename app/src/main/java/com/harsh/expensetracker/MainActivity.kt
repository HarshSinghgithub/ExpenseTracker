package com.harsh.expensetracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.harsh.expensetracker.model.Transaction
import com.harsh.expensetracker.ui.theme.ExpenseTrackerTheme
import com.harsh.expensetracker.view.DashBoardScreen
import com.harsh.expensetracker.view.HomeScreen
import com.harsh.expensetracker.view.Navigation
import com.harsh.expensetracker.view.TransactionCard
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExpenseTrackerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    HomeScreen()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ExpenseTrackerTheme {
        val navController = rememberNavController()
        DashBoardScreen(
            navController = navController,
            viewModel1 = hiltViewModel(),
            viewModel2 = hiltViewModel()
        )
    }
}