package br.puc.doit.users

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController (
    val service: UserService
) {
    @PostMapping
    fun insert(@RequestBody user: User) =
        service.insert(user)
            .let { ResponseEntity.ok(it) }
            .let { ResponseEntity.status(HttpStatus.CREATED).body(it) }


    @GetMapping("/{email}")
    fun findByEmail(@PathVariable email: String) =
        service.findByEmail(email)
            ?.let { ResponseEntity.ok(it) }
            ?:ResponseEntity.notFound().build()
}