package kronecker.serializers

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kronecker.LoadOptions
import kronecker.internal.LoadOptionsImpl

@Serializable
object LoadOptionsSerializer : KSerializer<LoadOptions> {
    override val descriptor: SerialDescriptor = buildClassSerialDescriptor(
        serialName = "kronecker.LoadOptions"
    )

    private val serializer by lazy {
        LoadOptionsImpl.serializer()
    }

    override fun deserialize(decoder: Decoder): LoadOptions {
        return decoder.decodeSerializableValue(serializer)
    }

    override fun serialize(encoder: Encoder, value: LoadOptions) = encoder.encodeSerializableValue(
        serializer, value as LoadOptionsImpl
    )
}