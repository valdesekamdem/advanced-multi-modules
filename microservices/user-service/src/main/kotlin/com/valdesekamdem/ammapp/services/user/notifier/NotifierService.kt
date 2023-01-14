package com.valdesekamdem.ammapp.services.user.notifier

import com.valdesekamdem.ammapp.services.user.user.dto.User

interface NotifierService {

    suspend fun newAccount(user: User)
}