package com.valdesekamdem.ammapp.services.user.user.exception

class UserNotFoundException(
    override val message: String = "User not found",
) : RuntimeException()