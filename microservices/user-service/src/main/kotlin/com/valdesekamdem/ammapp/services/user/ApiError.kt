package com.valdesekamdem.ammapp.services.user

data class ApiError(
    val status: Int,
    val title: String,
    val message: String? = null,
)