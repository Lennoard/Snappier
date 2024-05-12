package br.com.androidvip.snappier.data.mappers

import br.com.androidvip.snappier.data.models.ContentDTO
import br.com.androidvip.snappier.domain.component.base.Content

object ContentMapper : BaseMapper<Content, ContentDTO> {
    override fun map(dto: ContentDTO): Content {
        return Content(
            description = dto.description,
            backgroundColor = dto.backgroundColor,
            foregroundColor = dto.foregroundColor,
            parameters = dto.parameters,
            scaffold = dto.scaffold?.let(ScaffoldMapper::map),
            stroke = dto.stroke?.let(StrokeMapper::map),
            shadow = dto.shadow?.let(ShadowMapper::map),
            border = dto.border?.let(BorderMapper::map),
            fab = dto.fab?.let(FloatingActionButtonMapper::map),
            constraints = dto.constraints?.let(ConstraintsMapper::map),
            images = dto.images?.map(ImageMapper::map),
            icons = dto.icons?.map(IconMapper::map),
            texts = dto.texts?.map(TextMapper::map),
            videos = dto.videos?.map(VideoMapper::map),
            cards = dto.cards?.map(CardMapper::map),
            buttons = dto.buttons?.map(ButtonMapper::map),
            events = dto.events?.map(EventMapper::map)
        )
    }
}
