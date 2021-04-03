package com.cobi.chatbot.domain.account.api

import com.cobi.chatbot.domain.account.Account
import com.cobi.chatbot.domain.account.AccountFinder
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Api(tags = ["Account"], description = "계정")
@RestController
@RequestMapping("/accounts")
class AccountController(
        private val accountFinder: AccountFinder
) {

    @ApiOperation("계정 리스트 조회", notes = "계정 리스트를 조회한다")
    @GetMapping
    fun findAll(): List<Account> {
        return accountFinder.findAll()
    }
}