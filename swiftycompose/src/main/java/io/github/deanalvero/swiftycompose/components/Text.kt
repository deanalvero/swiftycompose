package io.github.deanalvero.swiftycompose.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import io.github.deanalvero.swiftycompose.SwiftUIView

class Text(val text: String) : SwiftUIView() {
    private var fontWeight: FontWeight? = null
    private var fontFamily: FontFamily? = null
    private var fontStyle: FontStyle? = null
    private var textAlign: TextAlign? = null
    private var fontSize: Int? = null
    private var textColor: Color? = null
    private var textDecoration: TextDecoration? = null
    private var letterSpacing = TextUnit.Unspecified
    private var lineHeight = TextUnit.Unspecified
    private var overflow: TextOverflow = TextOverflow.Clip

    private var maxLines: Int = Int.MAX_VALUE

    fun bold(): Text {
        this.fontWeight = FontWeight.Bold
        return this
    }

    fun fontWeight(weight: FontWeight): Text {
        this.fontWeight = weight
        return this
    }

    fun fontDesign(design: FontFamily): Text {
        this.fontFamily = design
        return this
    }

    fun lineLimit(number: Int?): Text {
        this.maxLines = number ?: Int.MAX_VALUE
        return this
    }

    fun strikethrough(): Text {
        this.textDecoration = TextDecoration.combine(
            listOfNotNull(
                this.textDecoration,
                TextDecoration.LineThrough
            )
        )
        return this
    }

    fun underline(): Text {
        this.textDecoration = TextDecoration.combine(
            listOfNotNull(
                this.textDecoration,
                TextDecoration.Underline
            )
        )
        return this
    }

    fun foregroundStyle(color: Color): Text {
        this.textColor = color
        return this
    }

    fun italic(): Text {
        this.fontStyle = FontStyle.Italic
        return this
    }

    fun multilineTextAlignment(multilineTextAlignment: TextAlign): Text {
        this.textAlign = multilineTextAlignment
        return this
    }

    fun truncationMode(mode: TextOverflow): Text {
        this.overflow = mode
        return this
    }

    fun lineSpacing(lineSpacing: TextUnit): Text {
        this.lineHeight = lineSpacing
        return this
    }

    fun tracking(tracking: TextUnit): Text {
        this.letterSpacing = tracking
        return this
    }

    @Composable
    override fun invoke() {
        Text(
            text = text,
            modifier = modifier,
            fontStyle = fontStyle,
            fontWeight = fontWeight,
            fontFamily = fontFamily,
            textAlign = textAlign,
            fontSize = fontSize?.sp ?: TextUnit.Unspecified,
            color = textColor ?: Color.Unspecified,
            letterSpacing = letterSpacing,
            textDecoration = textDecoration,
            lineHeight = lineHeight,
            overflow = overflow,
            maxLines = maxLines
        )
    }
}
