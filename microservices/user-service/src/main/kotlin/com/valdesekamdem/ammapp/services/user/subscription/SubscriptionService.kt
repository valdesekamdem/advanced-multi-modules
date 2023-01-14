package com.valdesekamdem.ammapp.services.user.subscription

import kotlinx.coroutines.flow.Flow

interface SubscriptionService {

    suspend fun getActiveSubscriptions(userId: String): List<Subscription>
}