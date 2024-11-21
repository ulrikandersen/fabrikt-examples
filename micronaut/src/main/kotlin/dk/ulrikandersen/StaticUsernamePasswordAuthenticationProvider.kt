package dk.ulrikandersen

import io.micronaut.http.HttpRequest
import io.micronaut.security.authentication.AuthenticationRequest
import io.micronaut.security.authentication.AuthenticationResponse
import io.micronaut.security.authentication.provider.HttpRequestAuthenticationProvider
import jakarta.inject.Singleton

@Singleton
@Suppress("unused")
class StaticUsernamePasswordAuthenticationProvider<B> : HttpRequestAuthenticationProvider<B> {

    override fun authenticate(
        httpRequest: HttpRequest<B>?,
        authenticationRequest: AuthenticationRequest<String, String>
    ): AuthenticationResponse {
        return if (authenticationRequest.identity == "test" && authenticationRequest.secret == "test") {
            AuthenticationResponse.success(authenticationRequest.identity)
        } else {
            AuthenticationResponse.failure("Invalid username or password")
        }
    }
}
