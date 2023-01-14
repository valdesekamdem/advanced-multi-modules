package com.valdesekamdem.ammapp.services.subscription.plan.mapper

import com.valdesekamdem.ammapp.services.subscription.plan.dto.Plan
import com.valdesekamdem.ammapp.services.subscription.plan.dto.PlanCreate
import com.valdesekamdem.ammapp.services.subscription.plan.model.PlanEntity

fun PlanEntity.toPlan(): Plan =
    Plan(id!!, title, description, durationInWeeks)

fun PlanCreate.toEntity(): PlanEntity =
    PlanEntity(title, description, durationInWeeks)