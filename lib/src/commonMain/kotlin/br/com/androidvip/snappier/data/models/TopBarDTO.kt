package br.com.androidvip.snappier.data.models

import br.com.androidvip.snappier.domain.component.scaffold.TopBar
import kotlinx.serialization.Serializable

@Serializable
data class TopBarDTO(
    override val title: TextDTO? = null,
    override val backgroundColor: String? = null,
    override val navigationIcon: IconDTO? = null,
    override val icons: List<IconDTO>? = null,
    override val constraints: ConstraintsDTO? = null,
    override val alignment: String? = null
) : TopBar
