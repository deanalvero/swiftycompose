package io.github.deanalvero.swiftycompose.components

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import io.github.deanalvero.swiftycompose.SwiftUIView

class Button(
    val title: String,
    val action: () -> Unit
) : SwiftUIView() {
    @Composable
    override fun invoke() {
        Button(
            onClick = action,
            modifier = modifier
        ) {
            Text(
                text = title
            )
        }
    }
}
