package com.example.composedemo.list

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composedemo.MainViewModel
import com.example.composedemo.navigation.Screen
import com.example.composedemo.titleLiveData
import com.example.composedemo.ui.demo.viewmodel.ListViewModel
import com.example.composedemo.ui.public.FunctionList
import com.example.composedemo.ui.public.HorizontalNoMoreItem
import com.example.composedemo.ui.public.VerticalNoMoreItem
import com.google.accompanist.coil.rememberCoilPainter


@Composable
fun LazyRowDemo() {
    titleLiveData.value = "Compose Lazy Row"
    val viewModel: MainViewModel = viewModel()
    LazyRow(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.spacedBy(15.dp),
    ) {
        items(viewModel.images, key = {
            it
        }) { image ->
            ImageCard(image, modifier = Modifier.size(200.dp, 160.dp), "这是LazyRow")
        }
        item {
            HorizontalNoMoreItem()
        }
    }
}

@Composable
fun LazyColumnDemo() {
    titleLiveData.value = "Compose Lazy Column"
    val viewModel: MainViewModel = viewModel()
    LazyColumn(verticalArrangement = Arrangement.spacedBy(15.dp)) {
        item {}
        items(viewModel.images, key = {
            it
        }) { image ->
            ImageCard(
                image, modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp), "这是LazyColumn"
            )
        }
        item {
            VerticalNoMoreItem()
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun StickerHeaderDemo() {
    titleLiveData.value = "Compose Sticker Header"
    val viewModel: MainViewModel = viewModel()
    LazyColumn(verticalArrangement = Arrangement.spacedBy(15.dp)) {
        item {
            ImageCard(
                viewModel.images[0], modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp), "这是LazyColumn"
            )
        }
        stickyHeader {
            Column(
                modifier = Modifier
                    .height(50.dp)
                    .background(MaterialTheme.colors.background),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "我是粘性标题",
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }
        }
        items(viewModel.images, key = {
            it
        }) { image ->
            ImageCard(
                image, modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp), "这是LazyColumn"
            )
        }
        item {
            VerticalNoMoreItem()
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun LazyVerticalGridDemo() {
    titleLiveData.value = "Compose LazyVerticalGrid"
    val viewModel: MainViewModel = viewModel()
    LazyVerticalGrid(
        modifier = Modifier.fillMaxSize(),
        cells = GridCells.Adaptive(minSize = 128.dp)
    ) {
        items(viewModel.images + viewModel.images + viewModel.images) { image ->
            ImageCard(image = image, modifier = Modifier.size(128.dp), text = "这是LazyVerticalGrid")
        }
    }
}

@Composable
fun ScrollableRowDemo() {
    titleLiveData.value = "Compose Scrollable Row"
    val viewModel: MainViewModel = viewModel()
    Box(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
        ) {
            for (image in viewModel.images) {
                ImageCard(image, modifier = Modifier.size(200.dp, 160.dp), "这是ScrollableRow")
            }
        }
    }
}

@Composable
fun ScrollableColumnDemo() {
    titleLiveData.value = "Compose Scrollable Column"
    val viewModel: MainViewModel = viewModel()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        for (image in viewModel.images) {
            ImageCard(
                image, modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp), "这是ScrollableColumn"
            )
        }
    }
}

@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Composable
fun ListPage() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.List.main) {
        composable(Screen.List.main) { ListContent(navController) }
        composable(Screen.List.scrollable_row) { ScrollableRowDemo() }
        composable(Screen.List.scrollable_column) { ScrollableColumnDemo() }
        composable(Screen.List.lazy_row) { LazyRowDemo() }
        composable(Screen.List.lazy_column) { LazyColumnDemo() }
        composable(Screen.List.sticky_header) { StickerHeaderDemo() }
        composable(Screen.List.lazy_vertical_grid) { LazyVerticalGridDemo() }
    }
}

@ExperimentalMaterialApi
@Composable
fun ListContent(navController: NavHostController) {
    titleLiveData.value = "Compose List"
    val viewModel: ListViewModel = viewModel()
    FunctionList(functions = viewModel.functions, navController = navController)
}

@Composable
fun ImageCard(image: String, modifier: Modifier, text: String) {
    Box(contentAlignment = Alignment.Center, modifier = modifier) {
        Image(
            painter = rememberCoilPainter(image, fadeIn = true),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .background(Color.LightGray),
            contentScale = ContentScale.Crop,
        )
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(10.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = text)
        }
    }
}