package br.com.androidvip.snappier.domain.component.scaffold

import br.com.androidvip.snappier.domain.component.base.Constraints

interface Shadow {
    val elevation: Float
    val color: String
    val constraints: Constraints?
}
