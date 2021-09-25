package com.example.composedemo.ui.demo.viewmodel

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.example.composedemo.entities.FuncInfo
import com.example.composedemo.navigation.Screen

class ListViewModel : ViewModel() {
    val functions = arrayListOf<FuncInfo>().apply {
        add(FuncInfo("ScrollableRow", Screen.List.scrollable_row, Color(0xFF365299)))
        add(FuncInfo("ScrollableColumn", Screen.List.scrollable_column, Color(0xFF9C20A0)))
        add(FuncInfo("LazyRow", Screen.List.lazy_row, Color(0xFF00C29B)))
        add(FuncInfo("LazyColumn", Screen.List.lazy_column, Color(0xFF000000)))
        add(FuncInfo("粘性标题", Screen.List.sticky_header, Color(0xFFFFBE3B)))
        add(FuncInfo("垂直GridList", Screen.List.lazy_vertical_grid, Color(0xFF3587EC)))
    }
}