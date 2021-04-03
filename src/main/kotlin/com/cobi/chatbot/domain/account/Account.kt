package com.cobi.chatbot.domain.account

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Account(
    val loginId: String,
    val password: String,
    var name: String,
    var phone: String
) {

    @Id
    @GeneratedValue
    var id: Long? = null
    var status: Status = Status.PENDING
    var deleted = false
    var cause: String? = null

    fun delete(cause: String) {
        this.deleted = true
        this.cause = cause
    }

    enum class Status {
        PENDING,
        ACTIVATED,
        DEACTIVATED
    }

    companion object
}