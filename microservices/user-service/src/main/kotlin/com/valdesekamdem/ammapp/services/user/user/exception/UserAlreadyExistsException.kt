package com.valdesekamdem.ammapp.services.user.user.exception

class UserAlreadyExistsException(
    override val message: String = "User already exists."
) : RuntimeException(message)