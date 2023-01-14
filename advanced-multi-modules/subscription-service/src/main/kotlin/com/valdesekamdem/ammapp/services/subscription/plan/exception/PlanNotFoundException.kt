package com.valdesekamdem.ammapp.services.subscription.plan.exception

class PlanNotFoundException(
    override val message: String = "Plan not found",
) : RuntimeException()