package com.valdesekamdem.ammapp.services.user.user.repository

import com.valdesekamdem.ammapp.services.user.user.model.UserEntity
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : CoroutineCrudRepository<UserEntity, String> {

    suspend fun findByEmail(email: String): UserEntity?
}