package com.valdesekamdem.ammapp.services.subscription.plan.service

import com.valdesekamdem.ammapp.services.subscription.plan.dto.Plan
import com.valdesekamdem.ammapp.services.subscription.plan.dto.PlanCreate
import kotlinx.coroutines.flow.Flow

interface PlanService {

    suspend fun create(planCreate: PlanCreate): Plan

    fun getAll(): Flow<Plan>

    suspend fun getById(id: String): Plan
}