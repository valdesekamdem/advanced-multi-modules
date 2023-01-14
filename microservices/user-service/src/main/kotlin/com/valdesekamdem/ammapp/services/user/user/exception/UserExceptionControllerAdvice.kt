package com.valdesekamdem.ammapp.services.user.user.exception

import com.valdesekamdem.ammapp.services.user.ApiError
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.lang.Exception

@ControllerAdvice
class UserExceptionControllerAdvice {

    @ExceptionHandler
    fun handleUserAlreadyExistsException(exception: UserAlreadyExistsException): ResponseEntity<com.valdesekamdem.ammapp.services.user.ApiError> {
        val httpStatus = HttpStatus.BAD_REQUEST
        return getResponseEntity(httpStatus, exception)
    }

    @ExceptionHandler
    fun handleUserAlreadyExistsException(exception: UserNotFoundException): ResponseEntity<com.valdesekamdem.ammapp.services.user.ApiError> {
        val httpStatus = HttpStatus.NOT_FOUND
        return getResponseEntity(httpStatus, exception)
    }

    @ExceptionHandler
    fun handleException(exception: Exception): ResponseEntity<com.valdesekamdem.ammapp.services.user.ApiError> {
        val httpStatus = HttpStatus.INTERNAL_SERVER_ERROR
        return getResponseEntity(httpStatus, exception)
    }

    private fun getResponseEntity(
        httpStatus: HttpStatus,
        exception: Exception,
    ): ResponseEntity<com.valdesekamdem.ammapp.services.user.ApiError> {
        val error = com.valdesekamdem.ammapp.services.user.ApiError(
            status = httpStatus.value(),
            title = httpStatus.reasonPhrase,
            message = exception.message
        )

        return ResponseEntity(error, httpStatus)
    }
}