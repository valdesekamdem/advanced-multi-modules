package com.valdesekamdem.ammapp.services.user.user.controller

import com.valdesekamdem.ammapp.services.user.user.dto.User
import com.valdesekamdem.ammapp.services.user.user.dto.UserCreate
import com.valdesekamdem.ammapp.services.user.user.dto.UserProfile
import com.valdesekamdem.ammapp.services.user.user.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController @Autowired constructor(
    private val userService: UserService
) {

    @PostMapping
    suspend fun create(@RequestBody userCreate: UserCreate): User {
        return userService.create(userCreate)
    }

    @GetMapping("/profile/{id}")
    suspend fun profile(@PathVariable id: String): UserProfile {
        return userService.getProfile(id)
    }
}
