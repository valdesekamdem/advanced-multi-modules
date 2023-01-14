package com.valdesekamdem.ammapp.services.subscription.plan

import com.valdesekamdem.ammapp.services.subscription.plan.model.PlanEntity
import com.valdesekamdem.ammapp.services.subscription.plan.repository.PlanRepository
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.runBlocking
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

@Component
class PlanInitializer constructor(
    private val planRepository: PlanRepository,
) {
    private val logger: Logger = LoggerFactory.getLogger(PlanInitializer::class.java)

    @PostConstruct
    private fun initPlans() = runBlocking {
        if (planRepository.count() == 0L) {
            planRepository.saveAll(defaultPlans()).last()
            logger.info("Database populated")
        } else {
            logger.info("Data exist. Thank you for checking")
        }
    }
}


private fun defaultPlans(): List<PlanEntity> = listOf(
    PlanEntity("Weekly", "7 days subscription", 7),
    PlanEntity("Monthly", "Subscription for a month, 31 days", 31),
    PlanEntity("Yearly", " Subscription for a year, 365 days", 365),
)
