package com.bogdansalau.model

import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "Users")
data class User(val id: Int = 0, val username: String = "", val password: String, val telephone: Telephone? = null) {
    data class Telephone(val countryCode: String = "", val telephoneNumber: String = "")
}
