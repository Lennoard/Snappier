package br.com.androidvip.snappier.data.mappers

import br.com.androidvip.snappier.data.models.VideoDTO
import br.com.androidvip.snappier.domain.component.data.VideoData

object VideoMapper : BaseMapper<VideoData, VideoDTO> {
    override fun map(dto: VideoDTO): VideoData {
        return VideoData(
            url = dto.url,
            description = dto.description.orEmpty(),
            resourceName = dto.resourceName.orEmpty(),
            autoPlay = dto.autoPlay,
            hideControls = dto.hideControls,
            events = dto.events.map(EventMapper::map)
        )
    }
}
