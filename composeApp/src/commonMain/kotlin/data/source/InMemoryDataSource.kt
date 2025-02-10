package data.source

import br.com.androidvip.snappier.data.models.ActionDTO
import br.com.androidvip.snappier.data.models.ConstraintsDTO
import br.com.androidvip.snappier.data.models.ContentDTO
import br.com.androidvip.snappier.data.models.ElementDTO
import br.com.androidvip.snappier.data.models.EventDTO
import br.com.androidvip.snappier.data.models.FloatingActionButtonDTO
import br.com.androidvip.snappier.data.models.IconDTO
import br.com.androidvip.snappier.data.models.ScaffoldDTO
import br.com.androidvip.snappier.data.models.TextDTO
import br.com.androidvip.snappier.domain.component.base.ActionType
import br.com.androidvip.snappier.domain.component.base.Constraints
import br.com.androidvip.snappier.domain.component.base.Element
import br.com.androidvip.snappier.domain.component.base.EventTrigger
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

object InMemoryDataSource : SnappierDataSource {
    override fun getElementById(elementId: String): Flow<Element> {
        return flowOf(
            ElementDTO(
                id = "snappier_scaffold",
                contents = listOf(
                    ContentDTO(
                        scaffold = ScaffoldDTO(
                            elements = getScaffoldElements(elementId),
                            floatingElement = getFloatingScaffoldElement()
                        )
                    )
                )
            )
        )
    }

    private fun getScaffoldElements(elementId: String): List<ElementDTO> {
        return listOf(
            ElementDTO(
                id = "snappier_text",
                contents = listOf(
                    ContentDTO(
                        texts = listOf(
                            TextDTO(
                                text = "Scaffold content for '$elementId'!",
                                size = 48F,
                                fontWeight = 700,
                                alignment = "center",
                                constraints = ConstraintsDTO(width = Constraints.FILL_MAX)
                            )
                        )
                    )
                )
            )
        )
    }

    private fun getFloatingScaffoldElement(): ElementDTO {
        val refreshEvent = EventDTO(
            trigger = EventTrigger.OnClick,
            action = ActionDTO(
                data = "app://refresh",
                type = ActionType.LocalNavigation
            )
        )
        return ElementDTO(
            id = "snappier_fab",
            contents = listOf(
                ContentDTO(
                    fab = FloatingActionButtonDTO(
                        backgroundColor = "#EE32CC",
                        text = TextDTO(
                            text = "Refresh",
                            size = 16F,
                            color = "#123321"
                        ),
                        icon = IconDTO(
                            size = 24F,
                            token = "refresh",
                            color = "#00EEFA",
                            events = listOf(refreshEvent)
                        )
                    ),
                    events = listOf(refreshEvent)
                )
            )
        )
    }

}