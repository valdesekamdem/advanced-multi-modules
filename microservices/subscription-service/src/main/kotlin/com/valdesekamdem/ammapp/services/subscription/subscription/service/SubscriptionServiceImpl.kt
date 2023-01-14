package com.valdesekamdem.ammapp.services.subscription.subscription.service

import com.valdesekamdem.ammapp.services.subscription.notifier.NotifierService
import com.valdesekamdem.ammapp.services.subscription.plan.service.PlanService
import com.valdesekamdem.ammapp.services.subscription.subscription.mapper.toSubscription
import com.valdesekamdem.ammapp.services.subscription.subscription.dto.Subscription
import com.valdesekamdem.ammapp.services.subscription.subscription.dto.SubscriptionCreate
import com.valdesekamdem.ammapp.services.subscription.subscription.model.SubscriptionEntity
import com.valdesekamdem.ammapp.services.subscription.subscription.repository.SubscriptionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.Instant
import java.time.temporal.ChronoUnit

@Service
class SubscriptionServiceImpl @Autowired constructor(
    private val subscriptionRepository: SubscriptionRepository,
    private val planService: PlanService,
    private val notifierService: NotifierService
) : SubscriptionService {

    override suspend fun subscribe(subscriptionCreate: SubscriptionCreate): Subscription {
        val (planId, userId, email) = subscriptionCreate
        val plan = planService.getById(planId)

        val latestActiveSubscription = subscriptionRepository
            .findByUserIdAndEndDateGreaterThanEqualOrderByEndDate(userId, Instant.now())
            .firstOrNull()

        val startDate = if (latestActiveSubscription != null) {
            latestActiveSubscription.endDate.minusSeconds(5)
        } else {
            Instant.now()
        }
        val endDate = startDate.plus(plan.durationInDays.toLong(), ChronoUnit.DAYS)

        val entity = SubscriptionEntity(planId, userId, startDate, endDate)
        return subscriptionRepository.save(entity)
            .toSubscription()
            .also {
                notifierService.newSubscription(email, endDate)
            }
    }

    override suspend fun getUserSubscriptions(userId: String): Flow<Subscription> {
        return subscriptionRepository.findByUserIdOrderByEndDateDesc(userId)
            .map { it.toSubscription() }
    }

    override suspend fun getUserActiveSubscriptions(userId: String): Flow<Subscription> {
        return subscriptionRepository.findByUserIdAndEndDateGreaterThanEqualOrderByEndDate(userId, Instant.now())
            .map { it.toSubscription() }
    }
}