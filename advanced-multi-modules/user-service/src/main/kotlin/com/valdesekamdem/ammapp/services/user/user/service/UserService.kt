package com.valdesekamdem.ammapp.services.user.user.service

import com.valdesekamdem.ammapp.services.user.user.dto.User
import com.valdesekamdem.ammapp.services.user.user.dto.UserCreate
import com.valdesekamdem.ammapp.services.user.user.dto.UserProfile

interface UserService {

    suspend fun create(user: UserCreate): User

    suspend fun getProfile(id: String): UserProfile
}