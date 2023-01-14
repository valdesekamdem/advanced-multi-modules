package com.valdesekamdem.ammapp.services.subscription.plan.service

import com.valdesekamdem.ammapp.services.subscription.plan.dto.Plan
import com.valdesekamdem.ammapp.services.subscription.plan.dto.PlanCreate
import com.valdesekamdem.ammapp.services.subscription.plan.exception.PlanNotFoundException
import com.valdesekamdem.ammapp.services.subscription.plan.mapper.toEntity
import com.valdesekamdem.ammapp.services.subscription.plan.mapper.toPlan
import com.valdesekamdem.ammapp.services.subscription.plan.repository.PlanRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PlanServiceImpl @Autowired constructor(
    private val planRepository: PlanRepository,
) : PlanService {

    override suspend fun create(planCreate: PlanCreate): Plan {
        val entity = planCreate.toEntity()
        return planRepository.save(entity)
            .toPlan()
    }

    override fun getAll(): Flow<Plan> {
        return planRepository.findAll()
            .map { it.toPlan() }
    }

    override suspend fun getById(id: String): Plan {
        return planRepository.findById(id)?.toPlan()
            ?: throw PlanNotFoundException()
    }
}
