package com.example.composedemo.navigation

object Screen {
    const val main = "main"
    const val animation = "animation"
    const val canvas = "canvas"
    const val custom_layout = "custom_layout"
    const val gesture = "gesture"
    const val image = "image"

    object Layout {
        const val main = "layout/main"
        const val row = "layout/row"
        const val column = "layout/column"
        const val box = "layout/box"
    }

    const val layout = "layout"

    object List {
        const val main = "list/main"
        const val scrollable_row = "list/scrollable_row"
        const val scrollable_column = "list/scrollable_column"
        const val lazy_row = "list/lazy_row"
        const val lazy_column = "list/lazy_column"
        const val sticky_header = "list/sticky_header"
        const val lazy_vertical_grid = "list/lazy_vertical_grid"
    }

    const val text = "text"
    const val theme = "theme"
}