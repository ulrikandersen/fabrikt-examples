package dk.ulrikandersen

import dk.ulrikandersen.models.Pet
import io.micronaut.core.type.Argument
import io.micronaut.runtime.Micronaut.run
import io.micronaut.serde.Decoder
import io.micronaut.serde.Deserializer
import io.micronaut.serde.Encoder
import io.micronaut.serde.Serde
import io.micronaut.serde.Serializer
import io.micronaut.serde.annotation.SerdeImport
import jakarta.inject.Singleton

@Singleton
@Suppress("unused")
class UnitSerializer : Serde<Unit> {
	override fun serialize(
		encoder: Encoder?,
		context: Serializer.EncoderContext?,
		type: Argument<out Unit>?,
		value: Unit?
	) {
		// Unit means we return an empty string
	}

	override fun deserialize(decoder: Decoder?, context: Deserializer.DecoderContext?, type: Argument<in Unit>?) {
		// nothing
	}
}

@SerdeImport(Pet::class)
@SerdeImport(Unit::class)
@Suppress("unused")
object Application

fun main(args: Array<String>) {
	run(*args)
}
