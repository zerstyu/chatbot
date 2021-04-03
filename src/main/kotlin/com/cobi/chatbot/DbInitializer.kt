package com.cobi.chatbot

import com.cobi.chatbot.domain.account.Account
import com.cobi.chatbot.domain.account.repository.AccountRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.transaction.annotation.Transactional

@Profile(value = ["default"])
@Configuration
@Transactional
class DbInitializer(
        private val accountRepository: AccountRepository
) : CommandLineRunner {
    override fun run(vararg args: String?) {
        accounts()
    }

    private fun accounts(): List<Long> {
        val accounts = mutableListOf<Account>().apply {
            add(Account("admin", "admin", "admin", "01012341234"))
        }
        accountRepository.saveAll(accounts)
        return accounts.map { it.id!! }
    }
}