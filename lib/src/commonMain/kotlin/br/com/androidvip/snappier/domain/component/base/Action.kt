package br.com.androidvip.snappier.domain.component.base

import kotlinx.serialization.json.JsonObject

interface Action {
    val data: String
    val type: ActionType?
    val extras: JsonObject?
}
