package component.data

data class VideoData(
    val url: String,
    val description: String,
    val resourceName: String? = null,
    val autoPlay: Boolean = false,
) : ComponentData()
