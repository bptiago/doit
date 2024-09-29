package br.puc.doit.tasks

import br.puc.doit.errors.NotFoundException
import br.puc.doit.users.User
import br.puc.doit.users.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class TaskService (
    private val repository: TaskRepository,
    private val userRepository: UserRepository
) {
    fun insert(task: Task, email: String): User {
        val user = userRepository.findByEmail(email.lowercase())
            ?: throw NotFoundException("Não foi encontrado usuário de email $email")

        user.tasks.add(task)

        return userRepository.save(user)
    }

    fun list(): List<Task> = repository.findAll().sortedBy { it.id }

    fun findByIdOrNull(id: Long) = repository.findByIdOrNull(id)

    fun updateDescription(id: Long, description: String): Task? {
        val task = findByIdOrNull(id) ?: throw NotFoundException("Não foi encontrado task de id $id")
        if (description == task.description) {
            return null
        }
        task.description = description
        return repository.save(task)
    }

    fun updateStatus(id: Long, status: Boolean): Task? {
        val task = findByIdOrNull(id) ?: throw NotFoundException("Não foi encontrado task de id $id")
        if (status == task.complete) {
            return null
        }
        task.complete = status
        return repository.save(task)
    }

    fun findUserTasks(email: String): List<Task> {
        val user = userRepository.findByEmail(email.lowercase())
            ?: throw NotFoundException("Não foi encontrado usuário de email $email")

        return user.tasks
    }
}