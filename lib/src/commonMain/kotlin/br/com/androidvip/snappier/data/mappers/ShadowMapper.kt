package br.com.androidvip.snappier.data.mappers

import br.com.androidvip.snappier.data.models.ShadowDTO
import br.com.androidvip.snappier.domain.component.data.ShadowData

object ShadowMapper : BaseMapper<ShadowData, ShadowDTO> {
    override fun map(dto: ShadowDTO): ShadowData {
        return ShadowData(
            elevation = dto.elevation,
            color = dto.color
        )
    }
}
