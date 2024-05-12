package br.com.androidvip.snappier.domain.component.data

import br.com.androidvip.snappier.domain.component.base.Constraints
import br.com.androidvip.snappier.domain.component.base.Event

data class FloatingActionButtonData(
    val color: String? = null,
    val backgroundColor: String,
    val text: TextData? = null,
    val icon: IconData? = null,
    val border: BorderData? = null,
    val shadow: ShadowData? = null,
    val stroke: StrokeData? = null,
    val events: List<Event> = emptyList(),
    override val alignment: String? = null,
    override val constraints: Constraints? = null
) : BaseComponentData()
