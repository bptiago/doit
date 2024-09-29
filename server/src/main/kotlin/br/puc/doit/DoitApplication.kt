package br.puc.doit

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DoitApplication

fun main(args: Array<String>) {
	runApplication<DoitApplication>(*args)
}
