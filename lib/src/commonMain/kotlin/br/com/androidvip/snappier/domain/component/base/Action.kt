package br.com.androidvip.snappier.domain.component.base

import kotlinx.serialization.json.JsonObject

data class Action(
    val data: String = "",
    val type: ActionType? = null,
    val extras: JsonObject? = null
)
