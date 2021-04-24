package com.bogdansalau.service.impl

import com.bogdansalau.model.User
import com.bogdansalau.repo.UserRepository
import com.bogdansalau.service.UserService
import reactor.core.publisher.Mono

class UserServiceImpl: UserService {

    lateinit var userRepository: UserRepository

    override fun createUser(user: Mono<User>) = userRepository.create(user)

    override fun getUser(id: Int) = userRepository.findById(id)

    override fun updateUser(newUser: Mono<User>) = userRepository.update(newUser)

    override fun deleteUser(id: Int) = userRepository.deleteById(id).map { it.deletedCount > 0 }

    override fun searchUsers(nameFilter: String) = userRepository.findUser(nameFilter)

}
