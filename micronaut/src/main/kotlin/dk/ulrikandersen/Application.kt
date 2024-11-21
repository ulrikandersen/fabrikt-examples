package dk.ulrikandersen

import dk.ulrikandersen.models.ImageNetworkModel
import dk.ulrikandersen.models.MediaNetworkModel
import dk.ulrikandersen.models.PetNetworkModel
import dk.ulrikandersen.models.UserProfileNetworkModel
import dk.ulrikandersen.models.UserProfileNetworkModelOnboardingStatusNetworkModel
import dk.ulrikandersen.models.VideoNetworkModel
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

@SerdeImport(PetNetworkModel::class)
@SerdeImport(UserProfileNetworkModel::class)
@SerdeImport(UserProfileNetworkModelOnboardingStatusNetworkModel::class)
@SerdeImport(MediaNetworkModel::class)
@SerdeImport(ImageNetworkModel::class)
@SerdeImport(VideoNetworkModel::class)
@SerdeImport(Unit::class)
@Suppress("unused")
object Application

fun main(args: Array<String>) {
	run(*args)
}
