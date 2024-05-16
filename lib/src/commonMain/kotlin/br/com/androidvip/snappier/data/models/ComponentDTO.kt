package br.com.androidvip.snappier.data.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

@Serializable
data class ComponentDTO(
    val id: String = "",
    val contents: List<ContentDTO> = emptyList(),
    val parameters: JsonObject? = null
)
