package io.github.deanalvero.swiftycompose.components

import androidx.compose.material3.Slider
import androidx.compose.runtime.Composable
import io.github.deanalvero.swiftycompose.SwiftUIView
import io.github.deanalvero.swiftycompose.data.Binding

class Slider(
    val value: Binding<Float>,
    val bounds: ClosedFloatingPointRange<Float> = 0f..1f
) : SwiftUIView() {

    @Composable
    override operator fun invoke() {
        Slider(
            value = value.value,
            onValueChange = {
                value.value = it
            },
            valueRange = bounds,
            modifier = modifier
        )
    }
}