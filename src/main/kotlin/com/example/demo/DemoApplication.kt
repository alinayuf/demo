package com.example.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.web.bind.annotation.*
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
	runApplication<DemoApplication>(*args)
}

@Entity
@Table(name = "events")
class EventEntity {
	@Id
	var id: Long = 0
	var text: String? = null
}

interface EventRepository: PagingAndSortingRepository<EventEntity, Long>

@RestController
@RequestMapping("/events")
class EventController(val repository: EventRepository) {

	@GetMapping
	fun list() = repository.findAll()

	@PostMapping
	fun save(@RequestParam("id") id: Long, @RequestParam("text") text: String) {
		repository.save(EventEntity().apply { this.id = id; this.text = text })
	}
}
