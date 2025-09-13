package io.github.deanalvero.swiftycompose.components

import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import io.github.deanalvero.swiftycompose.SwiftUIView
import io.github.deanalvero.swiftycompose.data.Binding

class TextField(
    val title: String? = null,
    val text: Binding<String>
) : SwiftUIView() {
    @Composable
    override fun invoke() {
        OutlinedTextField(
            value = text.value,
            onValueChange = {
                text.value = it
            },
            modifier = modifier,
            label = title?.let {
                {
                    Text(text = it)
                }
            }
        )
    }
}
