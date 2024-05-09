package br.com.androidvip.snappier.data.models

import kotlinx.serialization.Serializable

@Serializable
data class NavigationItemDTO(
    val action: ActionDTO? = null,
    val label: String? = null,
    val enabled: Boolean = true,
    val icon: IconDTO? = null,
    val color: String? = "#000000"
)
