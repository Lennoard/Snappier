package br.com.androidvip.snappier.data.models

import br.com.androidvip.snappier.domain.component.base.ActionType
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonObject

@Serializable
data class ActionDTO(
    val data: String = "",
    @Serializable(with = ActionTypeSerializer::class)
    val type: ActionType? = null,
    val extras: JsonObject? = null
)

object ActionTypeSerializer : KSerializer<ActionType?> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("ActionTypeSerializer", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: ActionType?) {
        encoder.encodeString(value?.name.orEmpty())
    }

    override fun deserialize(decoder: Decoder): ActionType? {
        return ActionType.parse(decoder.decodeString())
    }
}
