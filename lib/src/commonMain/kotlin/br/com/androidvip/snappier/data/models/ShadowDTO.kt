package br.com.androidvip.snappier.data.models

import br.com.androidvip.snappier.domain.component.scaffold.Shadow
import kotlinx.serialization.Serializable

@Serializable
data class ShadowDTO(
    override val elevation: Float = 0F,
    override val color: String = "#000000",
    override val constraints: ConstraintsDTO? = null
) : Shadow
