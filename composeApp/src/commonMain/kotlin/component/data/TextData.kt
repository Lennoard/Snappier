package component.data

import component.base.Constraints

data class TextData(
    val text: String = "",
    val color: String = "",
    val size: Float = 0F,
    override val constraints: Constraints? = null,
    override val alignment: String? = null
) : BaseComponentData()
