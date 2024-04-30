package br.com.androidvip.snappier.data.models

import kotlinx.serialization.Serializable

@Serializable
data class TopBarDTO(
    val title: TextDTO? = null,
    val backgroundColor: String? = null,
    val navigationIcon: IconDTO? = null,
    val icons: List<IconDTO>? = null,
    val constraints: ConstraintsDTO? = null,
    val alignment: String? = null
)
