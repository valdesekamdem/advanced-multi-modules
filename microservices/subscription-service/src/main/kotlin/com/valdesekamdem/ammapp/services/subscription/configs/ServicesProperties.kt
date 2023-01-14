package com.valdesekamdem.ammapp.services.subscription.configs

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "services")
data class ServicesProperties(
    val notifier: String,
)