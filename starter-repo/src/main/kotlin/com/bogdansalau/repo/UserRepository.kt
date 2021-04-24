package com.bogdansalau.repo

import com.bogdansalau.model.User
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.data.mongodb.core.find
import org.springframework.data.mongodb.core.findById
import org.springframework.data.mongodb.core.query.*
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toMono
import javax.annotation.PostConstruct

@Repository
class UserRepository(private val template: ReactiveMongoTemplate) {
    companion object {
        val initialCustomers = listOf(
            User(1, "user1", "aaa"),
            User(2, "user2", "bbb"),
            User(3, "user3", "ccc", User.Telephone("+44", "7123456789")))
    }

    @PostConstruct
    fun initializeRepository() =
        initialCustomers.map(User::toMono).map(this::create).map(Mono<User>::subscribe)

    fun create(user: Mono<User>) = template.save(user)

    fun findById(id: Int) = template.findById<User>(id)

    fun update(newUser: Mono<User>) = newUser.flatMap { template.update(User::class.java)
        .matching(createQuery(it.id))
        .replaceWith(it)
        .`as`(User::class.java)
        .findAndReplace() }

    fun deleteById(id: Int) = template.remove(createQuery(id))

    fun findUser(nameFilter: String) = template.find<User>(
        Query(Criteria.where("name").regex(".*$nameFilter.*", "i"))
    )

    private fun createQuery(id: Int) = Query(Criteria.where("_id").isEqualTo(id))
}
