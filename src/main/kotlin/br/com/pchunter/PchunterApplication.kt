package br.com.pchunter

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PchunterApplication

fun main(args: Array<String>) {
	runApplication<PchunterApplication>(*args)
}
