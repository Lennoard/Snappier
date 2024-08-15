package br.com.androidvip.snappier.data.models

import br.com.androidvip.snappier.domain.entities.FloatingActionButton
import kotlinx.serialization.Serializable

@Serializable
data class FloatingActionButtonDTO(
    override val color: String? = null,
    override val backgroundColor: String? = "#00000000",
    override val text: TextDTO? = null,
    override val icon: IconDTO? = null,
    override val border: BorderDTO? = null,
    override val shadow: ShadowDTO? = null,
    override val stroke: StrokeDTO? = null,
    override val constraints: ConstraintsDTO? = null,
    override val alignment: String? = null,
    override val events: List<EventDTO> = emptyList()
) : FloatingActionButton
