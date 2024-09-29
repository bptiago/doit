package br.puc.doit.users

import br.puc.doit.errors.BadRequestException
import org.springframework.stereotype.Service

@Service
class UserService(
    val repository: UserRepository
) {
    fun insert(user: User): User {

        if (repository.findByEmail(user.email.lowercase()) != null)
            throw BadRequestException("Usuário com email ${user.email} já existe!")

        user.email = user.email.lowercase()

        return repository.save(user)
    }

    fun findByEmail(email: String): User? {
        return repository.findByEmail(email.lowercase())
    }
}