package io.github.deanalvero.swiftycompose.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import io.github.deanalvero.swiftycompose.SwiftUIView

class VStack(
    val alignment: Alignment.Horizontal = Alignment.Companion.CenterHorizontally,
    val spacing: Int = 0,
    val content: @Composable ColumnScope.() -> Unit
) : SwiftUIView() {

    @Composable
    override fun invoke() {
        Column(
            modifier = modifier,
            horizontalAlignment = alignment,
            verticalArrangement = if (spacing > 0) {
                Arrangement.spacedBy(spacing.dp)
            } else {
                Arrangement.Top
            },
            content = content
        )
    }
}