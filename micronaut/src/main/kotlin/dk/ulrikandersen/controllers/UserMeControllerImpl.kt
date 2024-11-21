package dk.ulrikandersen.controllers

import dk.ulrikandersen.models.ImageNetworkModel
import dk.ulrikandersen.models.UserProfileNetworkModel
import dk.ulrikandersen.models.UserProfileNetworkModelOnboardingStatusNetworkModel
import dk.ulrikandersen.models.UserProfileNetworkModelOnboardingStatusNetworkModel.PARTIALLY_ONBOARDED
import dk.ulrikandersen.models.VideoNetworkModel
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.security.authentication.Authentication
import java.net.URI

@Controller
class UserMeControllerImpl : UserMeController {
    override fun userProfile(authentication: Authentication): HttpResponse<UserProfileNetworkModel> {
        return HttpResponse.ok(UserProfileNetworkModel(
            name = "John Doe",
            email = "john@doe.dev",
            onboardingStatus = PARTIALLY_ONBOARDED,
            uploadedMedia = listOf(
                ImageNetworkModel(
                    url = URI("https://placekitten.com/200/300"),
                ),
                VideoNetworkModel(
                    url = URI("https://www.youtube.com/watch?v=dQw4w9WgXcQ"),
                    duration = 121,
                ),
            )
        ))
    }
}
