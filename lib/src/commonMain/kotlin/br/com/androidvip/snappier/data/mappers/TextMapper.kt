package br.com.androidvip.snappier.data.mappers

import br.com.androidvip.snappier.data.models.TextDTO
import br.com.androidvip.snappier.domain.component.data.TextData

object TextMapper : BaseMapper<TextData, TextDTO> {
    override fun map(dto: TextDTO): TextData {
        return TextData(
            text = dto.text,
            color = dto.color,
            size = dto.size,
            weight = dto.weight,
            alignment = dto.alignment,
            events = dto.events.map(EventMapper::map),
            constraints = dto.constraints?.let(ConstraintsMapper::map)
        )
    }
}
