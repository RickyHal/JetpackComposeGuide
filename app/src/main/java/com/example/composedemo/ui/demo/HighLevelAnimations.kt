package com.example.composedemo.ui.demo

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@ExperimentalAnimationApi
@Composable
fun AnimatedVisibilityDemo() {
    var visible by remember { mutableStateOf(false) }
    Spacer(modifier = Modifier.height(10.dp))
    Text("AnimatedVisibility:控制显示与隐藏")
    Row {
        Button(onClick = { visible = !visible }) {
            Text("AnimatedVisibility")
        }
        Text("isVisible=$visible")
    }
    androidx.compose.animation.AnimatedVisibility(
        visible = visible,
        modifier = Modifier.padding(10.dp)
    ) {
        Box(
            modifier = Modifier
                .background(MaterialTheme.colors.primary)
                .size(100.dp)
        )
    }
}

@Composable
fun AnimateContentSizeDemo() {
    var size by remember { mutableStateOf(100.dp) }
    Spacer(modifier = Modifier.height(10.dp))
    Text("AnimateContentSize:尺寸该变时添加动画过渡")
    Row {
        Button(onClick = { size = if (size == 100.dp) 150.dp else 100.dp }) {
            Text("AnimateContentSize")
        }
        Text("size=$size")
    }
    Spacer(modifier = Modifier.height(10.dp))
    Box(
        modifier = Modifier
            .background(MaterialTheme.colors.primary)
            .animateContentSize()
            .padding(10.dp)
            .size(size)
    )
}


@Composable
fun CrossfadeDemo() {
    var currentPage by remember { mutableStateOf("A") }
    Spacer(modifier = Modifier.height(10.dp))
    Text("Crossfade:多个页面切换时添加过渡效果")
    Row {
        Button(onClick = { currentPage = if (currentPage == "A") "B" else "A" }) {
            Text("Crossfade")
        }
        Text("currentPage=$currentPage")
    }
    Spacer(modifier = Modifier.height(10.dp))
    androidx.compose.animation.Crossfade(targetState = currentPage) { screen ->
        when (screen) {
            "A" -> {
                Box(
                    modifier = Modifier
                        .background(MaterialTheme.colors.primary)
                        .padding(10.dp)
                        .size(100.dp)
                )
            }
            "B" -> Box(
                modifier = Modifier
                    .background(MaterialTheme.colors.onBackground)
                    .padding(10.dp)
                    .size(100.dp)
            )
        }
    }
}