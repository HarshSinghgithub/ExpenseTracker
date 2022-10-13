package com.harsh.expensetracker.view

import androidx.compose.foundation.layout.Column
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigationBar(navController: NavController, list: List<BottomNavItem>) {
    val navBackStackEntry = navController.currentBackStackEntryAsState()
    BottomNavigation {
        list.forEach {
            val selected = it.route == navBackStackEntry.value?.destination?.route
            BottomNavigationItem(selected = selected,
                onClick = { navController.navigate(it.route) },
                selectedContentColor = Color.Green,
                unselectedContentColor = Color.Gray,
                icon = {
                    Column(horizontalAlignment = CenterHorizontally) {
                        Icon(imageVector = it.icon, contentDescription = null)
                        Text(text = it.name, fontSize = 10.sp)
                    }

                })
        }
    }
}