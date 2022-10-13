package com.harsh.expensetracker.view

sealed class Screen(val route : String){
    object DashBoard : Screen("DashBoard")
    object CreditTransaction : Screen("CreditTransaction")
    object DebitTransaction : Screen("DebitTransaction")
    object AddTransaction : Screen("AddTransaction")
    object Detail : Screen("Detail")
    object Edit : Screen("Edit")
}
