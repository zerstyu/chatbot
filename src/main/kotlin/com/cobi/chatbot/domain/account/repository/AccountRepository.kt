package com.cobi.chatbot.domain.account.repository

import com.cobi.chatbot.domain.account.Account
import org.springframework.data.jpa.repository.JpaRepository

interface AccountRepository : JpaRepository<Account, Long>