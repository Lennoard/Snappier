package br.com.androidvip.snappier.data.mappers

import br.com.androidvip.snappier.data.models.StrokeDTO
import br.com.androidvip.snappier.domain.component.data.StrokeData

object StrokeMapper : BaseMapper<StrokeData, StrokeDTO> {
    override fun map(dto: StrokeDTO): StrokeData {
        return StrokeData(
            width = dto.width,
            color = dto.color,
        )
    }
}
