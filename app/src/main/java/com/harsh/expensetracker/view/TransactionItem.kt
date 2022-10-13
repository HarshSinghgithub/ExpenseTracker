package com.harsh.expensetracker.view

import androidx.compose.ui.graphics.Color
import com.harsh.expensetracker.R

class TransactionItem {
    companion object {
        fun getImage(icon: String) : Int {
            var img = when (icon) {
                "Income" -> R.drawable.income_icon
                "Travel" -> R.drawable.travel_icon
                "Personal" -> R.drawable.personal_icon
                "Food" -> R.drawable.food_icon
                "Bill" -> R.drawable.bill_icon
                else -> R.drawable.bill_icon
            }
            return img
        }

        fun getTextColor(type : String): Color {
            val color = when(type){
                "Credit" -> Color.Green
                else -> Color.Red
            }
            return color
        }
    }
}