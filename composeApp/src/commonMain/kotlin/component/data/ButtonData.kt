package component.data

data class ButtonData(
    val color: String,
    val backgroundColor: String,
    val title: String,
    val border: BorderData?,
    val shadow: ShadowData?,
    val stroke: StrokeData?,
) : ComponentData()
