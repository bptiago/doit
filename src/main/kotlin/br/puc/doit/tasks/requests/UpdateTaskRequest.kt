package br.puc.doit.tasks.requests

import jakarta.validation.constraints.NotBlank

data class UpdateTaskRequest(
    @field:NotBlank
    val description: String?,

    @field:NotBlank
    val complete: Boolean?
)