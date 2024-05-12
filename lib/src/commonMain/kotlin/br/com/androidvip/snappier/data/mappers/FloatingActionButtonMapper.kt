package br.com.androidvip.snappier.data.mappers

import br.com.androidvip.snappier.data.models.FloatingActionButtonDTO
import br.com.androidvip.snappier.domain.component.data.FloatingActionButtonData

object FloatingActionButtonMapper : BaseMapper<FloatingActionButtonData, FloatingActionButtonDTO> {
    override fun map(dto: FloatingActionButtonDTO): FloatingActionButtonData {
        return FloatingActionButtonData(
            color = dto.color,
            backgroundColor = dto.backgroundColor.orEmpty(),
            text = dto.text?.let(TextMapper::map),
            events = dto.events.map(EventMapper::map),
            border = dto.border?.let(BorderMapper::map),
            shadow = dto.shadow?.let(ShadowMapper::map),
            stroke = dto.stroke?.let(StrokeMapper::map),
            icon = dto.icon?.let(IconMapper::map),
            constraints = dto.constraints?.let(ConstraintsMapper::map),
            alignment = dto.alignment
        )
    }
}
