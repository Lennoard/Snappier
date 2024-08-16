package br.com.androidvip.snappier.data.models

import br.com.androidvip.snappier.domain.component.Element
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

@Serializable
data class ElementDTO(
    override val id: String = "",
    override val contents: List<ContentDTO> = emptyList(),
    override val parameters: JsonObject? = null
) : Element