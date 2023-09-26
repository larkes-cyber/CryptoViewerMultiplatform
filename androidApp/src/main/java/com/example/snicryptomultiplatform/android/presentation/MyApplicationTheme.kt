package com.example.snicryptomultiplatform.android.presentation

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.Typography
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


private val DarkColorPalette = Colors(
    background = Color(0xFF131316),
    primary = Color(0xFFEEEEEE),
    secondPrimary = Color(0xFF40BF6A),
    thirdPrimary = Color(0xFF575B66)
)


private val LightColorPalette = Colors(
    background = Color(0xFF131316),
    primary = Color(0xFFEEEEEE),
    secondPrimary = Color(0xFF40BF6A),
    thirdPrimary = Color(0xFF575B66)
)

data class Colors(
    val background: Color,
    val primary:Color,
    val secondPrimary:Color,
    val thirdPrimary:Color
)


@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalColorProvider provides LightColorPalette
    ) {
        content()
    }
}



object AppTheme {
    val colors: Colors
        @Composable
        @ReadOnlyComposable
        get() = LocalColorProvider.current
}

val LocalColorProvider = staticCompositionLocalOf<Colors> {
    error("fddfdd")
}