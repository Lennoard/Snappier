package br.com.androidvip.snappier.data.mappers

import br.com.androidvip.snappier.data.models.ComponentDTO
import br.com.androidvip.snappier.domain.component.Component

object ComponentMapper : BaseMapper<Component, ComponentDTO> {
    override fun map(dto: ComponentDTO): Component {
        return Component(
            id = dto.id,
            contents = dto.contents.map(ContentMapper::map),
            parameters = dto.parameters
        )
    }
}
