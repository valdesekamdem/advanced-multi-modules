package com.valdesekamdem.ammapp.services.subscription

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan("com.valdesekamdem.ammapp.services.subscription.configs")
class SubscriptionServiceApplication

fun main(args: Array<String>) {
	runApplication<SubscriptionServiceApplication>(*args)
}
