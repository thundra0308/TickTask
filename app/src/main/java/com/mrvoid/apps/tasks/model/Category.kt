package com.mrvoid.apps.tasks.model

import androidx.annotation.ColorInt

data class Category(
    val order: Int,
    val name: String,
    @ColorInt val color: Int
)
