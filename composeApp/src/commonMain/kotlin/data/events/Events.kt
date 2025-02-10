package data.events

import br.com.androidvip.snappier.domain.component.base.Action
import br.com.androidvip.snappier.domain.component.base.EventTrigger
import br.com.androidvip.snappier.domain.component.base.SnappierEvent

fun genericEvent(action: Action): SnappierEvent = object : SnappierEvent {
    override val action: Action = action
    override val trigger: EventTrigger? = null
    override val customTrigger: String? = null
}