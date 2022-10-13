package com.harsh.expensetracker.view

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.harsh.expensetracker.model.Transaction

@Composable
fun Navigation(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Screen.DashBoard.route) {
        composable(route = Screen.DashBoard.route) {
            DashBoardScreen(
                navController = navController,
                viewModel1 = hiltViewModel(),
                viewModel2 = hiltViewModel(),
            )
        }

        composable(route = Screen.AddTransaction.route) {
            AddTransaction(navController = navController, viewModel = hiltViewModel())
        }

        composable(route = Screen.CreditTransaction.route) {
            CreditTransactionScreen(viewModel = hiltViewModel(), navController = navController)
        }

        composable(route = Screen.DebitTransaction.route) {
            DebitTransactionScreen(viewModel = hiltViewModel(), navController = navController)
        }

        composable(route = Screen.Detail.route) {
            val transaction = navController.previousBackStackEntry?.savedStateHandle?.get<Transaction>("transaction")
            if(transaction != null){
                DetailScreen(transaction = transaction, navController = navController, viewModel = hiltViewModel())
            }
        }

        composable(route = Screen.Edit.route){
            EditScreen(viewModel = hiltViewModel(), navController = navController)
        }
    }
}