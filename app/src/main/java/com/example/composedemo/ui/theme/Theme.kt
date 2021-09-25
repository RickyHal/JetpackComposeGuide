package com.example.composedemo.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.composedemo.entities.WrappedColor


enum class ThemeType {
    Default,
    Theme1,
    Theme2,
    Theme3,
    Theme4,
    Theme5,
}

object CustomThemeManager {

    object Default {
        val darkColors = darkColors(
            primary = Default200,
            primaryVariant = Default700,
            secondary = DefaultSecondary,
            background = Color.Black,
            onPrimary = DefaultOnPrimary,
            surface = Color.Black,
        )

        val lightColors = lightColors(
            primary = Default500,
            primaryVariant = Default700,
            secondary = DefaultSecondary,
            background = Color.White,
            onPrimary = DefaultOnPrimary,
            surface = DefaultOnPrimary
        )
    }

    object Theme1 {
        val darkColors = darkColors(
            primary = Theme1_200,
            primaryVariant = Theme1_700,
            secondary = Theme1Secondary,
            background = Color.Black,
            onPrimary = Theme1OnPrimary,
            surface = Color.Black,
        )

        val lightColors = lightColors(
            primary = Theme1_500,
            primaryVariant = Theme1_700,
            secondary = Theme1Secondary,
            background = Color.White,
            onPrimary = Theme1OnPrimary,
            surface = Theme1OnPrimary
        )
    }

    object Theme2 {
        val darkColors = darkColors(
            primary = Theme2_200,
            primaryVariant = Theme2_700,
            secondary = Theme2Secondary,
            background = Color.Black,
            onPrimary = Theme2OnPrimary,
            surface = Color.Black,
        )

        val lightColors = lightColors(
            primary = Theme2_500,
            primaryVariant = Theme2_700,
            secondary = Theme2Secondary,
            background = Color.White,
            onPrimary = Theme2OnPrimary,
            surface = Theme2OnPrimary
        )
    }

    object Theme3 {
        val darkColors = darkColors(
            primary = Theme3_200,
            primaryVariant = Theme3_700,
            secondary = Theme3Secondary,
            background = Color.Black,
            onPrimary = Theme3OnPrimary,
            surface = Color.Black,
        )

        val lightColors = lightColors(
            primary = Theme3_500,
            primaryVariant = Theme3_700,
            secondary = Theme3Secondary,
            background = Color.White,
            onPrimary = Theme3OnPrimary,
            surface = Theme3OnPrimary
        )
    }

    object Theme4 {
        val darkColors = darkColors(
            primary = Theme4_200,
            primaryVariant = Theme4_700,
            secondary = Theme4Secondary,
            background = Color.Black,
            onPrimary = Theme4OnPrimary,
            surface = Color.Black,
        )

        val lightColors = lightColors(
            primary = Theme4_500,
            primaryVariant = Theme4_700,
            secondary = Theme4Secondary,
            background = Color.White,
            onPrimary = Theme4OnPrimary,
            surface = Theme4OnPrimary
        )
    }


    object Theme5 {
        val darkColors = darkColors(
            primary = Theme5_200,
            primaryVariant = Theme5_700,
            secondary = Theme5Secondary,
            background = Color.Black,
            onPrimary = Theme5OnPrimary,
            surface = Color.Black,
        )

        val lightColors = lightColors(
            primary = Theme5_500,
            primaryVariant = Theme5_700,
            secondary = Theme5Secondary,
            background = Color.White,
            onPrimary = Theme5OnPrimary,
            surface = Theme5OnPrimary
        )
    }


    @Composable
    fun WithTheme(
        type: ThemeType,
        darkTheme: Boolean = isSystemInDarkTheme(),
        content: @Composable () -> Unit
    ) {
        val wrappedColor = getWrappedColor(type)
        val colors = if (darkTheme) wrappedColor.darkColors else wrappedColor.lightColors
        MaterialTheme(
            colors = colors,
            typography = Typography,
            shapes = Shapes,
            content = content
        )
    }

    fun getWrappedColor(type: ThemeType): WrappedColor {
        val darkColors: Colors
        val lightColors: Colors
        when (type) {
            ThemeType.Default -> {
                darkColors = Default.darkColors
                lightColors = Default.lightColors
            }
            ThemeType.Theme1 -> {
                darkColors = Theme1.darkColors
                lightColors = Theme1.lightColors
            }
            ThemeType.Theme2 -> {
                darkColors = Theme2.darkColors
                lightColors = Theme2.lightColors
            }
            ThemeType.Theme3 -> {
                darkColors = Theme3.darkColors
                lightColors = Theme3.lightColors
            }
            ThemeType.Theme4 -> {
                darkColors = Theme4.darkColors
                lightColors = Theme4.lightColors
            }
            ThemeType.Theme5 -> {
                darkColors = Theme5.darkColors
                lightColors = Theme5.lightColors
            }
        }
        return WrappedColor(lightColors, darkColors)
    }
}