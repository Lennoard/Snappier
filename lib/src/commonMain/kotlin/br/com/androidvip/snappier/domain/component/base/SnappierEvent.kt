package br.com.androidvip.snappier.domain.component.base

interface SnappierEvent {
    val action: Action
    val trigger: EventTrigger?
    val customTrigger: String?
}

fun onClickEvent(action: Action): SnappierEvent = object : SnappierEvent {
    override val action = action
    override val trigger = EventTrigger.OnClick
    override val customTrigger = null
}
