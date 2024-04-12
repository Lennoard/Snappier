package component.data

import androidx.compose.ui.text.font.FontWeight
import component.base.Constraints

data class TextData(
    val text: String = "",
    val color: String = "",
    val size: Float = 0F,
    val weight: Int = FontWeight.Normal.weight,
    override val constraints: Constraints? = null,
    override val alignment: String? = null
) : BaseComponentData()
