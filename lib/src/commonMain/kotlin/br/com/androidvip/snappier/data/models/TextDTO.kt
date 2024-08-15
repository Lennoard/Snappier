package br.com.androidvip.snappier.data.models

import androidx.compose.ui.text.font.FontWeight
import br.com.androidvip.snappier.domain.entities.Text
import kotlinx.serialization.Serializable

@Serializable
data class TextDTO(
    override val text: String = "",
    override val color: String = "#000000",
    override val size: Float = 14F,
    override val weight: Int = FontWeight.Normal.weight,
    override val events: List<EventDTO> = emptyList(),
    override val constraints: ConstraintsDTO? = null,
    override val alignment: String? = null
) : Text
