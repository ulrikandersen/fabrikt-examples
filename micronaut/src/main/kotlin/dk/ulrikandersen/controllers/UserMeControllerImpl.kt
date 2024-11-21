package dk.ulrikandersen.controllers

import dk.ulrikandersen.models.UserProfileNetworkModel
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.security.authentication.Authentication

@Controller
class UserMeControllerImpl : UserMeController {
    override fun userProfile(authentication: Authentication): HttpResponse<UserProfileNetworkModel> {
        return HttpResponse.ok(UserProfileNetworkModel(
            name = "John Doe",
            email = "john@doe.dev",
        ))
    }
}
