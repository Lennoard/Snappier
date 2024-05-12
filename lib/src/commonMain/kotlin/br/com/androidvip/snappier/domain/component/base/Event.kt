package br.com.androidvip.snappier.domain.component.base

import kotlinx.serialization.json.JsonElement

data class Event(
    val action: Action,
    val trigger: EventTrigger? = null,
    val customTrigger: String? = null,
    val extras: JsonElement? = null
)
