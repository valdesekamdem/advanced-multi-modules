package com.valdesekamdem.ammapp.services.subscription.notifier

import java.time.Instant

interface NotifierService {

    suspend fun newSubscription(email: String, expirationDate: Instant)
}