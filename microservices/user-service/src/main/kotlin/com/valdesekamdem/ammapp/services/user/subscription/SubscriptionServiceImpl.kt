package com.valdesekamdem.ammapp.services.user.subscription

import com.valdesekamdem.ammapp.services.user.configs.ServicesProperties
import com.valdesekamdem.ammapp.services.user.notifier.NotifierServiceImpl
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody
import org.springframework.web.reactive.function.client.awaitExchange
import org.springframework.web.reactive.function.client.createExceptionAndAwait

@Service
class SubscriptionServiceImpl @Autowired constructor(
    webClientBuilder: WebClient.Builder,
    servicesProperties: ServicesProperties
) : SubscriptionService {

    private val logger = LoggerFactory.getLogger(NotifierServiceImpl::class.java.simpleName)

    private val webClient: WebClient = webClientBuilder
        .baseUrl(servicesProperties.subscription)
        .build()

    override suspend fun getActiveSubscriptions(userId: String): List<Subscription> {
        return webClient.get()
            .uri("/subscriptions/user/$userId/active")
            .awaitExchange { response ->
                if (response.statusCode().is2xxSuccessful) {
                    logger.info("Notification sent")
                    response.awaitBody()
                } else {
                    logger.error("Error while sending notification")
                    response.createExceptionAndAwait().printStackTrace()
                    emptyList()
                }
            }
    }
}