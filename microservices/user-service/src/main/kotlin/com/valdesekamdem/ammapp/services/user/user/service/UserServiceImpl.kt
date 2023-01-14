package com.valdesekamdem.ammapp.services.user.user.service

import com.valdesekamdem.ammapp.services.user.notifier.NotifierService
import com.valdesekamdem.ammapp.services.user.subscription.SubscriptionService
import com.valdesekamdem.ammapp.services.user.user.dto.User
import com.valdesekamdem.ammapp.services.user.user.dto.UserCreate
import com.valdesekamdem.ammapp.services.user.user.dto.UserProfile
import com.valdesekamdem.ammapp.services.user.user.exception.UserAlreadyExistsException
import com.valdesekamdem.ammapp.services.user.user.exception.UserNotFoundException
import com.valdesekamdem.ammapp.services.user.user.mapper.toEntity
import com.valdesekamdem.ammapp.services.user.user.mapper.toProfile
import com.valdesekamdem.ammapp.services.user.user.mapper.toUser
import com.valdesekamdem.ammapp.services.user.user.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserServiceImpl @Autowired constructor(
    private val userRepository: UserRepository,
    private val notifierService: NotifierService,
    private val subscriptionService: SubscriptionService,
) : UserService {

    override suspend fun create(user: UserCreate): User {
        val existingUser = userRepository.findByEmail(user.email)
        if (existingUser != null) {
            throw UserAlreadyExistsException()
        }

        val userEntity = userRepository.save(user.toEntity())
        return userEntity.toUser().also {
            notifierService.newAccount(it)
        }
    }

    override suspend fun getProfile(id: String): UserProfile {
        val userEntity = userRepository.findById(id)

        if (userEntity != null) {
            val subscriptions = subscriptionService.getActiveSubscriptions(id)
            return userEntity.toProfile(subscriptions)
        } else {
            throw UserNotFoundException()
        }
    }
}