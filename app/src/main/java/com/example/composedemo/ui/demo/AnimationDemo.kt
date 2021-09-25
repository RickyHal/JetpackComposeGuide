package com.example.composedemo.ui.demo

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.composedemo.titleLiveData

@ExperimentalAnimationApi
@Composable
fun AnimationPage() {
    titleLiveData.value = "Compose Animation"
    AnimationContent()
}

@ExperimentalAnimationApi
@Composable
fun AnimationContent() {
    Box(modifier = Modifier.fillMaxSize()) {
        AnimationDemo()
    }
}

@ExperimentalAnimationApi
@Composable
fun AnimationDemo() {
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        HighLevelAnimation()
        LowLevelAnimation()
    }
}

@ExperimentalAnimationApi
@Composable
fun HighLevelAnimation() {
    Spacer(modifier = Modifier.height(20.dp))
    Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
        Text("--------高级别动画API-------")
    }

    AnimatedVisibilityDemo()
    AnimateContentSizeDemo()
    CrossfadeDemo()
}

@Composable
fun LowLevelAnimation() {
    Spacer(modifier = Modifier.height(20.dp))
    Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
        Text("--------低级别动画API-------")
    }

    AnimateFloatAsStateDemo()
    AnimatableDemo()
    UpdateTransitionDemo()
    RememberInfiniteTransitionDemo()
    SpringDemo()
    TweenDemo()

    Spacer(modifier = Modifier.height(100.dp))
}