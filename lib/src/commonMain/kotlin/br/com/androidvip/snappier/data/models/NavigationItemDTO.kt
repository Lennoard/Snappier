package br.com.androidvip.snappier.data.models

import br.com.androidvip.snappier.domain.entities.NavigationItem
import kotlinx.serialization.Serializable

@Serializable
data class NavigationItemDTO(
    override val action: ActionDTO? = null,
    override val label: String? = null,
    override val enabled: Boolean = true,
    override val icon: IconDTO? = null,
    override val color: String? = "#000000"
) : NavigationItem
