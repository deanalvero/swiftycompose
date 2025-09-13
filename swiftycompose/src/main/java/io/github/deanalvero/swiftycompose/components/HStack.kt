package io.github.deanalvero.swiftycompose.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import io.github.deanalvero.swiftycompose.SwiftUIView

class HStack(
    val alignment: Alignment.Vertical = Alignment.CenterVertically,
    val spacing: Int = 0,
    val content: @Composable RowScope.() -> Unit
) : SwiftUIView() {

    @Composable
    override fun invoke() {
        Row(
            modifier = modifier,
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
