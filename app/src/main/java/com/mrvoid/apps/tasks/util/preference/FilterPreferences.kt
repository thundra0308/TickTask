package com.mrvoid.apps.tasks.util.preference

import com.mrvoid.apps.tasks.model.SortOrder

data class FilterPreferences(
    val sortOrder: SortOrder,
    val viewType: Boolean,
)