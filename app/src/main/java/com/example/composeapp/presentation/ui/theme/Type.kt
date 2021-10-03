package com.example.composeapp.presentation.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.sp
import com.example.composeapp.R

private val Lato = FontFamily(
    Font(R.font.lato_regular)
)

val LatoTypography = Typography(
    h1 = TextStyle(
        fontFamily = Lato,
        fontWeight = Bold,
        fontSize = 35.sp,
        color = Gold
    ),
    h2 = TextStyle(
        fontFamily = Lato,
        fontWeight = Bold,
        fontSize = 20.sp,
        color = Gold
    ),
    body1 = TextStyle(
        fontFamily = Lato,
        fontSize = 14.sp,
    )
)
