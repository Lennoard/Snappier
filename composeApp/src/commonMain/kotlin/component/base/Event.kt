package component.base

data class Event(
    val trigger: EventTrigger? = null,
    val action: Action,
)
