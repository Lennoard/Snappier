package component.base

enum class EventTrigger {
    OnClick,
    OnLongCLick,
    OnDraw;

    fun parse(name: String): EventTrigger? {
        return entries.firstOrNull { name.lowercase() == it.name.lowercase() }
    }
}
