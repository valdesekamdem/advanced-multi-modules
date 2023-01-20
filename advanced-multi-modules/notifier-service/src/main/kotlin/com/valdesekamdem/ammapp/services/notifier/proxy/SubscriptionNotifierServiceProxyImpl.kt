package com.valdesekamdem.ammapp.services.notifier.proxy

import com.valdesekamdem.ammapp.proxy.notifier.SubscriptionNotifierServiceProxy
import com.valdesekamdem.ammapp.services.notifier.subscription.Subscription
import com.valdesekamdem.ammapp.services.notifier.subscription.SubscriptionNotifierService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.Instant

@Service
class SubscriptionNotifierServiceProxyImpl @Autowired constructor(
    private val subscriptionNotifierService: SubscriptionNotifierService,
) : SubscriptionNotifierServiceProxy {

    override suspend fun newSubscription(email: String, expirationDate: Instant) {
        val subscription = Subscription(email, expirationDate)
        subscriptionNotifierService.newSubscription(subscription)
    }
}