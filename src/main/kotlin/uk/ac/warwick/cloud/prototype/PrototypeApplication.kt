package uk.ac.warwick.cloud.prototype

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.MediaType

@SpringBootApplication
@RestController
class PrototypeApplication {

	@Value("\${app.message}")
	lateinit var message: String

	@Value("\${app.deployment}")
	lateinit var deployment: String

	@GetMapping("/", produces = [ MediaType.APPLICATION_JSON_VALUE ])
	fun home() = mapOf(
		"message" to message,
		"deployment" to deployment
	)

}

fun main(args: Array<String>) {
	runApplication<PrototypeApplication>(*args)
}
