package com.bogdansalau.service

import com.bogdansalau.model.User
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface UserService {
    fun createUser(user: Mono<User>): Mono<User>
    fun getUser(id: Int): Mono<User>
    fun updateUser(newUser: Mono<User>): Mono<User>
    fun deleteUser(id: Int): Mono<Boolean>

    fun searchUsers(nameFilter: String): Flux<User>
}
