package io.github.deanalvero.swiftycompose

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

abstract class SwiftUIView {
    var modifier: Modifier = Modifier

    /**
     * Returns the Composable by adding a "()" at the end of the SwiftUIView
     * ex: Text("sample")()
     */
    @Composable
    abstract operator fun invoke()

    /**
     * Returns the Composable by adding a "+" at the beginning of the SwiftUIView
     * ex: +Text("sample")
     */
    @Composable
    operator fun unaryPlus() = invoke()

    /**
     * Returns the Composable by adding a "-" at the beginning of the SwiftUIView
     * ex: -Text("sample")
     */
    @Composable
    operator fun unaryMinus() = invoke()

    /**
     * Returns the Composable by adding a "!" at the beginning of the SwiftUIView
     * ex: !Text("sample")
     */
    @Composable
    operator fun not() = invoke()

    /**
     * Returns the Composable by calling "build()" at the end of the SwiftUIView
     * ex: Text("sample").build()
     */
    @SuppressLint("ComposableNaming")
    @Composable
    fun build() = invoke()

    inline fun <reified T : SwiftUIView> T.cornerRadius(radius: Int): T {
        this.modifier = this.modifier.clip(RoundedCornerShape(radius.dp))
        return this
    }

    inline fun <reified T : SwiftUIView> T.frame(width: Int? = null, height: Int? = null): T {
        var newModifier = this.modifier
        width?.let { newModifier = newModifier.width(it.dp) }
        height?.let { newModifier = newModifier.height(it.dp) }
        this.modifier = newModifier
        return this
    }
}
