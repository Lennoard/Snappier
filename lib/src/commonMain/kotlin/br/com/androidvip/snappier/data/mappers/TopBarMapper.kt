package br.com.androidvip.snappier.data.mappers

import br.com.androidvip.snappier.data.models.TopBarDTO
import br.com.androidvip.snappier.domain.component.scaffold.TopBarData

object TopBarMapper : BaseMapper<TopBarData, TopBarDTO> {
    override fun map(dto: TopBarDTO): TopBarData {
        return TopBarData(
            title = dto.title?.let(TextMapper::map),
            backgroundColor = dto.backgroundColor.orEmpty(),
            navigationIcon = dto.navigationIcon?.let(IconMapper::map),
            constraints = dto.constraints?.let(ConstraintsMapper::map),
            alignment = dto.alignment,
            icons = dto.icons?.map(IconMapper::map)
        )
    }
}
