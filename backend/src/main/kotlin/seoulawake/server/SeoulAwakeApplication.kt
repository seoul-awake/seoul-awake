package seoulawake.server

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@EnableJpaAuditing
@SpringBootApplication
class SeoulAwakeApplication

fun main(args: Array<String>) {
  runApplication<SeoulAwakeApplication>(*args)
}
