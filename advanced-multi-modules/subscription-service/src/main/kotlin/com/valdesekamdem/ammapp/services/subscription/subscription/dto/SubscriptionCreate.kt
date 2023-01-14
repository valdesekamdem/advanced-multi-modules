package com.valdesekamdem.ammapp.services.subscription.subscription.dto

data class SubscriptionCreate(
    var planId: String,
    var userId: String,
    var email: String,
)