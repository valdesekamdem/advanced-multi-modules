package com.valdesekamdem.ammapp.services.subscription.plan.model

import org.springframework.data.annotation.Id
import org.springframework.data.annotation.Version
import org.springframework.data.mongodb.core.mapping.Document

@Document("plans")
class PlanEntity(
    var title: String,
    var description: String,
    var durationInWeeks: Int,
    @Id
    var id: String? = null,
    @Version
    var version: Int = 0,
)