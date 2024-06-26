package br.com.androidvip.snappier.ui.utils

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign

fun Color.Companion.parse(hex: String): Color {
    return runCatching { Color(hex.toColorInt()) }.getOrDefault(Unspecified)
}

fun String?.composeColor(): Color {
    return Color.parse(this ?: return Color.Unspecified)
}

fun String?.textAlignment(): TextAlign = when (this?.lowercase()) {
    "left" -> TextAlign.Left
    "right" -> TextAlign.Right
    "end" -> TextAlign.End
    "center" -> TextAlign.Center
    "justify" -> TextAlign.Justify
    else -> TextAlign.Start
}

fun String?.contentScale(): ContentScale = when (this?.lowercase()) {
    "crop", "centercrop" -> ContentScale.Crop
    "fit", "center" -> ContentScale.Fit
    "fillbounds", "fill" -> ContentScale.FillBounds
    "fillwidth" -> ContentScale.FillWidth
    "fillheight" -> ContentScale.FillHeight
    "inside", "centerinside" -> ContentScale.Inside
    else -> ContentScale.None
}

private fun String.toColorInt(): Int {
    if (this[0] == '#') {
        var color = substring(1).toLong(16)
        if (length == 7) {
            color = color or 0x00000000ff000000L
        } else if (length != 9) {
            throw IllegalArgumentException("Unknown color")
        }
        return color.toInt()
    }
    throw IllegalArgumentException("Unknown color")
}
