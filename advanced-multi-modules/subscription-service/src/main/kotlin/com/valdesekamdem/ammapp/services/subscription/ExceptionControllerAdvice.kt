package com.valdesekamdem.ammapp.services.subscription

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ExceptionControllerAdvice {

    @ExceptionHandler
    fun handleException(exception: Exception): ResponseEntity<com.valdesekamdem.ammapp.services.subscription.ApiError> {
        val httpStatus = HttpStatus.INTERNAL_SERVER_ERROR
        return getResponseEntity(httpStatus, exception)
    }
}

fun getResponseEntity(
    httpStatus: HttpStatus,
    exception: Exception,
): ResponseEntity<com.valdesekamdem.ammapp.services.subscription.ApiError> {
    val error = com.valdesekamdem.ammapp.services.subscription.ApiError(
        status = httpStatus.value(),
        title = httpStatus.reasonPhrase,
        message = exception.message
    )

    return ResponseEntity(error, httpStatus)
}