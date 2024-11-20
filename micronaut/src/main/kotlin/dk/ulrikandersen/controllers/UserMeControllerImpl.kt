package dk.ulrikandersen.controllers

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.security.authentication.Authentication

@Controller
class UserMeControllerImpl : UserMeController {
    override fun userProfile(authentication: Authentication): HttpResponse<Unit> {
        return HttpResponse.noContent()
    }
}
