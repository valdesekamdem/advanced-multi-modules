package com.valdesekamdem.ammapp.proxy.subscription

import java.time.Instant

class Subscription(
    var id: String,
    var planId: String,
    var userId: String,
    var startDate: Instant,
    var endDate: Instant,
)