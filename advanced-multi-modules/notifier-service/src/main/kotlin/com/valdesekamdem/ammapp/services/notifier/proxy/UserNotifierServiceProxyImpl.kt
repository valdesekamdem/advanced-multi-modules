package com.valdesekamdem.ammapp.services.notifier.proxy

import com.valdesekamdem.ammapp.proxy.notifier.UserNotifierServiceProxy
import com.valdesekamdem.ammapp.proxy.notifier.UserNotifyInfo
import com.valdesekamdem.ammapp.services.notifier.user.Account
import com.valdesekamdem.ammapp.services.notifier.user.UserNotifierService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserNotifierServiceProxyImpl @Autowired constructor(
    private val userNotifierService: UserNotifierService,
) : UserNotifierServiceProxy {

    override suspend fun newAccount(user: UserNotifyInfo) {
        val account = Account(user.name, user.email)
        userNotifierService.newAccount(account)
    }
}