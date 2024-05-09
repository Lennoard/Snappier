package br.com.androidvip.snappier.data.mappers

import br.com.androidvip.snappier.data.models.BorderDTO
import br.com.androidvip.snappier.domain.component.data.BorderData

object BorderMapper : BaseMapper<BorderData, BorderDTO> {
    override fun map(dto: BorderDTO): BorderData {
        return BorderData(
            topLeft = dto.topLeft,
            topRight = dto.topRight,
            bottomRight = dto.bottomRight,
            bottomLeft = dto.bottomLeft,
            percent = dto.percent
        )
    }
}
