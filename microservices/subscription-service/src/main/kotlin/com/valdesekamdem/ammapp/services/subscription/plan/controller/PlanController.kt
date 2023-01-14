package com.valdesekamdem.ammapp.services.subscription.plan.controller

import com.valdesekamdem.ammapp.services.subscription.plan.dto.Plan
import com.valdesekamdem.ammapp.services.subscription.plan.dto.PlanCreate
import com.valdesekamdem.ammapp.services.subscription.plan.service.PlanService
import kotlinx.coroutines.flow.Flow
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/plans")
class PlanController @Autowired constructor(
    private val planService: PlanService
) {

    @PostMapping
    suspend fun create(@RequestBody planCreate: PlanCreate): Plan {
        return planService.create(planCreate)
    }

    @GetMapping
    suspend fun getAll(): Flow<Plan> {
        return planService.getAll()
    }
}
