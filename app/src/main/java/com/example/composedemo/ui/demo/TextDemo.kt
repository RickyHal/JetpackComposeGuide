package com.example.composedemo.ui.demo

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composedemo.R
import com.example.composedemo.titleLiveData


@ExperimentalTextApi
@Composable
fun TextPage() {
    TextContent()
}

@ExperimentalTextApi
@Composable
fun TextContent() {
    titleLiveData.value = "Compose Text"
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
        ) {
            TextDemo()
        }
    }
}

@ExperimentalTextApi
@Composable
fun TextDemo() {
    Text(text = "Hello World")
    Text(text = stringResource(id = R.string.text))
    Text(text = "改个颜色试试", color = MaterialTheme.colors.primary)
    Text(text = "调整下大小", fontSize = 30.sp)
    Text("斜体", fontStyle = FontStyle.Italic)
    Text(text = "粗体", fontWeight = FontWeight.Bold)
    Text(text = "水平左对齐", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Start)
    Text(text = "水平居中对齐", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
    Text(text = "水平右对齐", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.End)
    Box(
        contentAlignment = Alignment.TopCenter,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(MaterialTheme.colors.primary)
    ) {
        Text(text = "垂直居上对齐", color = MaterialTheme.colors.onPrimary)
    }
    Spacer(modifier = Modifier.height(10.dp))
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(MaterialTheme.colors.primary)
    ) {
        Text(text = "垂直居中对齐", color = MaterialTheme.colors.onPrimary)
    }
    Spacer(modifier = Modifier.height(10.dp))
    Box(
        contentAlignment = Alignment.BottomCenter,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(MaterialTheme.colors.primary)
    ) {
        Text(text = "垂直居下对齐", color = MaterialTheme.colors.onPrimary)
    }
    Spacer(modifier = Modifier.height(10.dp))
    Text(text = "改个字体", fontFamily = FontFamily.Serif)
    Text(
        text = "加载Assets中的字体",
        fontFamily = FontFamily(Font(LocalContext.current.assets, "YouRan.ttf"))
    )
    Spacer(modifier = Modifier.height(10.dp))
    Text(text = "⬇️⬇️⬇️富文本⬇️⬇️⬇️")
    Text(buildAnnotatedString {
        withStyle(style = SpanStyle(MaterialTheme.colors.primary)) {
            append("试试富文本")
        }
        append("He")
        withStyle(style = SpanStyle(MaterialTheme.colors.secondary)) {
            append("ll")
        }
        append("o World")
        append("富文本")
        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
            append("富文本加个粗")
        }
    })
    Text(text = "⬆⬆⬆️富文本⬆️⬆⬆")
    Spacer(modifier = Modifier.height(10.dp))
    Text(
        text = "限制2行限制2行限制2行限制2行限制2行限制2行限制2行限制2行限制2行限制2行限制2行限制2行限制2行限制2行限制2行限制2行限制2行限制2行限制2行限制2行限制2行限制2行",
        maxLines = 2
    )
    Spacer(modifier = Modifier.height(10.dp))
    Text(
        text = "限制2行，多出省略限制2行，多出省略限制2行，多出省略限制2行，多出省略限制2行，多出省略限制2行，多出省略限制2行，多出省略限制2行，多出省略限制2行，多出省略限制2行，多出省略限制2行，多出省略限制2行，多出省略",
        maxLines = 2,
        overflow = TextOverflow.Ellipsis
    )
    Spacer(modifier = Modifier.height(10.dp))
    SelectionContainer {
        Text(text = "可以选中的文本")
    }
    Spacer(modifier = Modifier.height(10.dp))
    SelectionContainer {
        Column {
            Text(text = "可以选中的部分文本")
            Text(text = "可以选中的部分文本")
            DisableSelection {
                Text(text = "禁止选中的部分文本")
            }
            Text(text = "可以选中的部分文本")
        }
    }
    Spacer(modifier = Modifier.height(10.dp))
    val context = LocalContext.current
    ClickableText(
        text = buildAnnotatedString { append("可以点击的文本") },
        style = TextStyle(color = MaterialTheme.colors.onBackground)
    ) {
        Toast.makeText(context, "第${it}个字符被点击了", Toast.LENGTH_SHORT).show()
    }
    Spacer(modifier = Modifier.height(10.dp))
    val annotatedText = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = MaterialTheme.colors.onSurface
            )
        ) {
            append("试试链接吧，点击 ")
        }
        pushStringAnnotation(
            tag = "URL",
            annotation = "https://developer.android.com"
        )
        withStyle(
            style = SpanStyle(
                color = MaterialTheme.colors.primary,
                fontWeight = FontWeight.Bold
            )
        ) {
            append("这里")
        }
        pop()
    }

    ClickableText(
        text = annotatedText,
        onClick = { offset ->
            annotatedText.getStringAnnotations(
                tag = "URL", start = offset,
                end = offset
            )
                .firstOrNull()?.let { annotation ->
                    Toast.makeText(context, "点击链接${annotation.item}", Toast.LENGTH_SHORT).show()
                }
        }
    )
    Spacer(modifier = Modifier.height(10.dp))
    var text1 by remember { mutableStateOf("填充样式的输入框") }
    TextField(value = text1, onValueChange = { text1 = it }, label = { Text("填充样式的输入框") })

    Spacer(modifier = Modifier.height(10.dp))
    var text2 by remember { mutableStateOf("边框样式的输入框") }
    OutlinedTextField(value = text2, onValueChange = { text2 = it }, label = { Text("边框样式的输入框") })

    Spacer(modifier = Modifier.height(10.dp))
    var text3 by remember { mutableStateOf("普通样式的输入框") }
    BasicTextField(
        value = text3,
        onValueChange = { text3 = it },
        textStyle = TextStyle(color = MaterialTheme.colors.onSurface),
        modifier = Modifier.height(45.dp)
    )

    Spacer(modifier = Modifier.height(10.dp))
    var text4 by remember { mutableStateOf("密码输入框") }
    TextField(
        value = text4, onValueChange = { text4 = it },
        label = { Text("密码输入框") },
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
    )

    Spacer(modifier = Modifier.height(10.dp))
    var text5 by remember { mutableStateOf("") }
    BasicTextField(
        value = text5, onValueChange = { text5 = it },
        decorationBox = { innerTextField ->
            if (text5.isEmpty()) {
                Box(contentAlignment = Alignment.CenterStart) {
                    Text(
                        text = "自定义样式输入框",
                        color = MaterialTheme.colors.primary
                    )
                }
            }
            innerTextField()
        },
        modifier = Modifier
            .background(Color.LightGray, CircleShape)
            .padding(5.dp, 20.dp)
            .fillMaxWidth()
    )

    Spacer(modifier = Modifier.height(10.dp))
    var text6 by remember { mutableStateOf("改了光标颜色的输入框") }
    BasicTextField(
        value = text6,
        onValueChange = { text6 = it },
        cursorBrush = SolidColor(Color.Red),
        modifier = Modifier.height(45.dp),
        textStyle = TextStyle(MaterialTheme.colors.onBackground)
    )


    Spacer(modifier = Modifier.height(100.dp))
}
