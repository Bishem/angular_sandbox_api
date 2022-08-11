package fr.diginamic.taskboard

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TaskboardApplication

fun main(args: Array<String>) {
	runApplication<TaskboardApplication>(*args)
}
