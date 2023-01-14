package com.valdesekamdem.ammapp.services.user.notifier

import com.valdesekamdem.ammapp.services.user.configs.ServicesProperties
import com.valdesekamdem.ammapp.services.user.user.dto.User
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitExchange
import org.springframework.web.reactive.function.client.createExceptionAndAwait

@Service
class NotifierServiceImpl @Autowired constructor(
    webClientBuilder: WebClient.Builder,
    servicesProperties: ServicesProperties
) : NotifierService {

    private val logger = LoggerFactory.getLogger(NotifierServiceImpl::class.java.simpleName)

    private val webClient: WebClient = webClientBuilder
        .baseUrl(servicesProperties.notifier)
        .build()

    override suspend fun newAccount(user: User) {
        webClient.post()
            .uri("/user/new")
            .bodyValue(user)
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