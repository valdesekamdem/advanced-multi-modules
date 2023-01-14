package com.valdesekamdem.ammapp.services.subscription.plan.repository

import com.valdesekamdem.ammapp.services.subscription.plan.model.PlanEntity
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PlanRepository: CoroutineCrudRepository<PlanEntity, String>