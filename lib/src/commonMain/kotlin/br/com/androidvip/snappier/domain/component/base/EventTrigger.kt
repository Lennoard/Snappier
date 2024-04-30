package br.com.androidvip.snappier.domain.component.base

enum class EventTrigger {
    OnClick,
    OnLongCLick,
    OnDraw,
    SelectionChanged;

    companion object {
        fun parse(name: String): EventTrigger? {
            return entries.firstOrNull { name.lowercase() == it.name.lowercase() }
        }
    }
}
