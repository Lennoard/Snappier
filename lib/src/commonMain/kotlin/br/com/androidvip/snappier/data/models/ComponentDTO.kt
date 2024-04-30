package br.com.androidvip.snappier.data.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
data class ComponentDTO(
    val id: String,
    val contents: List<ContentDTO>,
    val parameters: JsonElement? = null
)
