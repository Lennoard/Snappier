package br.com.androidvip.snappier.domain.component.base

enum class ActionType {
    LocalNavigation,
    OpenBrowser,
    NavigateUp,
    ShowShortMessage
    ;

    companion object {
        fun parse(name: String): ActionType? {
            return entries.firstOrNull { name.equals(it.name, ignoreCase = true) }
        }
    }
}
