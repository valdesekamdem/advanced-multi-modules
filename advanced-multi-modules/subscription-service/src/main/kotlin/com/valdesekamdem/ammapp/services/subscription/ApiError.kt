package com.valdesekamdem.ammapp.services.subscription

data class ApiError(
    val status: Int,
    val title: String,
    val message: String? = null,
)