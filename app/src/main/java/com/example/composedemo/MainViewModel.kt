package com.example.composedemo

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.example.composedemo.entities.FuncInfo
import com.example.composedemo.navigation.Screen

class MainViewModel() : ViewModel() {
    val functions = arrayListOf<FuncInfo>().apply {
        add(FuncInfo("布局", Screen.layout, Color(0xFF00A1FF)))
        add(FuncInfo("主题", Screen.theme, Color(0xFF6200EE)))
        add(FuncInfo("列表", Screen.List.main, Color(0xFF00C29B)))
        add(FuncInfo("文字", Screen.text, Color(0xFF000000)))
        add(FuncInfo("图片", Screen.image, Color(0xFFFFBE3B)))
        add(FuncInfo("Canvas", Screen.canvas, Color(0xFF1D2E44)))
        add(FuncInfo("自定义布局", Screen.custom_layout, Color(0xFF3587EC)))
        add(FuncInfo("动画", Screen.animation, Color(0xFFDD26AF)))
        add(FuncInfo("手势", Screen.gesture, Color(0xFF1BC3E0)))
    }
    val images = arrayListOf<String>().apply {
        add("https://pic1.zhimg.com/50/f56513788384645db768d0ec542dec33_hd.jpg?source=1940ef5c")
        add("https://pic2.zhimg.com/50/3b5d9eaa6b80cf4983b709a28662975c_hd.jpg?source=1940ef5c")
        add("https://pic1.zhimg.com/v2-077a594b1a64d55e95de392755a8aa76_1440w.jpg?source=172ae18b")
        add("https://i.pinimg.com/originals/91/8d/2f/918d2faca1f7030c8dde71c7902ccd81.jpg")
        add("https://img-blog.csdnimg.cn/img_convert/7fba0fbf77222369ffc99a0482e154c9.png")
        add("https://i.pinimg.com/originals/1c/59/d9/1c59d97635ba73b502a7f9c630bf52cf.jpg")
        add("https://macjpeg.macsc.com/macdown/pic/202009/03113634_e7f0bb805b.jpeg")
        add("https://www.lizhi.io/wp-content/uploads/2019/07/%E5%8A%A8%E6%80%81%E5%A3%81%E7%BA%B8-4-20190705.jpg")
        add("https://pic3.zhimg.com/v2-77bbb941f260b90f0193ef73d3f2b9e4_1440w.jpg?source=172ae18b")
        add("https://wallpaperm.cmcm.com/ec29df3f120f648b2793066f68c2363d.jpg")
    }
}