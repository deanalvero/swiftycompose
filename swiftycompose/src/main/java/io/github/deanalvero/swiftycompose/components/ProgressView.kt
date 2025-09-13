package io.github.deanalvero.swiftycompose.components

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import io.github.deanalvero.swiftycompose.SwiftUIView

class ProgressView(
    val value: Float? = null
) : SwiftUIView() {
    private var progressViewStyle: ProgressViewStyle = ProgressViewStyle.Automatic

    fun progressViewStyle(style: ProgressViewStyle): ProgressView {
        this.progressViewStyle = style
        return this
    }

    @Composable
    override fun invoke() {
        when (progressViewStyle) {
            ProgressViewStyle.Automatic -> {
                if (value == null) {
                    CircularProgressIndicator(
                        modifier = modifier
                    )
                } else {
                    LinearProgressIndicator(
                        progress = { value },
                        modifier = modifier
                    )
                }
            }
            ProgressViewStyle.Linear -> {
                if (value == null) {
                    LinearProgressIndicator(
                        modifier = modifier
                    )
                } else {
                    LinearProgressIndicator(
                        progress = { value },
                        modifier = modifier
                    )
                }
            }
            ProgressViewStyle.Circular -> {
                if (value == null) {
                    CircularProgressIndicator(
                        modifier = modifier
                    )
                } else {
                    CircularProgressIndicator(
                        progress = { value },
                        modifier = modifier
                    )
                }
            }
        }
    }
}

enum class ProgressViewStyle {
    Automatic, Circular, Linear
}
