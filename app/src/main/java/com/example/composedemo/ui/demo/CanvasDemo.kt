package com.example.composedemo.ui.demo

import android.graphics.BitmapFactory
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.composedemo.R
import com.example.composedemo.titleLiveData

@Composable
fun CanvasPage() {
    titleLiveData.value = "Compose Canvas"
    CanvasContent()
}

@Composable
fun CanvasContent() {
    Box(modifier = Modifier.fillMaxSize()) {
        CanvasDemo()
    }
}

@Composable
fun CanvasDemo() {
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        val color = MaterialTheme.colors.onBackground
        CanvasLineDemo(color)
        CanvasDashLineDemo(color)
        CanvasRoundLineDemo(color)
        CanvasRectDemo(color)
        CanvasCirCleDemo(color)
        CanvasPathDemo(color)
        CanvasArcDemo(color)
        CanvasSectorDemo(color)
        CanvasOvalDemo(color)
        CanvasRoundRectDemo(color)
        CanvasCurveDemo(color)
        CanvasRotateDemo(color)
        CanvasRotateTransitionDemo(color)
        CanvasBitmapDemo(color)
        AndroidCanvasDemo(color)
        Spacer(modifier = Modifier.height(100.dp))
    }
}

@Composable
fun CanvasLineDemo(color: Color) {
    Text("实线")
    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .padding(30.dp, 0.dp)
            .height(30.dp)
    ) {
        drawLine(color, Offset(0f, 20f), Offset(400f, 20f), strokeWidth = 5f)
    }
    Spacer(modifier = Modifier.height(10.dp))
}

@Composable
fun CanvasDashLineDemo(color: Color) {
    Text("虚线")
    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .padding(30.dp, 0.dp)
            .height(30.dp)
    ) {
        drawLine(
            color, Offset(0f, 20f), Offset(400f, 20f), strokeWidth = 5f,
            pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 20f), 5f)
        )
    }
    Spacer(modifier = Modifier.height(10.dp))
}

@Composable
fun CanvasRoundLineDemo(color: Color) {
    Text("端点圆滑")
    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(30.dp)
            .padding(30.dp, 0.dp)
    ) {
        drawLine(
            color, Offset(0f, 20f), Offset(400f, 20f), strokeWidth = 15f,
            cap = StrokeCap.Round
        )
    }
    Spacer(modifier = Modifier.height(10.dp))
}

@Composable
fun CanvasRectDemo(color: Color) {
    Text("矩形")
    Canvas(modifier = Modifier.size(100.dp)) {
        drawRect(color = color, size = size / 2f)
    }
    Spacer(modifier = Modifier.height(10.dp))
}

@Composable
fun CanvasCirCleDemo(color: Color) {
    Text("圆")
    Canvas(
        modifier = Modifier
            .size(100.dp)
    ) {
        drawCircle(color = color)
    }
    Spacer(modifier = Modifier.height(10.dp))
}

@Composable
fun CanvasPathDemo(color: Color) {
    Text("Path")
    Canvas(
        modifier = Modifier
            .height(100.dp)
            .fillMaxWidth()
    ) {
        val path = Path()
        path.lineTo(200f, 0f)
        path.lineTo(100f, 40f)
        path.lineTo(180f, 20f)
        path.lineTo(180f, 100f)
        drawPath(path, color, style = Stroke(5f))
    }
    Spacer(modifier = Modifier.height(10.dp))
}

@Composable
fun CanvasArcDemo(color: Color) {
    Text("圆弧")
    Canvas(
        modifier = Modifier
            .size(100.dp)
    ) {
        drawArc(color, 0f, -135f, false, style = Stroke(5f))
    }
    Spacer(modifier = Modifier.height(10.dp))
}

@Composable
fun CanvasSectorDemo(color: Color) {
    Text("扇形")
    Canvas(
        modifier = Modifier
            .size(100.dp)
    ) {
        drawArc(color, 0f, -135f, true, style = Stroke(5f))
    }
    Spacer(modifier = Modifier.height(10.dp))
}

@Composable
fun CanvasOvalDemo(color: Color) {
    Text("椭圆")
    Canvas(modifier = Modifier.size(120.dp, 100.dp)) {
        drawOval(color)
    }
    Spacer(modifier = Modifier.height(10.dp))
}

@Composable
fun CanvasRoundRectDemo(color: Color) {
    Text("圆角矩形")
    Canvas(
        modifier = Modifier
            .size(120.dp, 100.dp)
            .padding(10.dp)
    ) {
        drawRoundRect(color, cornerRadius = CornerRadius(10f))
    }
    Spacer(modifier = Modifier.height(10.dp))
}

@Composable
fun CanvasCurveDemo(color: Color) {
    Text("贝塞尔曲线")
    Canvas(
        modifier = Modifier
            .height(100.dp)
            .fillMaxWidth()
    ) {
        val path = Path()
        path.cubicTo(0f, 100f, 100f, 0f, 200f, 100f)
        drawPath(path, color, style = Stroke(5f))
    }
    Spacer(modifier = Modifier.height(10.dp))
}

@Composable
fun CanvasRotateDemo(color: Color) {
    Text("旋转")
    Canvas(
        modifier = Modifier
            .size(100.dp)
    ) {
        rotate(45f) {
            drawRect(
                color = color,
                topLeft = Offset(100f, 100f),
                size = size / 2f
            )
        }
    }
    Spacer(modifier = Modifier.height(10.dp))
}

@Composable
fun CanvasRotateTransitionDemo(color: Color) {
    Text("旋转加位移")
    Canvas(
        modifier = Modifier
            .size(100.dp)
    ) {
        withTransform({
            translate(300f)
            rotate(45f)
        }) {
            drawRect(
                color = color,
                topLeft = Offset(0f, 100f),
                size = size / 2f
            )
        }
    }
    Spacer(modifier = Modifier.height(10.dp))
}

@Composable
fun CanvasBitmapDemo(color: Color) {
    Text("Bitmap")
    val context = LocalContext.current
    Canvas(
        modifier = Modifier
            .size(100.dp)
    ) {
        val bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.logo)
        drawImage(bitmap.asImageBitmap())
    }
    Spacer(modifier = Modifier.height(60.dp))
}

@Composable
fun AndroidCanvasDemo(color: Color) {
    Text("Android Canvas")
    Canvas(
        modifier = Modifier
            .size(100.dp)
    ) {
        drawIntoCanvas { canvas ->
            val paint = Paint()
            paint.color = color
            canvas.drawOval(0f, 0f, 100f, 100f, paint)
        }
    }
    Spacer(modifier = Modifier.height(10.dp))
}
