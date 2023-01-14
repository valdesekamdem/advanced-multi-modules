package com.valdesekamdem.ammapp.proxy.notifier

interface UserNotifierServiceProxy {

    suspend fun newAccount(user: UserNotifyInfo)
}