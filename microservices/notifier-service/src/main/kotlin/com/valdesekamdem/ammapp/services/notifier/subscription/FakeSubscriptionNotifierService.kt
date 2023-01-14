package com.valdesekamdem.ammapp.services.notifier.subscription

import kotlinx.coroutines.delay
import kotlinx.coroutines.reactor.mono
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.text.SimpleDateFormat
import java.util.*

@Service
class FakeSubscriptionNotifierService : SubscriptionNotifierService {

    private val logger = LoggerFactory.getLogger(FakeSubscriptionNotifierService::class.java.simpleName)

    override suspend fun newSubscription(subscription: Subscription) {
        logger.info("\n------ Sending email to ${subscription.email} ......")
        mono {
            delay(5_000)

            val formatter = SimpleDateFormat("dd MMM yyyy HH:mm:ss")
            val expirationDate = formatter.format(Date.from(subscription.expirationDate))

            val message = """
            *****************************************************    
            *   Hi,                                             *
            *   Thank you for activating a new subscription.     *
            *   Now you have access to all the resources.       *
            *   Expiration date: $expirationDate                
            *   Sincerely.                                      *
            *****************************************************    
            """
            logger.info(message)
        }.subscribe()
    }
}