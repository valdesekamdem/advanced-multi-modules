package com.valdesekamdem.ammapp.services.notifier.user

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserNotifierController constructor(
    private val userNotifierService: UserNotifierService
) {

    @PostMapping("/new")
    suspend fun newAccount(@RequestBody account: Account) {
        userNotifierService.newAccount(account)
    }
}
