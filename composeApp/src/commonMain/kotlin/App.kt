import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import component.base.Action
import component.base.ActionType
import component.base.Component
import component.base.Content
import component.base.Event
import component.base.EventTrigger
import component.data.ButtonData
import component.data.IconData
import component.data.TextData
import component.scaffold.NavigationItem
import component.scaffold.ScaffoldData
import component.scaffold.TopBarData
import engine.EventObserver
import engine.Snappier
import engine.SnappierComponentRegisterer
import org.jetbrains.compose.ui.tooling.preview.Preview
import ui.component.SnappierButtonComponent
import ui.component.SnappierScaffoldComponent

@Composable
@Preview
fun App() {
    SnappierComponentRegisterer.register(SnappierButtonComponent())
    SnappierComponentRegisterer.register(SnappierScaffoldComponent())

    val observer = EventObserver {
        println(it.toString())
    }

    MaterialTheme {
        val data = Component(
            id = "snappier_scaffold",
            contents = listOf(
                Content(
                    scaffold = ScaffoldData(
                        floatingComponent = Component(
                            id = "snappier_button",
                            contents = listOf(
                                Content(
                                    buttons = listOf(
                                        ButtonData(
                                            color = "#cfda10",
                                            backgroundColor = "#313131",
                                            title = "Floating content",
                                            events = listOf(
                                                Event(
                                                    trigger = EventTrigger.OnClick,
                                                    action = Action(
                                                        data = "app://settings",
                                                        type = ActionType.LocalNavigation
                                                    )
                                                )
                                            )
                                        )
                                    )
                                )
                            )
                        ),
                        isNavigationDrawerLayout = true,
                        topBar = TopBarData(
                            backgroundColor = "#ff9800",
                            title = TextData(
                                text = "Top Bar App Name",
                                size = 24F,
                                weight = 700,
                                color = "#000000"
                            ),
                            icons = listOf(
                                IconData(
                                    size = 24F,
                                    token = "favorite",
                                    color = "#00eeFa",
                                    events = listOf(
                                        Event(
                                            trigger = EventTrigger.OnClick,
                                            action = Action(
                                                data = "app://favorite",
                                                type = ActionType.LocalNavigation
                                            )
                                        )
                                    )
                                ),
                                IconData(
                                    size = 24F,
                                    token = "settings",
                                    color = "#323232",
                                    events = listOf(
                                        Event(
                                            trigger = EventTrigger.OnClick,
                                            action = Action(
                                                data = "app://settings",
                                                type = ActionType.LocalNavigation
                                            )
                                        )
                                    )
                                ),
                                IconData(
                                    size = 24F,
                                    token = "phone",
                                    color = "#000000",
                                    events = listOf(
                                        Event(
                                            trigger = EventTrigger.OnClick,
                                            action = Action(
                                                data = "app://call",
                                                type = ActionType.LocalNavigation
                                            )
                                        )
                                    )
                                )
                            ),
                            navigationIcon = IconData(
                                size = 24F,
                                token = "menu",
                                color = "#1A9a32"
                            )
                        ),
                        navigationItems = listOf(
                            NavigationItem(
                                action = Action(),
                                label = "Screen 1",
                                color = "#123456",
                                icon = IconData(
                                    size = 32F,
                                    token = "home",
                                    color = "#987654"
                                )
                            ),
                            NavigationItem(
                                action = Action(),
                                label = "Screen 2",
                                color = "#123456",
                                icon = IconData(
                                    size = 32F,
                                    token = "build",
                                    color = "#987314"
                                )
                            ),
                            NavigationItem(
                                action = Action(),
                                label = "Screen 3",
                                color = "#123456",
                                icon = IconData(
                                    size = 32F,
                                    token = "cart",
                                    color = "#374865"
                                )
                            ),
                            NavigationItem(
                                action = Action(),
                                label = "Screen 4",
                                color = "#A2C594",
                                icon = IconData(
                                    size = 32F,
                                    token = "settings",
                                    color = "#F9C4A4"
                                )
                            ),
                            NavigationItem(
                                action = Action(),
                                label = "Screen 5",
                                color = "#AA225A",
                                icon = IconData(
                                    size = 32F,
                                    token = "person",
                                    color = "#CC6969"
                                )
                            )
                        )
                    )
                )
            )
        )

        Snappier().apply {
            customObserver = observer
            draw(data)
        }
    }
}
