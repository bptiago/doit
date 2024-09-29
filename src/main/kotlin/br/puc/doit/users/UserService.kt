package br.puc.doit.users

import br.puc.doit.users.errors.BadRequestException
import org.springframework.stereotype.Service

@Service
class UserService(
    val repository: UserRepository
) {
    fun insert(user: User): User {
        if (repository.findByEmail(user.email) != null)
            throw BadRequestException("Usuário com email ${user.email} já existe!")

        return repository.save(user)
    }

    fun findByEmail(email: String): User? {
        return repository.findByEmail(email)
    }
}