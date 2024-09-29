package br.puc.doit.users

import br.puc.doit.tasks.Task
import jakarta.persistence.*
import org.jetbrains.annotations.NotNull

@Entity
@Table(name = "tbUser")
class User (
    @Id
    var email: String,

    @NotNull
    var name: String,

    @NotNull
    var password: String,

    @OneToMany(cascade = arrayOf(CascadeType.ALL))
    @JoinColumn(name = "fk_user_email", referencedColumnName = "email")
    var tasks: List<Task>
)