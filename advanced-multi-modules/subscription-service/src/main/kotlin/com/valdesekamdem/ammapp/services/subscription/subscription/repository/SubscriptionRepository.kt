package com.valdesekamdem.ammapp.services.subscription.subscription.repository

import com.valdesekamdem.ammapp.services.subscription.subscription.model.SubscriptionEntity
import kotlinx.coroutines.flow.Flow
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository
import java.time.Instant

@Repository
interface SubscriptionRepository : CoroutineCrudRepository<SubscriptionEntity, String> {

    fun findByUserIdOrderByEndDateDesc(userId: String): Flow<SubscriptionEntity>

    fun findByUserIdAndEndDateGreaterThanEqualOrderByEndDate(userId: String, date: Instant): Flow<SubscriptionEntity>
}