package br.com.androidvip.snappier.data.mappers

import br.com.androidvip.snappier.data.models.ImageDTO
import br.com.androidvip.snappier.domain.component.data.ImageData

object ImageMapper : BaseMapper<ImageData, ImageDTO> {
    override fun map(dto: ImageDTO): ImageData {
        return ImageData(
            url = dto.url,
            description = dto.description,
            resourceName = dto.resourceName,
            scaleType = dto.scaleType,
            events = dto.events.map(EventMapper::map),
            border = dto.border?.let(BorderMapper::map),
            stroke = dto.stroke?.let(StrokeMapper::map),
            constraints = dto.constraints?.let(ConstraintsMapper::map),
            alignment = dto.alignment
        )
    }
}
