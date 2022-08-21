package uk.ac.warwick.cloud.prototype

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.beans.factory.annotation.Value

@SpringBootApplication
@RestController
class PrototypeApplication {

	@Value("\${app.message}")
	lateinit var message: String

	@Value("\${app.deployment}")
	lateinit var deployment: String

	@GetMapping("/")
	fun home() = mapOf(
		"message" to message,
		"deployment" to deployment
	)

}

fun main(args: Array<String>) {
	runApplication<PrototypeApplication>(*args)
}
