package com.valdesekamdem.ammapp.proxy.notifier

import java.time.Instant

interface SubscriptionNotifierServiceProxy {

    suspend fun newSubscription(email: String, expirationDate: Instant)
}