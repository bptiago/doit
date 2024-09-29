package br.puc.doit.tasks

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.jetbrains.annotations.NotNull

@Entity
@Table
class Task (
    @Id
    var id: Long,

    @NotNull
    var description: String,

    @NotNull
    var isComplete: Boolean = false
)