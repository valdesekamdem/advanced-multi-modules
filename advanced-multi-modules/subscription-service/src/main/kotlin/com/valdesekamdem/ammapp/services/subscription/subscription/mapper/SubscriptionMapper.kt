package com.valdesekamdem.ammapp.services.subscription.subscription.mapper

import com.valdesekamdem.ammapp.services.subscription.subscription.dto.Subscription
import com.valdesekamdem.ammapp.services.subscription.subscription.model.SubscriptionEntity

fun SubscriptionEntity.toSubscription(): Subscription =
    Subscription(id!!, planId, userId, startDate, endDate)
