package com.valdesekamdem.ammapp.services.user.configs

import com.valdesekamdem.ammapp.services.user.subscription.Subscription
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "services")
data class ServicesProperties(
    val notifier: String,
    val subscription: String,
)