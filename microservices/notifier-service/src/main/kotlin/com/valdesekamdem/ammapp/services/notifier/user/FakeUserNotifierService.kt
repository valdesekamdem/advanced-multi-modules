package com.valdesekamdem.ammapp.services.notifier.user

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.reactor.mono
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class FakeUserNotifierService : UserNotifierService {

    private val logger = LoggerFactory.getLogger(FakeUserNotifierService::class.java.simpleName)

    override suspend fun newAccount(account: Account) {
        logger.info("\n----- Sending email to ${account.email} .......")
        mono {
            delay(5_000)
            val message = """
            *********************************************************************
            *    Hi ${account.name},                                            *
            *    Your account has been created successfully.                    *
            *    You can subscribe to a plan, and start your learning journey   *
            *    Sincerely.                                                     *
            *********************************************************************
            """
            logger.info(message)
        }.subscribe()
    }
}