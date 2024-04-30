package br.com.androidvip.snappier.data.models

import androidx.compose.ui.text.font.FontWeight
import kotlinx.serialization.Serializable

@Serializable
data class TextDTO(
    val text: String = "",
    val color: String = "#000000",
    val size: Float = 14F,
    val weight: Int = FontWeight.Normal.weight,
    val events: List<EventDTO> = emptyList(),
    val constraints: ConstraintsDTO? = null,
    val alignment: String? = null
)
