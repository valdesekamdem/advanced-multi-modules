package com.valdesekamdem.ammapp.services.notifier.user

interface UserNotifierService {
    suspend fun newAccount(account: Account)
}