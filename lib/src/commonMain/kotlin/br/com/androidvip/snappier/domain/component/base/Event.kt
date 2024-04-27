package br.com.androidvip.snappier.domain.component.base

data class Event(
    val action: Action,
    val trigger: EventTrigger? = null,
    val customTrigger: String? = null
)
