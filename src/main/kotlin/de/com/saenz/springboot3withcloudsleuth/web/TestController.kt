package de.com.saenz.springboot3withcloudsleuth.web

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController {

    val log: Logger = LoggerFactory.getLogger(TestController::class.java)
    @GetMapping("/hello")
    fun index(@RequestParam("name") name: String): String {
        log.info("hello controller requested")
        return "Hello, $name!"
    }
}