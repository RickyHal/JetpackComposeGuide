package com.example.composedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composedemo.list.ListPage
import com.example.composedemo.navigation.Screen
import com.example.composedemo.ui.demo.*
import com.example.composedemo.ui.public.FunctionList
import com.example.composedemo.ui.public.Page
import com.example.composedemo.ui.theme.CustomThemeManager
import com.example.composedemo.ui.theme.ThemeType

val titleLiveData = MutableLiveData<String>()
val themeTypeState = mutableStateOf(ThemeType.Default)
val darkThemeState = mutableStateOf(false)

class MainActivity : ComponentActivity() {
    @ExperimentalTextApi
    @ExperimentalUnitApi
    @ExperimentalAnimationApi
    @ExperimentalMaterialApi
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val rememberTitle: String by titleLiveData.observeAsState("Compose Demo")
            val themType: ThemeType by themeTypeState
            val isDarkTheme: Boolean by darkThemeState
            val wrappedColor = CustomThemeManager.getWrappedColor(themType)
            window.statusBarColor = if (isDarkTheme) {
                Color(0xFF181818)
            } else {
                wrappedColor.lightColors.primary
            }.toArgb()
            Page(rememberTitle, themType, isDarkTheme) {
                Content()
            }
        }
    }
}


@ExperimentalTextApi
@ExperimentalUnitApi
@ExperimentalAnimationApi
@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
fun Content() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.main) {
        composable(Screen.main) { Main(navController) }
        composable(Screen.animation) { AnimationPage() }
        composable(Screen.gesture) { GesturePage() }
        composable(Screen.image) { ImagePage() }
        composable(Screen.canvas) { CanvasPage() }
        composable(Screen.layout) { LayoutPage() }
        composable(Screen.custom_layout) { CustomLayoutPage() }
        composable(Screen.List.main) { ListPage() }
        composable(Screen.text) { TextPage() }
        composable(Screen.theme) { ThemePage() }
    }
}


@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
fun Main(navController: NavHostController) {
    titleLiveData.value = "Compose Demo"
    val viewModel: MainViewModel = viewModel()
    FunctionList(functions = viewModel.functions, navController = navController)
}