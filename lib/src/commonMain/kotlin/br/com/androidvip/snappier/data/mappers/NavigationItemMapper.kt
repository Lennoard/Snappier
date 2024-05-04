package br.com.androidvip.snappier.data.mappers

import br.com.androidvip.snappier.data.models.NavigationItemDTO
import br.com.androidvip.snappier.domain.component.scaffold.NavigationItem

object NavigationItemMapper : BaseMapper<NavigationItem, NavigationItemDTO> {
    override fun map(dto: NavigationItemDTO): NavigationItem {
        return NavigationItem(
            color = dto.color,
            label = dto.label,
            enabled = dto.enabled,
            icon = dto.icon?.let(IconMapper::map),
            action = dto.action?.let(ActionMapper::map)
        )
    }
}
