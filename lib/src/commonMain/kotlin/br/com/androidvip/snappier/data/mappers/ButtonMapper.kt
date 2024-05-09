package br.com.androidvip.snappier.data.mappers

import br.com.androidvip.snappier.data.models.ButtonDTO
import br.com.androidvip.snappier.domain.component.data.ButtonData

object ButtonMapper : BaseMapper<ButtonData, ButtonDTO> {
    override fun map(dto: ButtonDTO): ButtonData {
        return ButtonData(
            color = dto.color,
            backgroundColor = dto.backgroundColor,
            title = dto.title,
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
