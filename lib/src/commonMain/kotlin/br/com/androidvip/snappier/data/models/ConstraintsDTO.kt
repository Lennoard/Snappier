package br.com.androidvip.snappier.data.models

import br.com.androidvip.snappier.domain.component.base.Constraints
import kotlinx.serialization.Serializable

@Serializable
data class ConstraintsDTO(
    override val width: Float = Constraints.WRAP_CONTENT,
    override val height: Float = Constraints.WRAP_CONTENT,
    override val weight: Float = Constraints.DEFAULT_WEIGHT
) : Constraints
