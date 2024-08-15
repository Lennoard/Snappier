package br.com.androidvip.snappier.domain.component.base

interface Event {
    val action: Action
    val trigger: EventTrigger?
    val customTrigger: String?
}

fun onClickEvent(action: Action): Event = object : Event {
    override val action = action
    override val trigger = EventTrigger.OnClick
    override val customTrigger = null
}
