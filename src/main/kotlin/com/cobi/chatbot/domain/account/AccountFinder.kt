package com.cobi.chatbot.domain.account

import com.cobi.chatbot.domain.account.repository.AccountRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class AccountFinder(
        private val accountRepository: AccountRepository
) {

    fun findAll(): List<Account> {
        return accountRepository.findAll()
    }
}