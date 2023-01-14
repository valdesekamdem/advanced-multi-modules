package com.valdesekamdem.ammapp.proxy.subscription

interface SubscriptionServiceProxy {

    suspend fun getActiveSubscriptions(userId: String): List<Subscription>
}