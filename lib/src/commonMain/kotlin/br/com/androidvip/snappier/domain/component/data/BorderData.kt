package br.com.androidvip.snappier.domain.component.data

data class BorderData(
    val topLeft: Float,
    val topRight: Float,
    val bottomRight: Float,
    val bottomLeft: Float,
    val percent: Float? = null
) : BaseComponentData()
