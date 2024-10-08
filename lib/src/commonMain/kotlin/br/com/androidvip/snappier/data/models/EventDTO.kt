package br.com.androidvip.snappier.data.models

import br.com.androidvip.snappier.domain.component.base.Event
import br.com.androidvip.snappier.domain.component.base.EventTrigger
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@Serializable
data class EventDTO(
    override val action: ActionDTO = ActionDTO(),
    @Serializable(with = EventTriggerSerializer::class)
    override val trigger: EventTrigger? = null,
    override val customTrigger: String? = null
) : Event

object EventTriggerSerializer : KSerializer<EventTrigger?> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("EventTriggerSerializer", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: EventTrigger?) {
        encoder.encodeString(value?.name.orEmpty())
    }

    override fun deserialize(decoder: Decoder): EventTrigger? {
        return EventTrigger.parse(decoder.decodeString())
    }
}
