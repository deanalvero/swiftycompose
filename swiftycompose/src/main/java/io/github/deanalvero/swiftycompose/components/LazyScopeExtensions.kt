package io.github.deanalvero.swiftycompose.components

import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable

fun <T> LazyListScope.ForEach(
    items: List<T>,
    key: ((item: T) -> Any)? = null,
    itemContent: @Composable (item: T) -> Unit
) {
    items(
        items = items,
        key = key
    ) { item ->
        itemContent(item)
    }
}

fun <T> LazyGridScope.ForEach(
    items: List<T>,
    key: ((item: T) -> Any)? = null,
    itemContent: @Composable (item: T) -> Unit
) {
    items(
        items = items,
        key = key
    ) { item ->
        itemContent(item)
    }
}

fun LazyListScope.ForEach(
    range: IntRange,
    key: ((index: Int) -> Any)? = null,
    itemContent: @Composable (index: Int) -> Unit
) {
    items(
        count = range.count(),
        key = key?.let { { index -> it(range.first + index) } }
    ) { index ->
        itemContent(range.first + index)
    }
}

fun LazyGridScope.ForEach(
    range: IntRange,
    key: ((index: Int) -> Any)? = null,
    itemContent: @Composable (index: Int) -> Unit
) {
    items(
        count = range.count(),
        key = key?.let { { index -> it(range.first + index) } }
    ) { index ->
        itemContent(range.first + index)
    }
}
