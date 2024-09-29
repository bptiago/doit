package br.puc.doit.tasks.requests

import br.puc.doit.tasks.Task
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Null

data class CreateTaskRequest(
    @field:NotBlank
    val description: String,

    @field:NotNull
    val complete: Boolean = false,

    @field:Null
    val id: Long,

    @field:NotNull
    val email: String

    ) {
    fun toTask() = Task(
        id = id,
        description = description,
        complete = complete,
    )
}