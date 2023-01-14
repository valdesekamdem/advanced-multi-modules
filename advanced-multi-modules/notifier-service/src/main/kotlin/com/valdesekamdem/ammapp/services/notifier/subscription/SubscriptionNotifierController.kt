package com.valdesekamdem.ammapp.services.notifier.subscription

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/subscription")
class SubscriptionNotifierController constructor(
    private val subscriptionNotifierService: SubscriptionNotifierService,
) {

    @PostMapping("/new")
    suspend fun newAccount(@RequestBody subscription: Subscription) {
        subscriptionNotifierService.newSubscription(subscription)
    }
}
