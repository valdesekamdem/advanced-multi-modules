package com.valdesekamdem.ammapp.services.subscription.subscription.model

import org.springframework.data.annotation.Id
import org.springframework.data.annotation.Version
import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant

@Document("subscriptions")
class SubscriptionEntity(
    var planId: String,
    var userId: String,
    var startDate: Instant,
    var endDate: Instant,
    @Id
    var id: String? = null,
    @Version
    var version: Int = 0
)