package br.puc.doit.tasks

import br.puc.doit.tasks.requests.CreateTaskRequest
import br.puc.doit.tasks.requests.UpdateTaskRequest
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/tasks")
class TaskController (val service: TaskService) {

    @PostMapping
    fun insert(@RequestBody @Valid task: CreateTaskRequest) =
        service.insert(task.toTask(), task.email)
            .let { ResponseEntity.status(HttpStatus.CREATED).body(it) }

    @GetMapping
    fun list() = service.list().let { ResponseEntity.ok() }

    @GetMapping("/user/{email}")
    fun findUserTasks(@PathVariable email: String) {
        service.findUserTasks(email).let { ResponseEntity.ok(it) }
    }

    @PatchMapping("/desc/{id}")
    fun updateDescription(@PathVariable id:Long, @RequestBody @Valid updateTaskRequest: UpdateTaskRequest) =
        service.updateDescription(id, updateTaskRequest.description!!)
            ?.let { ResponseEntity.ok(it) }
            ?: ResponseEntity.noContent().build()

    @PatchMapping("/status/{id}")
    fun updateStatus(@PathVariable id: Long, @RequestBody @Valid updateTaskRequest: UpdateTaskRequest) {
        service.updateStatus(id, updateTaskRequest.complete!!)
            ?.let { ResponseEntity.ok(it) }
            ?: ResponseEntity.noContent().build()
    }
}