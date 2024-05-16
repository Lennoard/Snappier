package br.com.androidvip.snappier.data.mappers

import br.com.androidvip.snappier.data.models.ActionDTO
import br.com.androidvip.snappier.domain.component.base.Action

object ActionMapper : BaseMapper<Action, ActionDTO> {
    override fun map(dto: ActionDTO): Action {
        return Action(
            data = dto.data,
            type = dto.type,
            extras = dto.extras
        )
    }
}
