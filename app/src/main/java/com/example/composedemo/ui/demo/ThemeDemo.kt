package com.example.composedemo.ui.demo

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.composedemo.darkThemeState
import com.example.composedemo.themeTypeState
import com.example.composedemo.titleLiveData
import com.example.composedemo.ui.theme.ThemeType

@Composable
fun ThemePage() {
    titleLiveData.value = "Compose Theme"
    ThemeContent()
}

@Composable
fun ThemeContent() {
    Box(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        ThemeDemo()
    }
}

@Composable
fun ThemeDemo() {
    Column(verticalArrangement = Arrangement.spacedBy(15.dp)) {
        Spacer(modifier = Modifier.height(20.dp))
        Row {
            Text(text = "暗黑模式", color = MaterialTheme.colors.onSurface)
            Switch(checked = darkThemeState.value, onCheckedChange = {
                darkThemeState.value = it
            })
        }

        Spacer(modifier = Modifier.height(20.dp))

        RadioButton(themeTypeState.value == ThemeType.Default, "默认") {
            themeTypeState.value = ThemeType.Default
        }
        RadioButton(themeTypeState.value == ThemeType.Theme1, "主题1") {
            themeTypeState.value = ThemeType.Theme1
        }
        RadioButton(themeTypeState.value == ThemeType.Theme2, "主题2") {
            themeTypeState.value = ThemeType.Theme2
        }
        RadioButton(themeTypeState.value == ThemeType.Theme3, "主题3") {
            themeTypeState.value = ThemeType.Theme3
        }
        RadioButton(themeTypeState.value == ThemeType.Theme4, "主题4") {
            themeTypeState.value = ThemeType.Theme4
        }
        RadioButton(themeTypeState.value == ThemeType.Theme5, "主题5") {
            themeTypeState.value = ThemeType.Theme5
        }
    }
}


@Composable
fun RadioButton(isSelected: Boolean, text: String, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .clickable { onClick() }, verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(selected = isSelected, modifier = Modifier.size(30.dp), onClick = onClick)
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.CenterStart) {
            Text(text = text, color = MaterialTheme.colors.onSurface)
        }
    }
}
