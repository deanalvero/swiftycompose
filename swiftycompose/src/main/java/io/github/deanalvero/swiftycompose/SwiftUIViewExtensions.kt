package io.github.deanalvero.swiftycompose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.DefaultShadowColor
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Overrides the [SwiftUIView]'s modifier
 */
inline fun <reified T : SwiftUIView> T.modifier(modifier: Modifier): T {
    this.modifier = modifier
    return this
}

/**
 * Concatenates this modifier with the [SwiftUIView]'s modifier
 */
inline fun <reified T : SwiftUIView> T.then(modifier: Modifier): T {
    this.modifier = this.modifier.then(modifier)
    return this
}

inline fun <reified T : SwiftUIView> T.padding(all: Dp): T {
    this.modifier = this.modifier.padding(all)
    return this
}

inline fun <reified T : SwiftUIView> T.padding(horizontal: Dp = 0.dp, vertical: Dp = 0.dp): T {
    this.modifier = this.modifier.padding(horizontal = horizontal, vertical = vertical)
    return this
}

inline fun <reified T : SwiftUIView> T.background(color: Color): T {
    this.modifier = this.modifier.background(color)
    return this
}

inline fun <reified T : SwiftUIView> T.cornerRadius(radius: Dp): T {
    this.modifier = this.modifier.clip(RoundedCornerShape(radius))
    return this
}

inline fun <reified T : SwiftUIView> T.frame(
    width: Dp? = null,
    height: Dp? = null
): T {
    var newModifier = this.modifier

    width?.let {
        newModifier = if (it == Dp.Infinity) {
            newModifier.fillMaxWidth()
        } else {
            newModifier.width(it)
        }
    }

    height?.let {
        newModifier = if (it == Dp.Infinity) {
            newModifier.fillMaxHeight()
        } else {
            newModifier.height(it)
        }
    }

    this.modifier = newModifier
    return this
}

inline fun <reified T : SwiftUIView> T.frame(
    minWidth: Dp? = null,
    maxWidth: Dp? = null,
    minHeight: Dp? = null,
    maxHeight: Dp? = null
): T {
    var newModifier = this.modifier

    if (maxWidth == Dp.Infinity && maxHeight == Dp.Infinity) {
        newModifier = newModifier.fillMaxSize()
    } else {
        if (maxWidth == Dp.Infinity) {
            newModifier = newModifier.fillMaxWidth()
        }
        if (maxHeight == Dp.Infinity) {
            newModifier = newModifier.fillMaxHeight()
        }
    }

    newModifier = newModifier.sizeIn(
        minWidth = minWidth ?: Dp.Unspecified,
        maxWidth = if (maxWidth != Dp.Infinity) maxWidth ?: Dp.Unspecified else Dp.Unspecified,
        minHeight = minHeight ?: Dp.Unspecified,
        maxHeight = if (maxHeight != Dp.Infinity) maxHeight ?: Dp.Unspecified else Dp.Unspecified
    )

    this.modifier = newModifier
    return this
}

inline fun <reified T : SwiftUIView> T.shadow(
    elevation: Dp,
    shape: Shape = RectangleShape,
    clip: Boolean = elevation > 0.dp,
    ambientColor: Color = DefaultShadowColor,
    spotColor: Color = DefaultShadowColor,
): T {
    this.modifier = this.modifier.shadow(elevation, shape, clip, ambientColor, spotColor)
    return this
}

inline fun <reified T : SwiftUIView> T.blur(
    radius: Dp,
    edgeTreatment: BlurredEdgeTreatment = BlurredEdgeTreatment.Rectangle
): T {
    this.modifier = this.modifier.blur(radius, edgeTreatment)
    return this
}

inline fun <reified T : SwiftUIView> T.blur(
    radiusX: Dp,
    radiusY: Dp,
    edgeTreatment: BlurredEdgeTreatment = BlurredEdgeTreatment.Rectangle,
): T {
    this.modifier = this.modifier.blur(radiusX, radiusY, edgeTreatment)
    return this
}

inline fun <reified T : SwiftUIView> T.opacity(opacity: Float): T {
    this.modifier = this.modifier.alpha(opacity)
    return this
}

inline fun <reified T : SwiftUIView> T.onTapGesture(noinline action: () -> Unit): T {
    this.modifier = this.modifier.clickable(onClick = action)
    return this
}

inline fun <reified T : SwiftUIView> T.accessibilityLabel(label: String): T {
    this.modifier = this.modifier.semantics {
        contentDescription = label
    }
    return this
}
