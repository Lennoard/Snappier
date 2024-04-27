package br.com.androidvip.snappier.ui.component.data

import br.com.androidvip.snappier.domain.component.base.Constraints
import br.com.androidvip.snappier.domain.component.base.Event

data class ButtonData(
    val color: String = "#000000",
    val backgroundColor: String = "",
    val title: String = "",
    val border: BorderData? = null,
    val shadow: ShadowData? = null,
    val stroke: StrokeData? = null,
    val events: List<Event> = emptyList(),
    override val constraints: Constraints? = null,
    override val alignment: String? = null
) : BaseComponentData()
