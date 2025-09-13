package io.github.deanalvero.swiftycompose.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import io.github.deanalvero.swiftycompose.SwiftUIView

class LazyVGrid(
    val columns: GridCells,
    val arrangement: Arrangement.Horizontal = Arrangement.Center,
    val spacing: Int = 0,
    val state: LazyGridState? = null,
    val content: LazyGridScope.() -> Unit
) : SwiftUIView() {
    @Composable
    override fun invoke() {
        LazyVerticalGrid(
            columns = columns,
            modifier = modifier,
            state = state ?: rememberLazyGridState(),
            verticalArrangement = if (spacing > 0) {
                Arrangement.spacedBy(spacing.dp)
            } else {
                Arrangement.Top
            },
            horizontalArrangement = arrangement,
            content = content
        )
    }
}
