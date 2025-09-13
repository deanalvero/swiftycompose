package io.github.deanalvero.swiftycompose.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import io.github.deanalvero.swiftycompose.SwiftUIView

class LazyHStack(
    val alignment: Alignment.Vertical = Alignment.CenterVertically,
    val spacing: Int = 0,
    val state: LazyListState? = null,
    val content: LazyListScope.() -> Unit
) : SwiftUIView() {
    @Composable
    override fun invoke() {
        LazyRow(
            modifier = modifier,
            state = state ?: rememberLazyListState(),
            verticalAlignment = alignment,
            horizontalArrangement = if (spacing > 0) {
                Arrangement.spacedBy(spacing.dp)
            } else {
                Arrangement.Start
            },
            content = content
        )
    }
}
