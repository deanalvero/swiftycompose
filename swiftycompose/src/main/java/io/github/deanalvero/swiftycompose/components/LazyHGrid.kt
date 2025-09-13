package io.github.deanalvero.swiftycompose.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import io.github.deanalvero.swiftycompose.SwiftUIView

class LazyHGrid(
    val rows: GridCells,
    val arrangement: Arrangement.Vertical = Arrangement.Center,
    val spacing: Int = 0,
    val state: LazyGridState? = null,
    val content: LazyGridScope.() -> Unit
) : SwiftUIView() {
    @Composable
    override fun invoke() {
        LazyHorizontalGrid(
            rows = rows,
            modifier = modifier,
            state = state ?: rememberLazyGridState(),
            verticalArrangement = arrangement,
            horizontalArrangement = if (spacing > 0) {
                Arrangement.spacedBy(spacing.dp)
            } else {
                Arrangement.Start
            },
            content = content
        )
    }
}
