package br.com.androidvip.snappier.data.models

import br.com.androidvip.snappier.domain.entities.Border
import kotlinx.serialization.Serializable

@Serializable
data class BorderDTO(
    override val topLeft: Float = 0F,
    override val topRight: Float = 0F,
    override val bottomRight: Float = 0F,
    override val bottomLeft: Float = 0F,
    override val percent: Float? = null
) : Border
