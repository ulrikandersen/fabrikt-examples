package dk.ulrikandersen.controllers

import dk.ulrikandersen.models.PetNetworkModel
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import java.util.concurrent.ConcurrentHashMap

@Controller
@Suppress("unused")
open class PetsControllerImpl : PetsController {
    private val pets = ConcurrentHashMap<String, PetNetworkModel>()

    init {
        pets["1"] = PetNetworkModel(1, "Fido")
        pets["2"] = PetNetworkModel(2, "Rex")
    }

    override fun listPets(limit: Int?): HttpResponse<List<PetNetworkModel>> {
        return HttpResponse.ok(pets.values.toList())
    }

    override fun createPets(pet: PetNetworkModel): HttpResponse<Unit> {
        pets[pet.id.toString()] = pet
        return HttpResponse.created(Unit)
    }

    override fun showPetById(petId: String): HttpResponse<PetNetworkModel> {
        return if (pets.containsKey(petId)) {
            HttpResponse.ok(pets[petId])
        } else {
            HttpResponse.notFound()
        }
    }
}
