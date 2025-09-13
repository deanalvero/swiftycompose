package io.github.deanalvero.swiftycompose.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import io.github.deanalvero.swiftycompose.SwiftUIView

class Image(
    private val source: ImageSource,
    private val contentDescription: String? = null
) : SwiftUIView() {

    constructor(
        painter: Painter,
        contentDescription: String? = null,
    ) : this(ImageSource.PainterSource(painter), contentDescription)

    constructor(
        imageVector: ImageVector,
        contentDescription: String? = null,
    ) : this(ImageSource.VectorSource(imageVector), contentDescription)

    constructor(
        bitmap: ImageBitmap,
        contentDescription: String? = null,
    ) : this(ImageSource.BitmapSource(bitmap), contentDescription)

    private var contentScale: ContentScale = ContentScale.Fit
    private var alpha: Float = DefaultAlpha

    fun aspectRatio(
        aspectRatio: Float? = null,
        matchHeightConstraintsFirst: Boolean = false,
        contentScale: ContentScale
    ): Image {
        if (aspectRatio != null) {
            this.modifier = this.modifier.aspectRatio(
                ratio = aspectRatio,
                matchHeightConstraintsFirst = matchHeightConstraintsFirst
            )
        }
        this.contentScale = contentScale
        return this
    }

    fun opacity(opacity: Float): Image {
        this.alpha = opacity
        return this
    }

    @Composable
    override fun invoke() {
        when (source) {
            is ImageSource.PainterSource -> Image(
                painter = source.painter,
                contentDescription = contentDescription,
                modifier = modifier,
                contentScale = contentScale,
                alpha = alpha
            )
            is ImageSource.VectorSource -> Image(
                imageVector = source.imageVector,
                contentDescription = contentDescription,
                modifier = modifier,
                contentScale = contentScale,
                alpha = alpha
            )
            is ImageSource.BitmapSource -> Image(
                bitmap = source.bitmap,
                contentDescription = contentDescription,
                modifier = modifier,
                contentScale = contentScale,
                alpha = alpha
            )
        }
    }
}

sealed class ImageSource {
    data class PainterSource(val painter: Painter) : ImageSource()
    data class VectorSource(val imageVector: ImageVector) : ImageSource()
    data class BitmapSource(val bitmap: ImageBitmap) : ImageSource()
}
