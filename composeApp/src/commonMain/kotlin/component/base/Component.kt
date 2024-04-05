package component.base

import engine.SnappierComponentData
import kotlinx.serialization.json.JsonElement

/**
 * This class is the entry point of the serialized "component" JSON.
 */
data class Component(
    val id: String,
    override val contents: List<Content>,
    override val parameters: JsonElement? = null
) : SnappierComponentData
