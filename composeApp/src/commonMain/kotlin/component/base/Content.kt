package component.base

import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.buildJsonObject

data class Content(
    val description: String? = null,
    val backgroundColor: String? = null,
    val foregroundColor: String? = null,
    val constraints: List<Constraints> = emptyList(),
    val parameters: JsonElement = buildJsonObject { },
)
