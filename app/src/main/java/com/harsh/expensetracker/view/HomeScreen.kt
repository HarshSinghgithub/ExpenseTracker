package com.harsh.expensetracker.view

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(){
    val navController = rememberNavController()
    val list = listOf(
        BottomNavItem(icon = Icons.Default.Dashboard, name =  "DashBoard", route = "DashBoard"),
        BottomNavItem(icon = Icons.Default.AccountBox, name =  "Credits", route = "CreditTransaction"),
        BottomNavItem(icon = Icons.Default.AccountBox, name =  "Debits", route = "DebitTransaction")
    )
    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navController, list = list)
        }
    ) {
        Navigation(navController = navController)
    }
}