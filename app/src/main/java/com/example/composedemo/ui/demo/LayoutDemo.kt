package com.example.composedemo.ui.demo

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.example.composedemo.titleLiveData


@ExperimentalUnitApi
@Composable
fun LayoutPage() {
    titleLiveData.value = "Compose Layout"
    LayoutContent()
}

@ExperimentalUnitApi
@Composable
private fun LayoutContent() {
    var clickCount by remember { mutableStateOf(0) }
    Scaffold(modifier = Modifier.fillMaxSize(),
        drawerContent = {
            Text(text = "这是drawerContent")
        },
        floatingActionButton = {
            val context = LocalContext.current
            Box(
                modifier = Modifier
                    .size(70.dp)
                    .background(
                        MaterialTheme.colors.primary,
                        CircleShape
                    )
                    .clickable {
                        clickCount++
                    }, contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Action\nButton",
                    color = Color.White,
                    fontSize = TextUnit(10f, TextUnitType.Sp),
                    textAlign = TextAlign.Center
                )
            }
        },
        content = {
            Column(modifier = Modifier.fillMaxSize()) {
                RowDemo()
                ColumnDemo()
                BoxDemo()
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .height(100.dp)
                        .fillMaxWidth()
                ) {
                    Text(text = "试试向右滑>>>")
                }
                Text(
                    "第${clickCount}次点击",
                    Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "这个界面使用的是Scaffold来布局",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }
        })
}

@Composable
fun RowDemo() {
    Box(modifier = Modifier.height(IntrinsicSize.Min)) {
        Row {
            Box(
                modifier = Modifier
                    .background(Color(0xFFCC3939))
                    .width(100.dp)
                    .height(50.dp)
            )
            Box(
                modifier = Modifier
                    .background(Color(0xFF3587EC))
                    .width(100.dp)
                    .height(50.dp)
            )
            Box(
                modifier = Modifier
                    .background(Color(0xFFDD26AF))
                    .width(100.dp)
                    .height(50.dp)
            )
            Box(
                modifier = Modifier
                    .background(Color(0xFF1BC3E0))
                    .width(100.dp)
                    .height(50.dp)
            )
        }
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(
                text = "这是Row",
                modifier = Modifier
                    .padding(10.dp),
                color = Color.White
            )
        }
    }

}

@Composable
fun ColumnDemo() {
    Box(
        modifier = Modifier
            .height(IntrinsicSize.Min)
            .padding(0.dp, 30.dp, 0.dp, 0.dp)
    ) {
        Column() {
            Box(
                modifier = Modifier
                    .background(Color(0xFFDB4B4B))
                    .fillMaxWidth()
                    .height(50.dp)
            )
            Box(
                modifier = Modifier
                    .background(Color(0xFF3587EC))
                    .fillMaxWidth()
                    .height(50.dp)
            )
            Box(
                modifier = Modifier
                    .background(Color(0xFFDD26AF))
                    .fillMaxWidth()
                    .height(50.dp)
            )
            Box(
                modifier = Modifier
                    .background(Color(0xFF1BC3E0))
                    .fillMaxWidth()
                    .height(50.dp)
            )
        }
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(
                text = "这是Column",
                modifier = Modifier
                    .padding(10.dp),
                color = Color.White
            )
        }
    }
}

@Composable
fun BoxDemo() {
    Box(modifier = Modifier.padding(0.dp, 30.dp, 0.dp, 0.dp)) {
        Box(
            modifier = Modifier
                .size(200.dp)
                .background(Color(0xFFDD26AF)),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .size(160.dp)
                    .background(Color(0xFF1BC3E0)),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .size(120.dp)
                        .background(Color(0xFFDB4B4B)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "这是Box", modifier = Modifier.padding(10.dp), color = Color.White)
                }
            }
        }
    }
}