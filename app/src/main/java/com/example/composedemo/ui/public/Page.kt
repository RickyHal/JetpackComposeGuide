package com.example.composedemo.ui.public

import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.composedemo.ui.theme.CustomThemeManager
import com.example.composedemo.ui.theme.ThemeType

@Composable
fun Page(
    title: String,
    themType: ThemeType,
    isDarkTheme: Boolean,
    leftIcon: ImageVector? = null,
    rightIcon: ImageVector? = null,
    onLeftClick: () -> Unit = {},
    onRightClick: () -> Unit = {}, content: @Composable () -> Unit,
) {
    CustomThemeManager.WithTheme(themType, isDarkTheme) {
        Surface(color = MaterialTheme.colors.background) {
            Column {
                AppBar(title = title, leftIcon, rightIcon, onLeftClick, onRightClick)
                content()
            }
        }
    }
}