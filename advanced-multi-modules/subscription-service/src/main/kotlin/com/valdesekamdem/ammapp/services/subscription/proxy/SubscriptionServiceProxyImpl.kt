package com.valdesekamdem.ammapp.services.subscription.proxy

import com.valdesekamdem.ammapp.proxy.subscription.Subscription
import com.valdesekamdem.ammapp.proxy.subscription.SubscriptionServiceProxy
import com.valdesekamdem.ammapp.services.subscription.subscription.service.SubscriptionService
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList
import org.springframework.stereotype.Service
import com.valdesekamdem.ammapp.services.subscription.subscription.dto.Subscription as InternalSubscription

@Service
class SubscriptionServiceProxyImpl constructor(
    private val subscriptionService: SubscriptionService,
) : SubscriptionServiceProxy {

    override suspend fun getActiveSubscriptions(userId: String): List<Subscription> {
        return subscriptionService.getUserSubscriptions(userId)
            .map { it.toSubscription() }
            .toList()
    }
}

private fun InternalSubscription.toSubscription(): Subscription =
    Subscription(id, planId, userId, startDate, endDate)