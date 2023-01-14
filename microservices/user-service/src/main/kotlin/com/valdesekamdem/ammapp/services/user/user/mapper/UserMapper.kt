package com.valdesekamdem.ammapp.services.user.user.mapper

import com.valdesekamdem.ammapp.services.user.subscription.Subscription
import com.valdesekamdem.ammapp.services.user.user.model.UserEntity
import com.valdesekamdem.ammapp.services.user.user.dto.User
import com.valdesekamdem.ammapp.services.user.user.dto.UserCreate
import com.valdesekamdem.ammapp.services.user.user.dto.UserProfile

fun UserEntity.toUser(): User =
    User(id!!, name, email)

fun UserCreate.toEntity(): UserEntity =
    UserEntity(name, email, password)

fun UserEntity.toProfile(subscriptions: List<Subscription>): UserProfile =
    UserProfile(id!!, name, email, subscriptions)
