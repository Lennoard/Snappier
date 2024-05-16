package br.com.androidvip.snappier.domain.component

import br.com.androidvip.snappier.domain.component.base.Content
import kotlinx.serialization.json.JsonObject

/**
 * This class is the entry point of the serialized "component" JSON.
 */
data class Component(
    val id: String,
    override val contents: List<Content>,
    override val parameters: JsonObject? = null
) : SnappierComponentData
