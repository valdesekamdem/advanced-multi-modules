package com.valdesekamdem.ammapp.services.subscription.subscription.service

import com.valdesekamdem.ammapp.services.subscription.subscription.dto.Subscription
import com.valdesekamdem.ammapp.services.subscription.subscription.dto.SubscriptionCreate
import kotlinx.coroutines.flow.Flow

interface SubscriptionService {

    suspend fun subscribe(subscriptionCreate: SubscriptionCreate): Subscription

    suspend fun getUserSubscriptions(userId: String): Flow<Subscription>

    suspend fun getUserActiveSubscriptions(userId: String): Flow<Subscription>
}