package br.com.androidvip.snappier.domain.component.base

interface Action {
    val data: String
    val type: ActionType?
    val extras: Map<String, Any>?
}
