package io.github.deanalvero.swiftycompose.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import io.github.deanalvero.swiftycompose.SwiftUIView
import io.github.deanalvero.swiftycompose.data.Binding

class Toggle(
    val title: String? = null,
    val isOn: Binding<Boolean>,
) : SwiftUIView() {

    @Composable
    override operator fun invoke() {
        if (title != null) {
            Row(
                modifier = modifier,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = title)
                Spacer(modifier = Modifier.weight(1f))
                Switch(
                    checked = isOn.value,
                    onCheckedChange = {
                        isOn.value = it
                    }
                )
            }
        } else {
            Switch(
                checked = isOn.value,
                onCheckedChange = {
                    isOn.value = it
                },
                modifier = modifier
            )
        }
    }
}
