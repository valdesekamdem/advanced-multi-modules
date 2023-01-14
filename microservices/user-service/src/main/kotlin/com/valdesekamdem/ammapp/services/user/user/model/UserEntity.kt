package com.valdesekamdem.ammapp.services.user.user.model

import org.springframework.data.annotation.Id
import org.springframework.data.annotation.Version
import org.springframework.data.mongodb.core.mapping.Document

@Document("users")
data class UserEntity(
    var name: String,
    var email: String,
    var password: String,
    @Id
    var id: String? = null,
    @Version
    var version: Int = 0,
)