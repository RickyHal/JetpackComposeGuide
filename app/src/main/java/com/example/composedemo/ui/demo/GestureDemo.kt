package com.example.composedemo.ui.demo

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.consumeAllChanges
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.example.composedemo.titleLiveData
import kotlin.math.roundToInt

@ExperimentalMaterialApi
@Composable
fun GesturePage() {
    titleLiveData.value = "Compose Gesture"
    GestureContent()
}

@ExperimentalMaterialApi
@Composable
fun GestureContent() {
    Box(modifier = Modifier.fillMaxSize()) {
        GestureDemo()
    }
}

@ExperimentalMaterialApi
@Composable
fun GestureDemo() {
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        ClickableDemo()
        DoubleClickableDemo()
        HorizontalDragDemo()
        VerticalDragDemo()
        DragDemo()
        TouchPositionDemo()
        SwipeableDemo()
        TransformableDemo()
    }
}

@Composable
fun ClickableDemo() {
    Spacer(modifier = Modifier.height(10.dp))
    Text("点击事件监听")
    var clickCount by remember { mutableStateOf(0) }
    Button(onClick = { clickCount++ }) {
        Text("Clicked $clickCount")
    }
}

@Composable
fun DoubleClickableDemo() {
    Spacer(modifier = Modifier.height(10.dp))
    Text("单击，双击，长按，按下事件监听")
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .size(100.dp)
            .background(MaterialTheme.colors.primary)
            .pointerInput(Unit) {
                detectTapGestures(
                    onPress = {
                        Toast
                            .makeText(context, "按下", Toast.LENGTH_SHORT)
                            .show()
                    },
                    onDoubleTap = {
                        Toast
                            .makeText(context, "双击", Toast.LENGTH_SHORT)
                            .show()
                    },
                    onLongPress = {
                        Toast
                            .makeText(context, "长按", Toast.LENGTH_SHORT)
                            .show()
                    },
                    onTap = {
                        Toast
                            .makeText(context, "单击", Toast.LENGTH_SHORT)
                            .show()
                    }
                )
            }) {
        Text("Clicked me", color = MaterialTheme.colors.onSurface)
    }
}

@Composable
fun TouchPositionDemo() {
    var touchedX by remember { mutableStateOf(0f) }
    var touchedY by remember { mutableStateOf(0f) }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .pointerInput(Unit) {
                detectDragGestures { change, dragAmount ->
                    change.consumeAllChanges()

                    touchedX = change.position.x
                    touchedY = change.position.y
                }
            }, contentAlignment = Alignment.Center
    ) {
        Column {
            Text(text = "这是一个监听触摸位置的组件")
            Text(text = "touchedX=${touchedX.toInt()}   touchedY=${touchedY.toInt()}")
        }
    }
}

@Composable
fun HorizontalDragDemo() {
    Text("水平拖动")
    var offsetX by remember { mutableStateOf(0f) }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .offset { IntOffset(offsetX.roundToInt(), 0) }
                .background(MaterialTheme.colors.primary)
                .draggable(
                    orientation = Orientation.Horizontal,
                    state = rememberDraggableState { delta ->
                        offsetX += delta
                    })
        )
    }
}

@Composable
fun VerticalDragDemo() {
    Text("垂直拖动")
    var offsetY by remember { mutableStateOf(0f) }
    Box(
        modifier = Modifier
            .width(100.dp)
            .height(500.dp),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .offset { IntOffset(0, offsetY.roundToInt()) }
                .background(MaterialTheme.colors.primary)
                .draggable(
                    orientation = Orientation.Vertical,
                    state = rememberDraggableState { delta ->
                        offsetY += delta
                    })
        )
    }
}


@Composable
fun DragDemo() {
    Text("任意拖动")
    var offsetX by remember { mutableStateOf(0f) }
    var offsetY by remember { mutableStateOf(0f) }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(500.dp),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .offset { IntOffset(offsetX.roundToInt(), offsetY.roundToInt()) }
                .background(MaterialTheme.colors.primary)
                .pointerInput(Unit) {
                    detectDragGestures { change, dragAmount ->
                        change.consumeAllChanges()
                        offsetX += dragAmount.x
                        offsetY += dragAmount.y
                    }
                }
        )
    }
}

@ExperimentalMaterialApi
@Composable
fun SwipeableDemo() {
    Text("Swipeable ")
    val width = 96.dp
    val squareSize = 48.dp

    val swipeableState = rememberSwipeableState(0)
    val sizePx = with(LocalDensity.current) { squareSize.toPx() }
    val anchors = mapOf(0f to 0, sizePx to 1) // Maps anchor points (in px) to states

    Box(
        modifier = Modifier
            .width(width)
            .swipeable(
                state = swipeableState,
                anchors = anchors,
                thresholds = { _, _ -> FractionalThreshold(0.3f) },
                orientation = Orientation.Horizontal
            )
            .background(MaterialTheme.colors.secondary)
    ) {
        Box(
            Modifier
                .offset { IntOffset(swipeableState.offset.value.roundToInt(), 0) }
                .size(squareSize)
                .background(MaterialTheme.colors.onBackground)
        )
    }
}

@Composable
fun TransformableDemo() {
    Text("缩放，平移，旋转 ")
    var scale by remember { mutableStateOf(1f) }
    var rotation by remember { mutableStateOf(0f) }
    var offset by remember { mutableStateOf(Offset.Zero) }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(500.dp),
        contentAlignment = Alignment.Center
    ) {
        Box(
            Modifier
                .graphicsLayer(
                    scaleX = scale,
                    scaleY = scale,
                    rotationZ = rotation,
                    translationX = offset.x,
                    translationY = offset.y
                )
                .pointerInput(Unit) {
                    detectTransformGestures { _, pan, zoom, rotationChanged ->
                        scale *= zoom
                        rotation += rotationChanged
                        offset += pan
                    }
                    detectDragGestures { change, dragAmount ->
                        change.consumeAllChanges()
                        offset = Offset(dragAmount.x, dragAmount.y)
                    }
                }
                .background(MaterialTheme.colors.primary)
                .size(100.dp)
        )
    }
}