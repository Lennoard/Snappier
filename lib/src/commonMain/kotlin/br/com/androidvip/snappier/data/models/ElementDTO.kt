package br.com.androidvip.snappier.data.models

import br.com.androidvip.snappier.domain.component.base.Element
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

@Serializable
open class ElementDTO(
    override val id: String = "",
    override val contents: List<ContentDTO> = emptyList(),
    override val parameters: JsonObject? = null
) : Element
