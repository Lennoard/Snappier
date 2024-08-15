package br.com.androidvip.snappier.data.models

import br.com.androidvip.snappier.domain.entities.Button
import kotlinx.serialization.Serializable

@Serializable
data class ButtonDTO(
    override val color: String = "#FFFFFF",
    override val backgroundColor: String = "#000000",
    override val title: String = "",
    override val border: BorderDTO? = null,
    override val shadow: ShadowDTO? = null,
    override val stroke: StrokeDTO? = null,
    override val icon: IconDTO? = null,
    override val constraints: ConstraintsDTO? = null,
    override val alignment: String? = null,
    override val events: List<EventDTO> = emptyList()
) : Button
