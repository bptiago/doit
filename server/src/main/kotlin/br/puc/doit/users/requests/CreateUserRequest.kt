package br.puc.doit.users.requests

import br.puc.doit.tasks.Task
import br.puc.doit.users.User
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class CreateUserRequest(
    @field:NotBlank
    val name: String,

    @field:NotNull
    @field:Email
    val email: String,

    @field:NotNull
    @field:Size(min=4)
    val password: String,

) {
    fun toUser() = User(
        name = name,
        email = email,
        password = password,
        tasks = mutableListOf()
    )
}