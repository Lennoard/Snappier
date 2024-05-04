package br.com.androidvip.snappier.data.mappers

import br.com.androidvip.snappier.data.models.IconDTO
import br.com.androidvip.snappier.domain.component.data.IconData

object IconMapper : BaseMapper<IconData, IconDTO> {
    override fun map(dto: IconDTO): IconData {
        return IconData(
            size = dto.size,
            token = dto.token,
            color = dto.color,
            description = dto.description,
            events = dto.events.map(EventMapper::map)
        )
    }
}
