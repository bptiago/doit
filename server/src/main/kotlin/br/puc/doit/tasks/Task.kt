package br.puc.doit.tasks

import br.puc.doit.users.User
import jakarta.persistence.*
import org.jetbrains.annotations.NotNull

@Entity
@Table
class Task (
    @Id @GeneratedValue
    var id: Long?,

    @NotNull
    var description: String,

    @NotNull
    var complete: Boolean = false

)