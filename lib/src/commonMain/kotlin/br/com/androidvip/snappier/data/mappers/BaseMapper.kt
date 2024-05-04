package br.com.androidvip.snappier.data.mappers

internal fun interface BaseMapper<T, DTO> {
    fun map(dto: DTO): T
}
