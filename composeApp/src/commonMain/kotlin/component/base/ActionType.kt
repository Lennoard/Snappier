package component.base

enum class ActionType {
    LocalNavigation,
    OpenBrowser,
    NavigateUp,
    ShowShortMessage,
    ;

    fun parse(name: String): ActionType? {
        return entries.firstOrNull { name.lowercase() == it.name.lowercase() }
    }
}
