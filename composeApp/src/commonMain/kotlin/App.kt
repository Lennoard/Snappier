
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import br.com.androidvip.snappier.Snappier
import br.com.androidvip.snappier.domain.communication.EventObserver
import br.com.androidvip.snappier.domain.component.Component
import br.com.androidvip.snappier.domain.component.base.Action
import br.com.androidvip.snappier.domain.component.base.ActionType
import br.com.androidvip.snappier.domain.component.base.Constraints
import br.com.androidvip.snappier.domain.component.base.Content
import br.com.androidvip.snappier.domain.component.base.Event
import br.com.androidvip.snappier.domain.component.base.EventTrigger
import br.com.androidvip.snappier.domain.component.scaffold.NavigationItem
import br.com.androidvip.snappier.domain.component.scaffold.ScaffoldData
import br.com.androidvip.snappier.domain.component.scaffold.TopBarData
import br.com.androidvip.snappier.ui.component.SnappierButtonComponent
import br.com.androidvip.snappier.ui.component.SnappierCardComponent
import br.com.androidvip.snappier.ui.component.SnappierIconComponent
import br.com.androidvip.snappier.ui.component.SnappierImageComponent
import br.com.androidvip.snappier.ui.component.SnappierScaffoldComponent
import br.com.androidvip.snappier.ui.component.SnappierTextComponent
import br.com.androidvip.snappier.ui.component.data.ButtonData
import br.com.androidvip.snappier.ui.component.data.IconData
import br.com.androidvip.snappier.ui.component.data.TextData
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    val snappier = Snappier().apply {
        register(SnappierButtonComponent())
        register(SnappierScaffoldComponent())
        register(SnappierCardComponent())
        register(SnappierImageComponent())
        register(SnappierTextComponent())
        register(SnappierIconComponent())

        customObserver = EventObserver {
            println(it.toString())
        }
    }

    MaterialTheme {
        // Sample content data
        val data = Component(
            id = "snappier_scaffold",
            contents = listOf(
                Content(
                    scaffold = ScaffoldData(
                        components = listOf(
                            Component(
                                id = SnappierTextComponent.ID,
                                contents = listOf(
                                    Content(
                                        texts = listOf(
                                            TextData(
                                                text = "Scaffold content!",
                                                size = 48F,
                                                weight = FontWeight.Medium.weight,
                                                alignment = "center",
                                                constraints = Constraints(
                                                    width = Constraints.FILL_MAX
                                                )
                                            )
                                        )
                                    )
                                )
                            )
                        ),
                        floatingComponent = Component(
                            id = SnappierButtonComponent.ID,
                            contents = listOf(
                                Content(
                                    events = listOf(
                                        Event(
                                            trigger = EventTrigger.OnClick,
                                            action = Action(
                                                data = "app://do-something",
                                                type = ActionType.LocalNavigation
                                            )
                                        )
                                    ),
                                    buttons = listOf(
                                        ButtonData(
                                            color = "#cfda10",
                                            backgroundColor = "#313131",
                                            title = "Floating content",
                                            events = listOf(
                                                Event(
                                                    trigger = EventTrigger.OnClick,
                                                    action = Action(
                                                        data = "app://do-something",
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
                                color = "#654321",
                                icon = IconData(
                                    size = 32F,
                                    token = "home",
                                    color = "#987654"
                                )
                            ),
                            NavigationItem(
                                action = Action(),
                                label = "Screen 2",
                                color = "#420690",
                                icon = IconData(
                                    size = 32F,
                                    token = "build",
                                    color = "#987314"
                                )
                            )
                        )
                    )
                )
            )
        )

        snappier.draw(data)
    }
}
