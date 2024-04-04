package component.base

import engine.SnappierComponentData
import kotlinx.serialization.json.JsonElement

data class Component(
    val id: String,
    override val contents: List<Content>,
    override val parameters: JsonElement? = null,
) : SnappierComponentData
