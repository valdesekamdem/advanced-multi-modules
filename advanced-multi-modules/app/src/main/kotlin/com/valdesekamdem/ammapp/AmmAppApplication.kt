package com.valdesekamdem.ammapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan("com.valdesekamdem.ammapp.services")
class AmmAppApplication

fun main(args: Array<String>) {
    runApplication<AmmAppApplication>(*args)
}
