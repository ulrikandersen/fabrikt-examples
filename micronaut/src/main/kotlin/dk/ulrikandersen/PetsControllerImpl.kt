package dk.ulrikandersen

import dk.ulrikandersen.controllers.PetsController
import dk.ulrikandersen.models.Pet
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import java.util.concurrent.ConcurrentHashMap

@Controller
@Suppress("unused")
open class PetsControllerImpl : PetsController {
    private val pets = ConcurrentHashMap<String, Pet>()

    init {
        pets["1"] = Pet(1, "Fido")
        pets["2"] = Pet(2, "Rex")
    }

    override fun listPets(limit: Int?): HttpResponse<List<Pet>> {
        return HttpResponse.ok(pets.values.toList())
    }

    override fun createPets(pet: Pet): HttpResponse<Unit> {
        pets[pet.id.toString()] = pet
        return HttpResponse.created(Unit)
    }

    override fun showPetById(petId: String): HttpResponse<Pet> {
        return if (pets.containsKey(petId)) {
            HttpResponse.ok(pets[petId])
        } else {
            HttpResponse.notFound()
        }
    }
}
