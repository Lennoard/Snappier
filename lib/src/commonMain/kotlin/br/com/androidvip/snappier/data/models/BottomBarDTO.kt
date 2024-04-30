package br.com.androidvip.snappier.data.models

import kotlinx.serialization.Serializable

@Serializable
data class BottomBarDTO(
    val backgroundColor: String? = null,
    val iconColor: String? = null,
    val selectedIconColor: String? = null,
    val constraints: ConstraintsDTO? = null,
    val alignment: String? = null
)
