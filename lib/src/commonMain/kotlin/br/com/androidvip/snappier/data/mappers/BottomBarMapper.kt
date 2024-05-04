package br.com.androidvip.snappier.data.mappers

import br.com.androidvip.snappier.data.models.BottomBarDTO
import br.com.androidvip.snappier.domain.component.scaffold.BottomBarData

object BottomBarMapper : BaseMapper<BottomBarData, BottomBarDTO> {
    override fun map(dto: BottomBarDTO): BottomBarData {
        return BottomBarData(
            backgroundColor = dto.backgroundColor,
            iconColor = dto.iconColor,
            selectedIconColor = dto.selectedIconColor.orEmpty(),
            alignment = dto.alignment,
            constraints = dto.constraints?.let(ConstraintsMapper::map)
        )
    }
}
