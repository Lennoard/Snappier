package br.com.androidvip.snappier.data.mappers

import br.com.androidvip.snappier.data.models.CardDTO
import br.com.androidvip.snappier.domain.component.data.CardData

object CardMapper : BaseMapper<CardData, CardDTO> {
    override fun map(dto: CardDTO): CardData {
        return CardData(
            backgroundColor = dto.backgroundColor,
            content = ContentMapper.map(dto.content),
            events = dto.events.map(EventMapper::map),
            shadow = dto.shadow?.let(ShadowMapper::map),
            border = dto.border?.let(BorderMapper::map),
            stroke = dto.stroke?.let(StrokeMapper::map),
            constraints = dto.constraints?.let(ConstraintsMapper::map),
            alignment = dto.alignment
        )
    }
}
