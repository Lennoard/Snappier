package br.com.androidvip.snappier.data.mappers

import br.com.androidvip.snappier.data.models.ScaffoldDTO
import br.com.androidvip.snappier.domain.component.scaffold.ScaffoldData

object ScaffoldMapper : BaseMapper<ScaffoldData, ScaffoldDTO> {
    override fun map(dto: ScaffoldDTO): ScaffoldData {
        return ScaffoldData(
            topBar = dto.topBar?.let(TopBarMapper::map),
            bottomBar = dto.bottomBar?.let(BottomBarMapper::map),
            floatingComponent = dto.floatingComponent?.let(ComponentMapper::map),
            isNavigationDrawerLayout = dto.isNavigationDrawerLayout,
            navigationItems = dto.navigationItems?.map(NavigationItemMapper::map),
            parameters = dto.parameters,
            components = dto.components?.map(ComponentMapper::map)
        )
    }
}
