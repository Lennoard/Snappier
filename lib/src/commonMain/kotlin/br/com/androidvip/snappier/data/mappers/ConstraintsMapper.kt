package br.com.androidvip.snappier.data.mappers

import br.com.androidvip.snappier.data.models.ConstraintsDTO
import br.com.androidvip.snappier.domain.component.base.Constraints

object ConstraintsMapper : BaseMapper<Constraints, ConstraintsDTO> {
    override fun map(dto: ConstraintsDTO): Constraints {
        return Constraints(dto.width, dto.height, dto.weight)
    }
}
