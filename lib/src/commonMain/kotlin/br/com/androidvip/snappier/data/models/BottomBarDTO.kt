package br.com.androidvip.snappier.data.models

import br.com.androidvip.snappier.domain.component.scaffold.BottomBar
import kotlinx.serialization.Serializable

@Serializable
data class BottomBarDTO(
    override val backgroundColor: String? = null,
    override val iconColor: String? = null,
    override val selectedIconColor: String? = null,
    override val constraints: ConstraintsDTO? = null,
    override val alignment: String? = null
) : BottomBar
