package br.com.androidvip.snappier.data.models

import br.com.androidvip.snappier.domain.entities.Stroke
import kotlinx.serialization.Serializable

@Serializable
data class StrokeDTO(
    override val width: Float = 0F,
    override val color: String = "#000000"
) : Stroke
