package com.valdesekamdem.ammapp.services.subscription.subscription.controller

import com.valdesekamdem.ammapp.services.subscription.subscription.service.SubscriptionService
import com.valdesekamdem.ammapp.services.subscription.subscription.dto.Subscription
import com.valdesekamdem.ammapp.services.subscription.subscription.dto.SubscriptionCreate
import kotlinx.coroutines.flow.Flow
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/subscriptions")
class SubscriptionController constructor(
    private val subscriptionService: SubscriptionService
) {

    @PostMapping("/new")
    suspend fun subscribe(@RequestBody subscriptionCreate: SubscriptionCreate): Subscription {
        return subscriptionService.subscribe(subscriptionCreate)
    }

    @GetMapping("/user/{userId}")
    suspend fun getUserSubscriptions(@PathVariable userId: String): Flow<Subscription> {
        return subscriptionService.getUserSubscriptions(userId)
    }

    @GetMapping("/user/{userId}/active")
    suspend fun getUserActiveSubscriptions(@PathVariable userId: String): Flow<Subscription> {
        return subscriptionService.getUserActiveSubscriptions(userId)
    }
}