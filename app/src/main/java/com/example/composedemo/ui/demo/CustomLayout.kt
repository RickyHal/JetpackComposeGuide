package com.example.composedemo.ui.demo

import android.graphics.Point
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.MeasurePolicy
import androidx.compose.ui.layout.layout
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.offset
import com.example.composedemo.titleLiveData

@Composable
fun CustomLayoutPage() {
    titleLiveData.value = "Compose Custom Layout"
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CustomLayoutContent()
    }
}

@Composable
fun CustomLayoutContent() {
    var start by remember { mutableStateOf(10) }
    var top by remember { mutableStateOf(10) }
    var end by remember { mutableStateOf(10) }
    var bottom by remember { mutableStateOf(10) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Text("这是一个自定义的FlowBox布局，一行内容放不下了会自动换行")
        Text("不信试试改变按钮上下左右的间距试试")
        OutlinedTextField(
            value = if (start != 0) start.toString() else "",
            onValueChange = { start = if (it.isNotEmpty()) it.toInt() else 0 },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            label = { Text("start(dp)") })
        OutlinedTextField(
            value = if (top != 0) top.toString() else "",
            onValueChange = { top = if (it.isNotEmpty()) it.toInt() else 0 },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            label = { Text("top(dp)") })
        OutlinedTextField(
            value = if (end != 0) end.toString() else "",
            onValueChange = { end = if (it.isNotEmpty()) it.toInt() else 0 },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            label = { Text("end(dp)") })
        OutlinedTextField(
            value = if (bottom != 0) bottom.toString() else "",
            onValueChange = { bottom = if (it.isNotEmpty()) it.toInt() else 0 },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            label = { Text("bottom(dp)") })
        CustomLayoutDemo(
            modifier = Modifier.background(Color.Red),
            itemGap = FlowBoxGap(start.dp, top.dp, end.dp, bottom.dp)
        ) {
            Button(onClick = { }) { Text("1111") }
            Button(onClick = { }) { Text("222") }
            Button(onClick = { }) { Text("33333") }
            Button(onClick = { }) { Text("444") }
            Button(onClick = { }) { Text("5555") }
            Button(onClick = { }) { Text("666666") }
            Button(onClick = { }) { Text("77777777") }
            Button(onClick = { }) { Text("88") }
            Button(onClick = { }) { Text("9999999") }
        }

        Spacer(modifier = Modifier.height(50.dp))
        var paddingHorizontal by remember { mutableStateOf(10) }
        Row(
            Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.primary)
        ) {
            Text(
                "这是使用自定义修饰符实现的paddingHorizontal效果，试试改变下padding值吧",
                modifier = Modifier
                    .paddingHorizontal(paddingHorizontal.dp)
                    .background(Color.Red)
            )
        }
        OutlinedTextField(
            value = if (paddingHorizontal != 0) paddingHorizontal.toString() else "",
            onValueChange = {
                paddingHorizontal = if (it.isNotEmpty()) it.toInt() else 0
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            label = { Text("paddingHorizontal(dp)") })
    }
}

@Composable
fun CustomLayoutDemo(
    modifier: Modifier = Modifier,
    itemGap: FlowBoxGap = DefaultFlowBoxGap,
    content: @Composable () -> Unit
) {
    Layout(
        content = content,
        measurePolicy = flowBoxMeasurePolicy(itemGap),
        modifier = modifier
    )
}

fun flowBoxMeasurePolicy(itemGap: FlowBoxGap) = MeasurePolicy { measurables, constraints ->
    val placeables = measurables.map { placeable ->
        placeable.measure(constraints = constraints)
    }

    val positions = arrayListOf<Point>()
    var xPosition = 0
    var yPosition = 0
    var currentLineMaxHeight = 0
    placeables.forEach { placeable ->
        val horizontalGap = itemGap.start.roundToPx() + itemGap.end.roundToPx()
        val verticalGap = itemGap.top.roundToPx() + itemGap.bottom.roundToPx()
        if (placeable.width + horizontalGap + xPosition > constraints.maxWidth) {
            xPosition = 0
            yPosition += currentLineMaxHeight
        }

        positions.add(
            Point(
                xPosition + itemGap.start.roundToPx(),
                yPosition + itemGap.top.roundToPx()
            )
        )
        xPosition += placeable.width + horizontalGap
        currentLineMaxHeight = currentLineMaxHeight.coerceAtLeast(placeable.height + verticalGap)
    }
    val height = yPosition + currentLineMaxHeight

    layout(constraints.maxWidth, height) {
        positions.zip(placeables).forEach { (position, placeable) ->
            placeable.placeRelative(position.x, position.y)
        }
    }
}

val DefaultFlowBoxGap = FlowBoxGap(0.dp)

data class FlowBoxGap(val start: Dp, val top: Dp, val end: Dp, val bottom: Dp) {
    constructor(gap: Dp) : this(gap, gap, gap, gap)
}

fun Modifier.paddingHorizontal(padding: Dp) = layout { measurable, constraints ->
    val placeable = measurable.measure(constraints.offset(-padding.roundToPx() * 2, 0))
    layout(placeable.width, placeable.height) {
        placeable.placeRelative(padding.roundToPx(), 0)
    }
}