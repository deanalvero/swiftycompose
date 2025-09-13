package io.github.deanalvero.swiftycompose.data

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

class Binding<T>(
    private val getValue: () -> T,
    private val setValue: (T) -> Unit
) {
    var value: T
        get() = getValue()
        set(newValue) = setValue(newValue)
}

@Composable
fun <T> stateBinding(value: T): Binding<T> {
    val state = remember { mutableStateOf(value) }
    return remember {
        Binding(
            getValue = { state.value },
            setValue = { state.value = it }
        )
    }
}
