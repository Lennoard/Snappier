package component.data

data class ImageData(
    val url: String,
    val description: String,
    val resourceName: String? = null,
    val scaleType: String,
) : ComponentData()
