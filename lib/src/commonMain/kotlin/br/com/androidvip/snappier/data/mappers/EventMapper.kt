package br.com.androidvip.snappier.data.mappers

import br.com.androidvip.snappier.data.models.EventDTO
import br.com.androidvip.snappier.domain.component.base.Event

object EventMapper : BaseMapper<Event, EventDTO> {
    override fun map(dto: EventDTO): Event {
        return Event(
            action = ActionMapper.map(dto.action),
            trigger = dto.trigger,
            customTrigger = dto.customTrigger,
            extras = dto.extras
        )
    }
}
