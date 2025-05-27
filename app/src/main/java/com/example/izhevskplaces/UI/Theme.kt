package com.example.izhevskplaces.UI

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

// Зелёная цветовая схема
private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF4CAF50),        // Основной зелёный
    secondary = Color(0xFF81C784),      // Светло-зелёный
    tertiary = Color(0xFF2E7D32),       // Тёмно-зелёный
    surface = Color(0xFF1B1B1B),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onSurface = Color.White
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF4CAF50),        // Основной зелёный
    secondary = Color(0xFF81C784),      // Светло-зелёный
    tertiary = Color(0xFF2E7D32),       // Тёмно-зелёный
    surface = Color(0xFFF1F8E9),        // Очень светло-зелёный фон
    onPrimary = Color.White,
    onSecondary = Color.White,
    onSurface = Color(0xFF1B5E20)       // Тёмно-зелёный для текста
)

// Закруглённые формы
val Shapes = Shapes(
    extraSmall = RoundedCornerShape(8.dp),
    small = RoundedCornerShape(12.dp),
    medium = RoundedCornerShape(16.dp),
    large = RoundedCornerShape(20.dp),
    extraLarge = RoundedCornerShape(24.dp)
)

@Composable
fun IzhevskPlacesTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography(),
        shapes = Shapes,
        content = content
    )
}