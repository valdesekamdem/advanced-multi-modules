package com.valdesekamdem.ammapp.services.subscription.notifier

import com.valdesekamdem.ammapp.services.subscription.configs.ServicesProperties
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitExchange
import org.springframework.web.reactive.function.client.createExceptionAndAwait
import java.time.Instant

@Service
class NotifierServiceImpl @Autowired constructor(
    webClientBuilder: WebClient.Builder,
    servicesProperties: ServicesProperties
) : NotifierService {

    private val logger = LoggerFactory.getLogger(NotifierServiceImpl::class.java.simpleName)

    private val webClient: WebClient = webClientBuilder
        .baseUrl(servicesProperties.notifier)
        .build()

    override suspend fun newSubscription(email: String, expirationDate: Instant) {
        val payload = NewSubscription(email, expirationDate)

        webClient.post()
            .uri("/subscription/new")
            .bodyValue(payload)
            .awaitExchange { response ->
                if (response.statusCode().is2xxSuccessful) {
                    logger.info("Notification sent")
                } else {
                    logger.error("Error while sending notification")
                    response.createExceptionAndAwait().printStackTrace()
                }
            }
    }
}

private data class NewSubscription(
    val email: String,
    val expirationDate: Instant
)