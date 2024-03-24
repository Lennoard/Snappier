package component.data

data class BorderData(
    val topLeft: Float = 0F,
    val topRight: Float = 0F,
    val bottomRight: Float = 0F,
    val bottomLeft: Float = 0F,
) : BaseComponentData()
