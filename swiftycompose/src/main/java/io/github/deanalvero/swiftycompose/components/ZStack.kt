package io.github.deanalvero.swiftycompose.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import io.github.deanalvero.swiftycompose.SwiftUIView

class ZStack(
    val alignment: Alignment = Alignment.Center,
    val content: @Composable BoxScope.() -> Unit
) : SwiftUIView() {

    @Composable
    override fun invoke() {
        Box(
            modifier = modifier,
            contentAlignment = alignment,
            content = content
        )
    }
}
