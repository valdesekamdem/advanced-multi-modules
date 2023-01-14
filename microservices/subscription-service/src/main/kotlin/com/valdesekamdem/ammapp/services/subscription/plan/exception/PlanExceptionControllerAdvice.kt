package com.valdesekamdem.ammapp.services.subscription.plan.exception

import com.valdesekamdem.ammapp.services.subscription.ApiError
import com.valdesekamdem.ammapp.services.subscription.getResponseEntity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class PlanExceptionControllerAdvice {

    @ExceptionHandler
    fun handleUserAlreadyExistsException(exception: PlanNotFoundException): ResponseEntity<com.valdesekamdem.ammapp.services.subscription.ApiError> {
        val httpStatus = HttpStatus.NOT_FOUND
        return getResponseEntity(httpStatus, exception)
    }
}