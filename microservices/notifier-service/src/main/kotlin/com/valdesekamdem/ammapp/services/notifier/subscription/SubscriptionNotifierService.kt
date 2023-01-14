package com.valdesekamdem.ammapp.services.notifier.subscription

interface SubscriptionNotifierService {

    suspend fun newSubscription(subscription: Subscription)
}
