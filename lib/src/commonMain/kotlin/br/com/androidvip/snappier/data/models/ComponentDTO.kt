package br.com.androidvip.snappier.data.models

import br.com.androidvip.snappier.domain.component.Component
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

@Serializable
data class ComponentDTO(
    override val id: String = "",
    override val contents: List<ContentDTO> = emptyList(),
    override val parameters: JsonObject? = null
) : Component